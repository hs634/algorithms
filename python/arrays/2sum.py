__author__ = 'hs634'

def two_sum(nums, target):
    nums.sort()
    i = 0
    j = len(nums) - 1
    while i < j:
        if nums[i] + nums[j] == target:
            return [i, j]
