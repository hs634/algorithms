__author__ = 'hs634'

import sys, re
import uuid


class CIDRtoIPRange(object):
    def ip2bin(self, ip):
        """
        convert an IP address from its dotted-quad format to its
        32 binary digit representation
        """
        b = ""
        inQuads = ip.split(".")
        outQuads = 4
        for q in inQuads:
            if q != "":
                b += self.dec2bin(int(q), 8)
                outQuads -= 1
        while outQuads > 0:
            b += "00000000"
            outQuads -= 1
        return b

    def dec2bin(self, n, d=None):
        """
        convert a decimal number to binary representation
        if d is specified, left-pad the binary number with 0s to that length
        :param n:
        :param d:
        :return:
        """
        s = ""
        while n > 0:
            if n & 1:
                s = "1" + s
            else:
                s = "0" + s
            n >>= 1
        if d is not None:
            while len(s) < d:
                s = "0" + s
        if s == "": s = "0"
        return s


    def bin2ip(self, b):
        """
        convert a binary string into an IP address
        :param b:
        :return:
        """
        ip = ""
        for i in range(0, len(b), 8):
            ip += str(int(b[i:i + 8], 2)) + "."
        return ip[:-1]


    def _CIDR_to_ip_list(self, c):
        """
        return a list of IP addresses based on the CIDR block specified
        :param c:
        :return:
        """
        parts = c.split("/")
        baseIP = self.ip2bin(parts[0])
        subnet = int(parts[1])

        # if a subnet of 32 was specified simply print the single IP
        if subnet == 32:
            return [self.bin2ip(baseIP)]
        # for any other size subnet, print a list of IP addresses by concatenating
        # the prefix with each of the suffixes in the subnet
        else:
            ip_range_list = []
            ipPrefix = baseIP[:-(32 - subnet)]
            for i in range(1, (2 ** (32 - subnet))-1):
                ip_range_list.append(self.bin2ip(ipPrefix + self.dec2bin(i,
                                                                    (32 - subnet))))
            return ip_range_list

    def validateCIDRBlock(self, b):
        """
        input validation routine for the CIDR block specified
        :param b:
        :return:
        """
        # appropriate format for CIDR block ($prefix/$subnet)
        p = re.compile("^([0-9]{1,3}\.){0,3}[0-9]{1,3}(/[0-9]{1,2}){1}$")
        if not p.match(b):
            print "Error: Invalid CIDR format!"
            return False
        # extract prefix and subnet size
        prefix, subnet = b.split("/")
        # each quad has an appropriate value (1-255)
        quads = prefix.split(".")
        for q in quads:
            if (int(q) < 0) or (int(q) > 255):
                print "Error: quad " + str(q) + " wrong size."
                return False
        # subnet is an appropriate value (1-32)
        if (int(subnet) < 1) or (int(subnet) > 32):
            print "Error: subnet " + str(subnet) + " wrong size."
            return False
        # passed all checks -> return True
        return True


    def CIDR_to_ip_range(self, cidr_str):
        if not cidr_str:
            return []
        if not self.validateCIDRBlock(cidr_str):
            raise Exception("Invalid CIDR")

        return self._CIDR_to_ip_list(cidr_str)


print CIDRtoIPRange().CIDR_to_ip_range("192.168.122.65/24")

def generate_ironic_node_create(cidr):
    tenant_name = 'tenant'
    os_user = 'user'
    by_password = 'password'
    auth_url = 'dummy'
    ip_list = CIDRtoIPRange().CIDR_to_ip_range(cidr)
    for ip in ip_list:
        ytag = str(uuid.uuid4().get_hex()[:3])
        hname = ytag + '.ostk.corp.gq1.yahoo.com'
        command = ('ironic --os-project-name %(tenant_name)s '
                   '--os-username %(os_user)s --os-password %('
                   'yahoo_by_password)s --os-auth-url %('
                   'identity_public_endpoint)s node-create -d %(driver)s -u %('
                   'uuid)s -i mac_addresses=%(mac)s -i ip_address=%(ip)s -i '
                   'ssh_username=%(ssh_username)s -i ssh_virt_type=%('
                   'virt_type)s -i ytag=%(ytag)s -i ssh_address=%(ssh_addr)s '
                   '-i ssh_key_filename=%(ssh_key)s -p cpus=%(vcpus)s -p '
                   'local_gb=%(vm_disksize_gb)s -p memory_mb=%(memory_mb)s -i '
                   'hostname=%(hname)s -e yahoo_opsdb_inventory_import=False' %
                   {'tenant_name': tenant_name,
                    'os_user': os_user,
                    'yahoo_by_password': by_password,
                    'identity_public_endpoint': auth_url,
                    'driver': 'fake_pxe',
                    'uuid': str(uuid.uuid4()),
                    'mac': "52:54:00:08:ae:d5,52:54:00:08:ae:0" + ip[-1],
                    'ip': ip,
                    'ssh_username': 'fake_pxe_user',
                    'virt_type': 'virsh',
                    'ytag': ytag,
                    'ssh_addr': ip_list[0],
                    'ssh_key': '/etc/ironic/id_rsa_pxessh',
                    'vcpus': '2',
                    'vm_disksize_gb': '20',
                    'memory_mb': '2048',
                    'hname': hname
                   })
        print command

generate_ironic_node_create("192.168.122.65/24")




