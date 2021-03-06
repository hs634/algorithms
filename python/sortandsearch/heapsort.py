__author__ = 'harsh'

LT = 0
GT = 1


def compare_ele(comp_type, ele1, ele2):
    if comp_type == LT:
        return ele1 < ele2
    elif comp_type == GT:
        return ele1 > ele2
    raise Exception("Compare type Undefined")


def heapsort(lst, comp_type=LT):
    """

    :param lst:
    """
    #heapify
    for start in range((len(lst)-2)/2, -1, -1):
        siftdown_min(lst, start, len(lst)-1)

    for end in range(len(lst)-1, 0, -1):
        lst[end], lst[0] = lst[0], lst[end]
        siftdown_min(lst, 0, end-1)
    return lst


def heapsort_max(lst, comp_type=LT):
    """

    :param lst:
    """
    #heapify
    for start in range((len(lst)-2)/2, -1, -1):
        siftdown_max(lst, start, len(lst)-1)

    for end in range(len(lst)-1, 0, -1):
        lst[end], lst[0] = lst[0], lst[end]
        siftdown_max(lst, 0, end-1)
    return lst


def max_k(lst, k):
    for start in range((len(lst)-2)/2, -1, -1):
        siftdown_max(lst, start, len(lst)-1)

    if k > (len(lst) - 1):
        return -1
    for end in range(len(lst) - 1, 0, -1):
        if len(lst) - 1 - end == k:
            return lst[end + 1]
        lst[end], lst[0] = lst[0], lst[end]
        siftdown_max(lst, 0, end-1)
    return lst[end]



def siftdown(lst, start, end, comp_type):
    root = start
    while True:
        child = root * 2 + 1
        if child > end:
            break
        if child + 1 <= end and compare_ele(lst[child], lst[child + 1], comp_type):
            child += 1
        if compare_ele(lst[root], lst[child], ~comp_type):
            lst[root], lst[child] = lst[child], lst[root]
            root = child
        else:
            break


def siftdown_min(lst, start, end):
    root = start
    while True:
        child = root * 2 + 1
        if child > end:
            break
        if child + 1 <= end and lst[child] < lst[child + 1]:
            child += 1
        if lst[root] < lst[child]:
            lst[root], lst[child] = lst[child], lst[root]
            root = child
        else:
            break


def siftdown_max(lst, start, end):
    root = start
    while True:
        child = root * 2 + 1
        if child > end:
            break
        if child + 1 <= end and lst[child] > lst[child + 1]:
            child += 1
        if lst[root] > lst[child]:
            lst[root], lst[child] = lst[child], lst[root]
            root = child
        else:
            break


def main():
    arr = [7, 5, 3, 5, 2, 5, 3, 0]
    sorted_lst = heapsort_max(arr)
    print sorted_lst
    sorted_lst = heapsort([9, 8, 2, 4, 6, 7, 1])
    print sorted_lst
    print max_k([9, 8, 2, 4, 6, 7, 1], 1)


main()