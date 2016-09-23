"""
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding", word2 = "practice", return 3. Given word1 = "makes", word2 = "coding", return 1
"""
class Solution():
    def __init__(self):
        pass

    def shortest(self, lst, word1, word2):
        m = len(lst)
        a , b = -1, -1
        for i in range(len(lst)):
            if lst[i] == word1:
                a = i

            if lst[i] == word2:
                b = i

            if a != -1 and b != -1:
                m = min(m, abs(a-b))

        return m

print Solution().shortest(["practice", "makes", "perfect", "coding", "makes"], "practice", "perfect")