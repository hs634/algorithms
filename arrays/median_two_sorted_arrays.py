__author__ = 'hs634'

'''The basic idea is that if you are given two arrays ar1[] and ar2[] and know the length of each,
you can check whether an element ar1[i] is the median in constant time. Suppose that the median is ar1[i].
Since the array is sorted, it is greater than exactly i values in array ar1[]. Then if it is the median,
it is also greater than exactly j = n – i – 1 elements in ar2[].

It requires constant time to check if ar2[j] <= ar1[i] <= ar2[j + 1]. If ar1[i] is not the median,
then depending on whether ar1[i] is greater or less than ar2[j] and ar2[j + 1], you know that ar1[i]
 is either greater than or less than the median. Thus you can binary search for median in O(lg n) worst-case time.

For two arrays ar1 and ar2, first do binary search in ar1[].
If you reach at the end (left or right) of the first array and don't find median, start searching in the second array ar2[].

1) Get the middle element of ar1[] using array indexes left and right.
   Let index of the middle element be i.
2) Calculate the corresponding index j of ar2[]
     j = n – i – 1
3) If ar1[i] >= ar2[j] and ar1[i] <= ar2[j+1] then ar1[i] and ar2[j]
   are the middle elements.
     return average of ar2[j] and ar1[i]
4) If ar1[i] is greater than both ar2[j] and ar2[j+1] then
     do binary search in left half  (i.e., arr[left ... i-1])
5) If ar1[i] is smaller than both ar2[j] and ar2[j+1] then
     do binary search in right half (i.e., arr[i+1....right])
6) If you reach at any corner of ar1[] then do binary search in ar2[]
Example:

   ar1[] = {1, 5, 7, 10, 13}
   ar2[] = {11, 15, 23, 30, 45}
Middle element of ar1[] is 7. Let us compare 7 with 23 and 30, since 7 smaller than both 23 and 30,
move to right in ar1[]. Do binary search in {10, 13}, this step will pick 10. Now compare 10 with 15 and 23.
 Since 10 is smaller than both 15 and 23, again move to right. Only 13 is there in right side now.
 Since 13 is greater than 11 and smaller than 15, terminate here. We have got the median as 12 (average of 11 and 13)
'''


class MedianSortedArrays(object):
    def get_median(self, arr1, arr2, n):
        return self.get_median_rec(arr1, arr2, 0, n - 1, n)

    def get_median_rec(self, arr1, arr2, left, right, n):
        if left > right:
            return self.get_median_rec(arr2, arr1, 0, n - 1, n)

        i = (left + right) / 2
        j = n - i - 1

        if arr1[i] > arr2[j] and (j == n - 1 or arr1[i] <= arr2[j+1]):
            if i == 0 or arr2[j] > arr1[i - 1]:
                return (arr1[i] + arr2[j]) / 2
            else:
                return (arr1[i] + arr1[i - 1]) / 2
        elif arr1[i] > arr2[j] and j != n - 1 and arr1[i] > arr2[j+1]:
            return self.get_median_rec(arr1, arr2, left, i - 1, n)
        else:
            return self.get_median_rec(arr1, arr2, i + 1, right, n)

    @staticmethod
    def main():
        arr1 = [1, 3, 8, 9, 10]
        arr2 = [23, 24, 32, 55, 103]
        n = 5
        arr3 = [1, 12, 15, 26, 38]
        arr4 = [2, 13, 17, 30, 45]
        median = MedianSortedArrays().get_median(arr1, arr2, n)
        print "Median is ",
        print median


MedianSortedArrays.main()

