__author__ = 'harsh'

from collections import defaultdict

class Graph(object):
    def __init__(self, x):
        self.x = x
        self.neighbors = []


class Solution(object):
    def __init__(self):
        self.visited = defaultdict(Graph)

    def clone_graph(self, node):
        assert isinstance(node, Graph)
        if not node:
            return None

        return self.__clone_g__(node)

    def __clone_g__(self, node):
        assert isinstance(node, Graph)
        if not node:
            return node
        if node in self.visited.keys():
            return self.visited.get(node)

        new_graph = Graph(node.x)
        self.visited[node] = new_graph

        for nei in node.neighbors:
            new_graph.neighbors.append(self.__clone_g__(nei));

        return new_graph

    def display_graph(self, node):
        if not node:
            return None
        print node.x
        for nei in node.neighbors:
            self.display_graph(nei)

    def main(self):
        new_graph = Graph(10)
        new_graph1 = Graph(20)
        new_graph2 = Graph(30)
        new_graph.neighbors.append(new_graph1)
        new_graph.neighbors.append(new_graph2)
        self.display_graph(new_graph)
        cloned_graph = self.clone_graph(new_graph)
        assert isinstance(cloned_graph, Graph)
        assert new_graph != cloned_graph
        print
        self.display_graph(cloned_graph)



Solution().main()




