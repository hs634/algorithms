__author__ = 'harsh'


def find_contiguous_subset(subset):
    if len(subset) == 0:
        return 0
    if len(subset) == 1:
        return subset[0]
    else:
        return max(subset[0] + find_contiguous_subset(subset[1:]), find_contiguous_subset(subset[1:]))


def main():
    subset = [4,-1,5,6,-13,2]
    k = find_contiguous_subset(subset)
    print k

main()

def find_contiguous_subset1(subset):
    max_ending_here = max_so_far = 0
    for k in subset:
        max_ending_here = max(0, max_ending_here + k)
        max_so_far = max(max_ending_here, max_so_far)
    return max_so_far


def main():
    subset = [4,-1,5,6,-13,2]
    k = find_contiguous_subset1(subset)
    print k

main()



