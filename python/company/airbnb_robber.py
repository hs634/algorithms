__author__ = 'hs634'
'''
Provide a set of positive integers (an array of integers). Each integer
represent number of nights user request on Airbnb.com. If you are a host,
you need to design and implement an algorithm to find out the maximum number
a nights you can accommodate. The constrain is that you have to reserve at
least one day between each request, so that you have time to clean the room.
Example: 1) Input: [1, 2, 3] ==> output: 4, because you will pick 1 and
3 2)input: [5, 1, 2, 6] ===> output: 11, because you will pick 5 and 6 3)
input: [5, 1, 2, 6, 20, 2] ===> output: 27, because you will pick 5, 2, 20

'''

def max_nights(arr):
    if len(arr) <= 0:
        return 0
    dp = [0 for i in range(len(arr))]
    dp[0], dp[1] = arr[0], max(arr[0], arr[1])
    for i in range(2, len(arr)):
        dp[i] = max(dp[i-1], dp[i-2] + arr[i])
    return dp[len(arr)-1]


class Solution(object):
    def rob(self, nums):
        n = len(nums)
        s = [0,0]
        for i in range(n):
            s.append(max(s[i]+nums[i], s[i+1]))
        return s[-1]

arr = [1, 2, 3]
print max_nights(arr)

arr = [5, 1, 2, 6]
print max_nights(arr)

arr = [5, 1, 2, 6, 20, 2]
print max_nights(arr)