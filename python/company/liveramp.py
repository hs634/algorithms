__author__ = 'hs634'


'''




# you can write to stdout for debugging purposes, e.g.
# print "this is a debug message"

def solution(A, X, D):
    # write your code in Python 2.7
    cur_pos, moment = 0, 0
    num_jumps = 0
    #taking care of the example case first
    #loop through array A
    for i in range(len(A)):
        if A[i] > 0 and (1 <= A[i] - cur_pos <= D):
            cur_pos = A[i]
            moment = i
            num_jumps += 1
        if (cur_pos >= X) or ((X - cur_pos) <= D):
            if num_jumps == 1 or i == 0:
                return 0
            return moment

    # couldn't reach
    return -1

def test():
    A = [0, 5]
    X = 9
    D = 1

    print solution(A, X, D)

    A = [0, 1, 3, 1, 2, 3, 2, 4, 5]
    X = 5
    D = 1

    print solution(A, X, D)

    A = [0, 4]
    X = 4
    D = 60000

    print solution(A, X, D)

    A = [0, 3, 6]
    X = 6
    D = 3

    print solution(A, X, D)



test()

