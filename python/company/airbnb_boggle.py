__author__ = 'hs634'

class NaiveSolution():
    def __init__(self):
        self.words = []


    def is_a_word(self, dict, word):
        return word in dict

    def boogle(self, matrix):
        if len(matrix) == 0:
            return None
        rows = len(matrix)
        cols = len(matrix[0])
        visited = [[False for y in range(cols)] for x in range(rows)]

        s = ''
        for x in range(rows):
            for y in range(cols):
                self.boogle_recr(matrix, visited, rows, cols, x, y, s)

    def boogle_recr(self, matrix, visited, rows, cols, x, y, s):
        visited[x][y] = True
        s += matrix[x][y]
        if self.is_a_word(self.dict, s):
            self.words.append(s)

        for dx,dy in ((0,-1), (0, 1), (1,0), (-1,0), (-1,-1), (1,1), (1, -1),
                      (-1,1)):
            x2, y2 = x + dx, y + dy
            if 0 <= x2 < rows and 0 <= y2 < cols and (not visited[x2][y2]):
                self.boogle_recr(matrix, visited, rows, cols, x2, y2, s)

        s = s[:-1]
        visited[x][y] = False

    def print_words(self):
        print self.words

    def main(self):
        matrix = [['G','I','Z'], ['U','E','K'], ['Q','S','E']]
        self.dict = ["GEEKS", "FOR", "QUIZ", "GO"]
        self.boogle(matrix)
        self.print_words()

NaiveSolution().main()


class BetterSolution():
    def __init__(self):
        pass

'''
find_word(char[][] letters, Trie words, String so_far, int i, int j, int down, int right) {
    so_far += letters[i + down][j + right];
    if (words.contains(so_far))
        words.remove(so_far);
    if (words.contains_prefix(so_far))
        find_words(letters, words, so_far, i + down, j + right, down, right);
}

word_search(char[][] letters, Trie words) {
    for (int i = 0; i < letters.size(); i++) {
        for (int j = 0; j < letters[0].size(); j++) {
            String tmp = new String(letters[i][j]));
            if (words.contains_prefix(tmp)) {
                find_word(Trie, tmp, 0, 1);
                find_word(Trie, tmp, 1, 1);
                find_word(Trie, tmp, 1, 0);
            }
        }
    }
}
'''

#!/usr/bin/python

class TrieNode:
    def __init__(self, parent, value):
        self.parent = parent
        self.children = [None] * 26
        self.isWord = False
        if parent is not None:
            parent.children[ord(value) - 97] = self

def MakeTrie(dict):
    #dict = open(dictfile)
    root = TrieNode(None, '')
    for word in dict:
        curNode = root
        for letter in word.lower():
            if 97 <= ord(letter) < 123:
                nextNode = curNode.children[ord(letter) - 97]
                if nextNode is None:
                    nextNode = TrieNode(curNode, letter)
                curNode = nextNode
        curNode.isWord = True
    return root

def BoggleWords(grid, dict):
    rows = len(grid)
    cols = len(grid[0])
    queue = []
    words = []
    for y in range(cols):
        for x in range(rows):
            c = grid[y][x]
            node = dict.children[ord(c) - 97]
            if node is not None:
                queue.append((x, y, c, node))
    while queue:
        x, y, s, node = queue[0]
        del queue[0]
        for dx, dy in ((1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1)):
            x2, y2 = x + dx, y + dy
            if 0 <= x2 < cols and 0 <= y2 < rows:
                s2 = s + grid[y2][x2]
                node2 = node.children[ord(grid[y2][x2]) - 97]
                if node2 is not None:
                    if node2.isWord:
                        words.append(s2)
                    queue.append((x2, y2, s2, node2))

    return words

matrix = ['giz', 'uek', 'qse']
dict = ["geeks", "for", "quiz", "go"]
dict = MakeTrie(dict)
print BoggleWords(matrix,dict)