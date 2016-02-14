__author__ = 'hs634'



str = "NNPNP"


for i in range(1, len(str)):
    temp = str[:i] + str[i:]
    #print "(" + str[:i] + ")" + "{" + str[i:] + "}"


def f(str):
    print str
    if len(str) < 2:
        return 0
    elif len(str) == 2:
        cc = 0
        if 'N' in str:
            cc += 1
        if str == 'NN':
            cc += 1
        return cc
    else:
        count = 0
        for i in range(1, len(str)):
            count += (f(str[:i]) + f(str[i:]))
        return count

def count_ways(patt):
    if len(patt) < 2:
        return 0

    return f(patt)

print count_ways("NPNNN")

