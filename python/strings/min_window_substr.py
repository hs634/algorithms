__author__ = 'hs634'

from collections import defaultdict

class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        needtofind = defaultdict(int)
        for ch in t:
            needtofind[ch] += 1
        hasfound = defaultdict(int)
        count = 0
        minlen, minstart, minend = None, 0, 0
        start = 0
        for end in range(len(s)):
            ch = s[end]
            if ch in needtofind:
                hasfound[ch] += 1
                if hasfound[ch] <= needtofind[ch]:
                    count += 1
            if count == len(t):
                while s[start] not in needtofind or hasfound[s[start]] > needtofind[s[start]]:
                    if hasfound[s[start]] > needtofind[s[start]]:
                        hasfound[s[start]] -= 1
                    start += 1
                if minlen is None or (end - start + 1) < minlen:
                    minlen = end - start + 1
                    minstart, minend = start, end

        if minlen > 0:
            return s[minstart:minend+1]
        return ""


Solution().minWindow("a", "b")