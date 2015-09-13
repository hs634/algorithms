__author__ = 'harsh'

"""
Given a string S and a string T, find the minimum window in S which will
contain all the characters in T in complexity in O(n)
For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".
Note:
If there is no such window in S that covers all characters in T, return the
emtpy string "".
If there are multiple such windows, you are guaranteed that there will always
be only one unique minimum window in S.
"""

"""
To help illustrate this approach, I use a different example S = "acbbaca"
and T = "aba". The idea is mainly based on the help of two pointers
 (begin and end position of the window) and two tables (needToFind and hasFound)
  while traversing S. needToFind stores the total count of a
 character in T and hasFound stores the total count of a character met so far.
  We also use a count variable to store the total characters in
 T that's met so far (not counting characters where hasFound[x] exceeds
 needToFind[x]). When count equals T's length, we know a valid window
 is found.

Each time we advance the end pointer (pointing to an element x), we increment
hasFound[x] by one. We also increment count by one
 if hasFound[x]
 is less than or equal to needToFind[x]. Why? When the constraint is met (
 that is, count equals to T's size), we immediately advance
  begin pointer
  as far right as possible while maintaining the constraint.

How do we check if it is maintaining the constraint? Assume that begin
points to an element x, we check if hasFound[x] is greater than
needToFind[x]. If it is, we can decrement hasFound[x] by one and advancing
 begin pointer without breaking the constraint.
On the other hand, if it is not, we stop immediately as advancing begin
pointer breaks the window constraint.

Finally, we check if the minimum window length is less than the current
minimum  Update the current minimum
 if a new minimum is found.

Essentially, the algorithm finds the first window that satisfies the
constraint, then continue maintaining the constraint throughout.
"""


class Solution():
    def __init__(self):
        self.need_to_find = {}
        self.has_found = {}
        self.min_window_len = None
        self.min_window_begin = None
        self.min_window_end = None
        self.count = 0

    def find_min_window(self, long_str, sub_str):
        for ch in sub_str:
            if ch in self.need_to_find:
                self.need_to_find[ch] += 1
            else:
                self.need_to_find[ch] = 1
            self.has_found[ch] = 0

        begin = 0
        for end in range(len(long_str)):
            if long_str[end] not in self.need_to_find:
                continue
            self.has_found[long_str[end]] += 1
            if self.has_found[long_str[end]] <= self.need_to_find[long_str[
                end]]:
                self.count += 1
            if self.count == len(sub_str):
                while long_str[begin] not in self.need_to_find or \
                        (self.has_found[long_str[begin]] > self.need_to_find[
                            long_str[begin]]):
                    if long_str[begin] not in self.need_to_find:
                        pass
                    elif self.has_found[long_str[begin]] > self.need_to_find[
                            long_str[begin]]:
                        self.has_found[long_str[begin]] -= 1
                    begin += 1

                window_len = end - begin + 1
                if self.min_window_len is None or window_len < \
                        self.min_window_len:
                    self.min_window_begin = begin
                    self.min_window_end = end
                    self.min_window_len = window_len

        return self.count == len(sub_str)


def tests():
    t1 = Solution()
    assert(t1.find_min_window("cabeca", "cae") == True)
    assert(t1.min_window_begin == 3)
    assert(t1.min_window_end == 5)
    assert(t1.min_window_len == 3)
    print t1.min_window_len

def main():
    tests()

main()

















