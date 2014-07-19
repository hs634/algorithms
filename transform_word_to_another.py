__author__ = 'harsh'

from collections import defaultdict


class Queue(object):
    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def enqueue(self, item):
        self.items.insert(0, item)

    def dequeue(self):
        return self.items.pop()

    def size(self):
        return len(self.items)


class Solution(object):

    def transform(self, src, dest, dictionary):
        Q = Queue()
        routes = defaultdict(str)
        visited = defaultdict(bool)

        Q.enqueue(src)
        visited[src] = True

        while not Q.isEmpty():
            temp = Q.dequeue()
            if temp == dest:
                path = []
                while temp:
                    path.insert(0, temp)
                    temp = routes.get(temp)

                return path
            for opt in self.get_all_transformations(temp, dictionary):
                if not visited[opt]:
                    visited[opt] = True
                    Q.enqueue(opt)
                    routes[opt] = temp

        return None

    @staticmethod
    def get_all_transformations(temp, dictionary):
        results = []
        for i,ch in enumerate(list(temp)):
            for numalpha in xrange(ord('a'), ord('z') + 1):
                alpha = chr(numalpha)
                perm = temp[:i] + alpha + temp[i+1:]
                if perm in dictionary and perm != temp:
                    results.append(perm)
        return results


    @staticmethod
    def main():
        dictionary = ['damp', 'lamp', 'like', 'limp', 'lime', 'camp', 'pain', 'pool', 'dike', 'duke']
        src = 'damp'
        dest = 'like'
        path = Solution().transform(src, dest, dictionary)
        print " --> ".join(path)


Solution.main()




