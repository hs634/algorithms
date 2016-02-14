__author__ = 'hs634'


#!/bin/python

import sys
import os

# Complete the function below.

g_max = 0
def longest_chain( w):
    lex = {}
    max_len = 0
    for word in w:
        if len(word) not in lex:
            lex[len(word)] = set()
        lex[len(word)].add(word)
        max_len = max(max_len, len(word))

    return _longest_chain(max_len, 1, lex)

def _longest_chain(cur_len, level, lex):
    global g_max
    if cur_len == 0:
        return g_max
    for cw in lex.get(cur_len):
        for i in range(len(cw)):
            short_cw = cw[:i] + cw[i+1:]
            if len(short_cw) in lex and short_cw in lex[len(short_cw)]:
                _longest_chain(cur_len-1, level+1, lex)

        g_max = max(g_max ,level)

    return g_max


f = open(os.environ['OUTPUT_PATH'], 'w')


_w_cnt = 0
_w_cnt = int(raw_input())
_w_i=0
_w = []
while _w_i < _w_cnt:
    _w_item = raw_input()
    _w.append(_w_item)
    _w_i+=1


res = longest_chain(_w);
f.write(str(res) + "\n")

f.close()