__author__ = 'hs634'


class Solution:
    # @param {string} s input string
    # @return {string} the longest palindromic substring
    def longestPalindrome(self, s):
        # Write your code here
        return self._longestPalindrom(s)

    def _longestPalindrom(self, s):
        if len(s) == 1:
            return s
        if self.is_palindrome(s):
            return s
        else:
            self._longestPalindrom(s[:-1])
            self._longestPalindrom(s[1:])

    def is_palindrome(self, sub_str):
        s_len = len(sub_str)
        for i in range((s_len/2)):
            if sub_str[i] != sub_str[s_len-i-1]:
                return False
        return True