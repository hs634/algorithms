__author__ = 'harsh'


def kadanes(sequence):
    start_index, end_index, sum_start = -1, -1, -1
    maxsum, curr_sum =0, 0

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