__author__ = 'hs634'

from collections import defaultdict


class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        map = defaultdict(int)
        for s in words:
            for ch in s:
                map[ch] += 1

        begin, end = 0, 0
        indices = []
        count = sum([len(w) for w in words])
        while end < len(s):
            if map[s[end]] > 0:
                count -= 1
            map[s[end]] -= 1
            end += 1
            while count == 0:
                indices.append(begin)
                map[s[begin]] += 1
                if map[s[begin]] > 0:
                    count += 1
                begin += 1
        return indices

Solution().findSubstring("barfoothefoobarman", ["foo","bar"])