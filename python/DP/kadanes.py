__author__ = 'harsh'


def kadanes(sequence):
    start_index, end_index, sum_start = -1, -1, -1
    maxsum, curr_sum = 0, 0

    for i, k in enumerate(sequence):
        curr_sum += k
        if maxsum < curr_sum:
            maxsum = curr_sum
            start_index, end_index = sum_start, i
        elif curr_sum < 0:
            curr_sum = 0
            sum_start = i
    assert maxsum == sum(sequence[start_index+1:end_index+1])
    print sequence[start_index+1:end_index+1], maxsum
    return sequence[start_index+1:end_index+1]

def main():
    f = kadanes
    assert f([]) == []
    assert f([-1]) == []
    assert f([0]) == []
    assert f([1]) == [1]
    assert f([1, 0]) == [1]
    assert f([0, 1]) == [0, 1]
    assert f([0, 1, 0]) == [0, 1]
    assert f([2]) == [2]
    assert f([2, -1]) == [2]
    assert f([-1, 2]) == [2]
    assert f([-1, 2, -1]) == [2]
    assert f([2, -1, 3]) == [2, -1, 3]
    assert f([2, -1, 3, -1]) == [2, -1, 3]
    assert f([-1, 2, -1, 3]) == [2, -1, 3]
    assert f([-1, 2, -1, 3, -1]) == [2, -1, 3]
    assert f([-1, 1, 2, -5, -6]) == [1,2]
    assert f([-2, 1, -3, 4, -1, 2, 1, -5, 4]) == [4, -1, 2, 1]


main()


# Python program to find maximum contiguous subarray

def maxSubArraySum(a, size):
    max_so_far = a[0]
    curr_max = a[0]

    for i in range(1, size):
        curr_max = max(a[i], curr_max + a[i])
        max_so_far = max(max_so_far, curr_max)

    return max_so_far


# Driver function to check the above function
a = [-2, -3, 4, -1, -2, 1, 5, -3]
print"Maximum contiguous sum is", maxSubArraySum(a, len(a))