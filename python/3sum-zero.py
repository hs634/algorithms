__author__ = 'hs634'

class Solution():
    def __init__(self):
        pass

    def three_sum_zero(self, arr):
        arr, solution, i = sorted(arr), [], 0
        while i < len(arr) - 2:
            j, k = i + 1, len(arr) - 1
            while j < k:
                three_sum = arr[i] + arr[j] + arr[k]
                if three_sum < 0:
                    j += 1
                elif three_sum > 0:
                    k -= 1
                else:
                    solution.append([arr[i], arr[j], arr[k]])
                    j, k = j+1, k-1
                    while j < k and arr[j] == arr[j-1]:
                        j += 1
                    while j < k and arr[k] == arr[k+1]:
                        k -= 1
            i += 1
            while i < len(arr) - 2 and arr[i] == arr[i-1]:
                i += 1
        return solution

if __name__=="__main__":
    solution = Solution().three_sum_zero([-1, 0, 1, 2, -1, -4])
    print solution
