__author__ = 'hs634'

arr = [1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9]

def move_zeros_to_end(arr):
    count = 0
    for i, item in enumerate(arr):
        if item != 0:
            arr[count] = arr[i]
            count += 1

    while count < len(arr):
        arr[count] = 0
        count += 1
    print arr

move_zeros_to_end(arr)