__author__ = 'hs634'

import sys
import os

def maxThreats( a):
    if a is None or len(a) <= 1:
        return 0
    g_max = 0
    for i in range(len(a)):
        cur_max = 0
        j = a[i] - 1
        cur_max = get_threats(i, j, a)
        g_max = max(cur_max, g_max)

    return g_max

def get_threats(row, col, a):
    ct = 0
    i = row - 1
    while i >= 0 and (row-i != col-a[i]+1):
        i -= 1
    if i >= 0:
        ct += 1

    i = row + 1
    while i < len(a) and (i-row != a[i]-col-1):
        i += 1
    if i < len(a):
        ct += 1

    i = row - 1
    while i >= 0 and (row-i != a[i]-col-1):
        i -= 1
    if i >= 0:
        ct += 1

    i = row + 1
    while i < len(a) and (i-row != col-a[i]+1):
        i += 1
    if i < len(a):
        ct += 1

    return ct


f = open(os.environ['OUTPUT_PATH'], 'w')


_a_cnt = 0
_a_cnt = int(raw_input())
_a_i=0
_a = []
while _a_i < _a_cnt:
    _a_item = int(raw_input());
    _a.append(_a_item)
    _a_i+=1


res = maxThreats(_a);
f.write(str(res) + "\n")

f.close()