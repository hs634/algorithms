__author__ = 'hs634'

def all_perms(text):
    if not text:
        return []
    n = len(text)
    for i in range(2**n):
        perm = ''
        for j in range(n):
            perm += text[j].upper() if is_bit_set(i, j) else text[j]
        print perm

def is_bit_set(n ,offset):
    return (n >> offset & 1) != 0




all_perms("ab")