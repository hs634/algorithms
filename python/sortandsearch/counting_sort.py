__author__ = 'hs634'

"""
Counting sort is a very time-efficient (and somewhat space-inefficient) algorithm for sorting that avoids comparisons and exploits the O(1)O(1) time insertions and lookups in an array.

The idea is simple: if you're sorting  integers and you know they all fall in the range 1..1001..100, you can generate a sorted array this way:

Allocate an array nums_to_counts where the indices represent numbers from our input array and the values represent how many times the index number appears. Start each value at 0.
In one pass of the input array, update nums_to_counts as you go, so that at the end the values in nums_to_counts are correct.
Allocate an array sorted_list where we'll store our sorted numbers.
In one in-order pass of nums_to_counts put each number, the correct number of times, into sorted_list.


  def counting_sort(the_list, max_value):
    # array of 0s at indices 0..max_value
    nums_to_counts = [0] * (max_value+1)

    # populate nums_to_counts
    for item in the_list:
        nums_to_counts[item] += 1

    # populate the final sorted list
    sorted_list = []
    # for each item in nums_to_counts
    for item, count in enumerate(nums_to_counts):
        # for the number of times the item occurs
        for time in range(count):
            # add it to the sorted list
            sorted_list.append(item)

    return sorted_list


Counting sort takes O(n) time and O(n) additional space (for the new array that we end up returning). The nums_to_counts array is technically constant space, but might nonetheless be significant.

There are some rare cases where even though our input items aren't integers bound by constants, we can write a function that maps our items to integers from 0 to some constant such that different items will always map to different integers. This allows us to use counting sort.
"""