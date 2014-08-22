__author__ = 'harsh'

def bin_search(sequence, left, right, key):
    if not sequence:
        return -1
    if left >= right:
        return -1
    mid = left + (right - left)/2;
    if sequence[mid] == key:
        return mid
    else:
        if sequence[left] < sequence[mid]:
            if sequence[left] <= key < sequence[mid]:
                return bin_search(sequence, left, mid, key)
            else:
                return bin_search(sequence, mid+1, right, key)
        else:
            if sequence[mid] < key <= sequence[right]:
                return bin_search(sequence, mid+1, right, key)
            else:
                return bin_search(sequence, left, mid, key)


def find_rotation_point(sequence):
    l, r = 0, len(sequence) - 1
    if not sequence:
        return -1
    while sequence[l] > sequence[r]:
        mid = l + ((r-l)/2)
        if sequence[mid] > sequence[r]:
            l = mid + 1
        else:
            r = mid
    return l


def main():
    sequence = [7,8,9,0]
    key = 5
    index = bin_search(sequence, 0, len(sequence)-1, key)
    print str(key) + " found at " + str(index)
    print "rotation index found at " + str(find_rotation_point(sequence))

main()