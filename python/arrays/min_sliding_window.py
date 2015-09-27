"""
Finding the Minimum Window in S which Contains All Elements from T
Given a set T of characters and a string S, find the minimum window in S which will contain all the characters in T in complexity O(n).
eg,
S = "ADOBECODEBANC"
T = "ABC"

Minimum window is "BANC".

"""
# from collections import defaultdict


def find_min_window(S, T):
    need_to_find = {}
    has_found = {}
    begin = 0
    min_window_len = -1
    min_window_begin = -1
    min_window_end = -1
    s_len = len(S)
    t_len = len(T)

    for ch in T:
        if ch in need_to_find:
            need_to_find[ch] += 1
        else:
            need_to_find[ch] = 1
    count = 0
    for end in range(s_len):
        if S[end] in need_to_find:
            if S[end] in has_found:
                has_found[S[end]] += 1
            else:
                has_found[S[end]] = 1
            if has_found[S[end]] <= need_to_find[S[end]]:
                count += 1
            if count == t_len:
                while S[begin] not in need_to_find or \
                        has_found.get(S[begin],0) > need_to_find.get(S[begin], 0):
                    if has_found.get(S[begin], 0) > need_to_find.get(S[begin],0):
                        has_found[S[begin]] -= 1
                    begin += 1
                window_len = end - begin + 1
                if min_window_len == -1 or window_len < min_window_len:
                    min_window_begin = begin
                min_window_end = end
                min_window_len = window_len

    return min_window_len, min_window_begin, min_window_end


def main(S, T):
    min_window_len, min_window_begin, min_window_end = find_min_window(S, T)
    if min_window_len != -1:
        print "Window found: %d -> %d of length %d" % (min_window_begin,
                                                       min_window_end,
                                                       min_window_len)
        print "window is %s" % S[min_window_begin:min_window_end + 1]


def run():
    S = "ADOBECODEBANC"
    T = "ABC"
    main(S, T)


run()


