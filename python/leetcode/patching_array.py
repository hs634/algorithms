class Solution(object):
    def minPatches(self, nums, n):
        """
        :type nums: List[int]
        :type n: int
        :rtype: int
        """
        i=1
        cnt=0
        while i<n+1:
            if i not in nums:
                m = sum(x for x in nums if x<i)
                while m>=i and i<n+1:
                    n = sum(x for x in nums if x<i)
                    i=n+1
                    m = sum(x for x in nums if x<i)

                if i<n+1 and i not in nums:
                    nums.append(i)
                    cnt+=1
            i+=1

        return cnt

k = [1, 3]

print Solution().minPatches(k, 6)