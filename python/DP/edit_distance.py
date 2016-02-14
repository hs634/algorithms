__author__ = 'hs634'

"""
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

Solution:

Assume that the total number of operations is d. Pick letters from both strings: x1 and x2. If x1 = x2, remove both and pick next letters.

If they are different, compare three operations:
a) insert a character, i.e., remove x2 from word2 since we will insert x2 to word1. Then pick letters from word1 and word2 again.
b) delete a character, i.e., remove x1 from word1.
c) replace a character, i.e., remove both x1 and x2.
All these cases we need one extra operation.

So the recursion is:
s1 = delete the first character of word1
s2 = delete the first character of word2
d(word1, word2) = d(s1, s2), if the first characters are the same.
d(word1, word2) = 1 + min(d(s1, word2), d(word1, s2), d(s1, s2))
"""


class EditDistance(object):
    def _recursive_helper(self, str1, str2):
        if len(str1) == 0 or len(str2) == 0:
            return abs(len(str1) - len(str2))
        s1 = str1[1:]
        s2 = str2[1:]
        if str1[0] != str2[0]:
            return 1 + min(self._recursive_helper(s1, str2),
                           self._recursive_helper(str1, s2),
                           self._recursive_helper(s1, s2))
        else:
            return self._recursive_helper(s1, s2)

    def recursive(self, str1, str2):
        return self._recursive_helper(str1,str2)

    def dynamic_prog(self, str1, str2):
        l1 = len(str1)
        l2 = len(str2)
        if l1 == 0 or l2 == 0:
            return abs(l1 - l2)

        dp = [[0 for j in range(l2)] for i in range(l1)]

        dp[0][0] = 1 if str1[0] == str2[0] else 0

        for i in range(l1):
            dp[i][0] = i if str1[i] == str2[0] else dp[i-1][0] + 1

        for j in range(l2):
            dp[0][j] = j if str1[0] == str2[j] else dp[0][j-1] + 1

        for i in range(l1):
            for j in range(l2):
                if str1[i] == str2[j]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = 1 + min(min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])

        print dp
        return dp[l1-1][l2-1]

    @staticmethod
    def main():
        str1 = "abc"
        str2 = "adc"
        print "Recursive:"
        print EditDistance().recursive(str1, str2)
        print "DP version:"
        print EditDistance().dynamic_prog(str1, str2)


EditDistance.main()

