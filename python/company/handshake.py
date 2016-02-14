__author__ = 'hs634'

# You are given two sorted arrays, A and B, where A has a
# large enough buffer at the end to hold B. Write a method
# to merge B into A in sorted order.

# O(m + n)

def merge(A, B):
    if not A and not B:
        return []
    if not A:
        copy(B, A)
    if not B:
        return A

    C = []

    i = 0, j = 0
    k = 0
    while i < len(A) and j < len(B):
        if A[i] < B[j]:
            C[k] = A[i]
            i += 1
        else:
            C[k] = B[j]
            j += 1
        k += 1
    while i < len(A):
        C[k] = A[i]
        i += 1
        k += 1
    while j < len(B):
        C[k] = A[j]
        j += 1
        k += 1
    A = copy(C, A)

def copy(C, A):
    for i in range(C):
        A[i] = C[i]
    return A

A = [4,8,10]
B = [2,5,9,14]



# Numbers are randomly generated and passed to a method.
# Write a program to find and maintain the median value as
# new values are generated.

# static variable(s)

# O(n)

arr = []

def take_number(num):
    for i in len(arr):
        if arr[i] > num:
            break
    insert(i-1, num)

def insert(index, num):
    for i in range(len(arr), index):
        arr[i] = arr[i-1]
    arr[index] = num



# O(1)
def median():
    k = len(arr)
    if k % 2 == 0:
        return (arr[k/2] + arr[k/2 + 1]) / 2
    else:
        return arr[k/2]


### Heap solution:

# O(h)

def median():
    return (max() + min()) / 2

def insert(num):
    if num > max():
        MaxHeap.insert(num)
    else:
        MinHeap.insert(num)


class MaxHeap():
    def insert(num):
        max_heap.append(num)
        swim_up_heapify(len(max_heap))

    def swim_up_heapify(index):
        while index > 0:
            j = index/2
            if max_heap[j] < max_heap[index]
                max_heap[j], max_heap[index] = max_heap[index], max_heap[j]
                index = j

    def max():
        return max_heap[1]


class MinHeap():
    def min():
        return min_heap[1]

