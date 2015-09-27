__author__ = 'hs634'


class Solution:
    def __init__(self):
        pass

    def three_sum_closest(self, nums, target):
        nums = sorted(nums)
        result = float("inf")
        min_diff = float("inf")
        i = 0

        while i < len(nums) - 2:
            j, k = i + 1, len(nums) - 1
            while j < k:
                diff = nums[i] + nums[j] + nums[k] - target
                if abs(diff) < min_diff:
                    min_diff = abs(diff)
                    result = nums[i] + nums[j] + nums[k]
                if diff < 0:
                    j += 1
                elif diff > 0:
                    k -= 1
                else:
                    return target
            i += 1
            while i < len(nums) - 2 and nums[i] == nums[i-1]:
                i += 1
        return result

if __name__ == "__main__":
    result = Solution().three_sum_closest([-1, 2, 1, -4], 3)
    print result