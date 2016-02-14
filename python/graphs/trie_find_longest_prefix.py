__author__ = 'hs634'

from collections import defaultdict

class TrieNode(object):
    def __init__(self, value=None):
        self.val = value
        self.children = {}
        self.is_end = False


class Trie(object):
    def __init__(self, root_value='0'):
        self.root = TrieNode(root_value)

    def insert(self, word):
        temp = self.root
        for idx, ch in enumerate(word):
            if ch in temp.children:
                temp = temp.children.get(ch)
            else:
                new_node = TrieNode(ch)
                temp.children[ch] = new_node
                temp = new_node
        temp.is_end = True

    def insert_list(self, word_list):
        for word in word_list:
            self.insert(word)

    def get_longest_prefix(self, word):
        temp = self.root
        prefix, prev_match = '', ''
        for ch in word:
            if ch in temp.children:
                temp = temp.children.get(ch)
                prefix += ch
                if temp.is_end:
                    prev_match = prefix
            else:
                break
        if not temp.is_end:
            return prev_match
        return prefix

def main():
    trie = Trie()
    trie.insert_list(['are', 'area', 'base', 'cat', 'cater', 'children',
                       'basement'])
    #print trie.get_longest_prefix('caterer')
    print trie.get_longest_prefix('are')

if __name__ == "__main__":
    main()














