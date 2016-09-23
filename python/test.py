#
# inputs    outputs
# single    sin
# simple    sim
# solution  so
# a         a
#

class Node:
    def __init__(self, val):
        self.val = val
        self.children = [0] * 26
        self.is_end = False
        self.word_count = 1


def get_unique_prefixes(words):
    root = Node(0)
    root.word_count += 1
    cur = root
    for word in words:
        cur = root
        for ch in word:
            index = ord(ch) - 97
            if cur.children[index] == 0:
                n = Node(ch)
                cur.children[index] = n
                cur = n
            else:
                cur.word_count += 1
                cur = cur.children[index]

        cur.is_end = True

    # print root.children[ord('s')-97].word_count

    output = []
    for word in words:
        prefix = ''
        cur = root
        for ch in word:
            prefix += ch
            if cur.word_count <= 1:
                break
            cur = cur.children[ord(ch) - 97]


        output.append(prefix)

    return output


words = ['single', 'simple', 'solution', 'a']
print get_unique_prefixes(words)

words = ['single', 'simple']
print get_unique_prefixes(words)

words = ['abcd', 'geft', 'aaaa']
print get_unique_prefixes(words)

words = ['abcd', 'abcx']
print get_unique_prefixes(words)


# /usr/bin/python /Users/harsh/giths634/algorithms/python/test.py
# ['si', 'si', 'so', 'a']
# ['si', 'si']
# ['a', 'g', 'a']
# ['abc', 'abc']
