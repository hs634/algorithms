__author__ = 'hs634'

def sqrt(num):
    if num < 0:
        raise ValueError
    if num == 1:
        return 1
    low = 0
    high = (num/2) + 1
    while low+1 < high:
        mid = low + (high-low)/2
        sq = mid**2
        if sq == num:
            return True
        elif sq < num:
            low = mid
        else:
            high = mid
    return False

def msb(num):
    bitpos = 0
    while num:
        bitpos += 1
        num >>= 1
    return bitpos - 1

def sqrt_math(num):
    ind = msb(num)
    print ind
    exp = (0.5 * ind)
    print exp
    sq = 2**exp
    print sq
    if (sq**2) == num:
        return True
    return False

assert sqrt(4) == True
assert sqrt(144) == True
assert sqrt(3) == False
assert sqrt(55) == False

print sqrt_math(16)