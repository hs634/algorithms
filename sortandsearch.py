__author__ = 'harsh'


class CustomArray(object):
    def __init__(self, arr):
        assert isinstance(arr, list)
        if arr is None:
            self.arr = []
        else:
            self.arr = arr

    def __rsearch__(self, lo, hi, key):
        mid = lo + (hi - lo)/2
        if hi < lo:
            return -1
        if self.arr[mid] == key:
            return mid
        elif self.arr[mid] > key:
            return self.__rsearch__(lo, mid-1, key)
        elif self.arr[mid] < key:
            return self.__rsearch__(mid+1, hi, key)

    def bsearch(self, key):
        return self.__rsearch__(0, len(self.arr) - 1, key)

    def insertion_sort(self):
        for i in range(1, len(self.arr)):
            for j in range(i-1, -1, -1):
                if self.arr[j+1] < self.arr[j]:
                    self.arr[j], self.arr[j+1] = self.arr[j+1], self.arr[j]
                else:
                    break

    def __msort__(self, lo, hi):
        if hi - lo <= 1:
            return
        mid = lo + (hi-lo)/2
        self.__msort__(lo, mid)
        self.__msort__(mid, hi)

        aux = [0] * (hi-lo)
        i1 = lo
        i2 = mid
        for i in range(0, hi-lo):
            if i1 == mid:
                aux[i] = self.arr[i2]
                i2 += 1
            elif i2 == hi:
                aux[i] = self.arr[i1]
                i1 += 1
            elif self.arr[i2] < self.arr[i1]:
                aux.insert(i, self.arr[i2])
                i2 += 1
            else:
                aux[i] = self.arr[i1]
                i1 += 1

        for i in range(0, hi-lo):
            self.arr[lo + i] = aux[i]

    def merge_sort(self):
        self.__msort__(0, len(self.arr))

    def render(self):
        print self.arr

    @staticmethod
    def main():
        arr = [4, 2, 9, 1, 3]
        carr = CustomArray(arr)
        print "1. Insertion sort"
        print "2. Merge Sort"
        choice = raw_input(">Enter choice")
        if int(choice) == 1:
            carr.insertion_sort()
        else:
            carr.merge_sort()
        carr.render()
        key = raw_input("> Enter a key : ")
        result = carr.bsearch(int(key))
        if result == -1:
            print "Sorry! Key not found!"
        else:
            print "Whoopy! Key found at index %d" % result


if __name__ == '__main__':
    CustomArray.main()
