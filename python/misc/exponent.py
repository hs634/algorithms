__author__ = 'hs634'

def exponent(x, y):
    if y > 0:
        return x * exponent(x, y-1)
    elif y < 0:
        return 1/exponent(x, -y)
    return 1

print exponent(2, 2)
print exponent(5, 3)