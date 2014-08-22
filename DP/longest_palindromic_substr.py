__author__ = 'hs634'

def findLongestPalindrome(string):
    return max([getPalindromeAt(i, string) for i in xrange(len(string))],
               key = lambda a: len(a)) if len(string) > 0 else ''

def getPalindromeAt(position, string):
    longest = (position, position)
    for lower, upper in [(position - 1, position + 1),
                         (position, position + 1)]:
        while lower >= 0 and upper < len(string) and string[lower] == string[upper]:
            upper += 1
            lower -= 1
        longest = max(longest, (lower + 1, upper - 1),
                      key = lambda a: a[1] - a[0])
    return string[longest[0] : longest[1] + 1]

def expand_center(instr, i, j):
    l = i
    h = j
    while l >= 0 and h < len(instr) and instr[l] == instr[h]:
        l -= 1
        h += 1
    return instr[l+1:h-l+1]

def longest_palindromic_substr(instr):
    n = len(instr)
    if n == 0:
        return None
    longest = instr[0]
    for i in range(1, n-1):
        p1 = expand_center(instr, i-1, i+1)
        if len(p1) > len(longest):
            longest = p1

        p2 = expand_center(instr, i-1, i)
        if len(p2) > len(longest):
            longest = p2

    return longest

def test_with_pallindrome():
    longest = longest_palindromic_substr("aba")
    assert longest == "aba"

def test_with_non_pallindrome():
    print longest_palindromic_substr("abcdefg")

def test_with_mix():
    assert longest_palindromic_substr("abcbde") == "bcb"

def main():
    test_with_pallindrome()
    test_with_non_pallindrome()
    test_with_mix()
    k = raw_input("Enter a String:")
    longest = longest_palindromic_substr(k)
    print "Longest is : ", longest

main()