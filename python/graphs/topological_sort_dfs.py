__author__ = 'hs634'

class Stack(object):
    def __init__(self):
        self._stack = []

    def push(self, x):
        self._stack.append(x)

    def pop(self):
        if self.is_empty():
            raise Exception("Stack is empty")
        return self._stack.pop()

    def is_empty(self):
        if len(self._stack) == 0:
            return True
        return False


class TopologicalSort(object):
    def __init__(self):
        self.visited = {}
        self.stack = Stack()

    def do_sort(self, G):
        if not isinstance(G, dict):
            raise Exception("Graph is not a dict")
        for vertex in G.keys():
            if not (vertex in self.visited):
                self.dfs(G, vertex)

    def dfs(self, G, vertex):
        self.visited[vertex] = True
        for adj_vertex in G[vertex]:
            if adj_vertex not in self.visited:
                self.dfs(G, adj_vertex)
        self.stack.push(vertex)

    def get_order(self):
        return self.stack._stack



def main():
    G = {
        0: [1, 2, 5],
        1: [4],
        2: [],
        3: [2, 4, 5, 6],
        4: [],
        5: [2],
        6: [0, 4]
    }
    t = TopologicalSort()
    t.do_sort(G)
    print t.get_order()

if __name__ == "__main__":
    main()

