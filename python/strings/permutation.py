__author__ = 'hs634'

from itertools import permutations, combinations

k = ["".join(i) for i in permutations("abc")]
print k
stuff = "abc"
for m in range(len(stuff)+1):
    for i in combinations("abc", m):
        print "".join(i)

def permute(s):
    if s is None:
        return None
    return [s] if len(s) == 1 else [c+perm for i,c in enumerate(s) for perm in
                                  permute(s[:i] + s[i+1:])]

lex = ["tea","ate"]
def permute2(s):
    if s is None:
        return None
    if len(s) == 1:
        return [s]
    res = []
    for i,c in enumerate(s):
        for perm in permute2(s[:i] + s[i+1:]):
            if c+perm in lex:
                return True
            res += [c+perm]
    return res

print permute2("eat")
