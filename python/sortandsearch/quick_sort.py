__author__ = 'harsh'


class QuickSort:
    def __init__(self, arr):
        self.arr = arr

    def print_arr(self):
        print "array is: {0}".format(self.arr)

    def _quick_sort(self, lo, hi):
        if lo < hi:
            partition_pt = self.partition(lo, hi)
            self._quick_sort(lo, partition_pt - 1)
            self._quick_sort(partition_pt + 1, hi)

    def partition(self, lo, hi):
        pivot = lo
        lo += 1
        while lo <= hi:
            while lo <= hi and self.arr[lo] <= self.arr[pivot]:
                lo += 1
            while lo <= hi and self.arr[hi] >= self.arr[pivot]:
                hi -= 1
            if lo < hi:
                self.arr[lo], self.arr[hi] = self.arr[hi], self.arr[lo]
                hi -= 1
                lo += 1

        self.arr[hi], self.arr[pivot] = self.arr[pivot], self.arr[hi]
        return hi

    def quick_sort(self):
        if len(self.arr) <= 0:
            return []
        self._quick_sort(0, len(self.arr)-1)


if __name__ == "__main__":
    qs = QuickSort([9,5,2,10,3,1])
    qs.print_arr()
    qs.quick_sort()
    qs.print_arr()

    qs = QuickSort([1,2,3,4,5,7])
    qs.print_arr()
    qs.quick_sort()
    qs.print_arr()

    qs = QuickSort([9,8,1,10,1,1])
    qs.print_arr()
    qs.quick_sort()
    qs.print_arr()

    qs = QuickSort([])
    qs.print_arr()
    qs.quick_sort()
    qs.print_arr()

    qs = QuickSort([-9,0,-2,-10,3,1])
    qs.print_arr()
    qs.quick_sort()
    qs.print_arr()


