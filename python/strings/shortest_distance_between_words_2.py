"""
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding", word2 = "practice", return 3. Given word1 = "makes", word2 = "coding", return 1

This is a follow up of Shortest Word Distance. The only difference is
now you are given the list of words and your method will be called repeatedly
many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the
 constructor, and implements a method that takes two words word1
  and word2 and return the shortest distance between these two words in the list.

"""
from collections import defaultdict
class Solution():
    def __init__(self):
        pass

    def shortest(self, lst, word1, word2):
        map = defaultdict(list)
        for i in range(len(lst)):
            map[lst[i]].append(i)

        l1 = map[word1]
        l2 = map[word2]
        min_dist = len(lst)
        for i in l1:
            for j in l2:
                min_dist = min(min_dist, abs(i - j))
        return min_dist


print Solution().shortest(["practice", "makes", "perfect", "coding", "makes"], "coding", "makes")