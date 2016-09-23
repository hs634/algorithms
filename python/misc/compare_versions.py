class Solution(object):
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        vl1 = version1.split(".")
        vl2 = version2.split(".")

        for i in range(min(len(vl1), len(vl2))):
            if int(vl1[i]) > int(vl2[i]):
                return 1
            elif int(vl1[i]) < int(vl2[i]):
                return -1


        if i < len(vl1) - 1:
            return 1
        elif i < len(vl2) - 1:
            return -1
        return 0

print Solution().compareVersion("1.1.1", "1.1.1")