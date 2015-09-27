__author__ = 'harsh'


def split_num(num_lst):
    for i in xrange(len(num_lst) - 2, 0, -1):
        if num_lst[i] < num_lst[i + 1]:
            return i
    return None


def next_higher_num(num):
    if num <= 0:
        return None
    num_lst = list(str(num))
    print num_lst
    i = split_num(num_lst)
    if i:
        next_larger_index = i+1
        for j in xrange(i+2, len(num_lst)):
            if num_lst[i] < num_lst[j] < num_lst[next_larger_index]:
                next_larger_index = j

        num_lst[i], num_lst[next_larger_index] = num_lst[next_larger_index], num_lst[i]

        right_lst = sorted(num_lst[i+1:])
        print right_lst
        if int(right_lst[-1]) % 2 == 0:
            return "".join(num_lst[:i+1] + right_lst)
        else:
            return "".join(num_lst[:i+1] + list(next_higher_num("".join(right_lst))))
    else:
        return None


def main():
    assert(next_higher_num(34722641) == str(34724126))
    assert(next_higher_num(8234961) == str(8236194))
    assert(next_higher_num(99999) is None)
    assert(next_higher_num(987654) is None)


main()









