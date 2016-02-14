__author__ = 'hs634'

from collections import OrderedDict
from threading import Lock

#from collections import OrderedDict

# d = OrderedDict()
# d['a'] = 1
# d['b'] = 2
# d['c'] = 3
# d['a'] = 5

# for k, v in d.iteritems():
#     print k, v

#  __setitem__, __getitem__, pop, popitem

# self.map = {'key': 'value, next'}

class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None
        self.prev = None


class OrderedDict(object):
    def __init__(self):
        self.map = {}
        self.most_recent = None


    def __setitem__(self, key, value):
        #if item not in self.map:
        #    self.most_recent = item
        #self.map[item] = value
        if key not in self.map:
            node = Node(key, value)
            if self.most_recent is not None:
                node.prev = self.most_recent
                self.most_recent.next = node
            self.most_recent = node
            self.map[key] = node
        else:
            self.map[key].val = value


    def __getitem__(self, key):
        return self.map[key].val

    def pop(self, item):
        node = self.map[item]
        temp = node.val
        if node.prev and node.next:
            node.prev.next = node.next
            node.next.prev = node.prev
        else:
            if node.prev:
                node.prev.next = node.next
                self.most_recent = node.prev
            elif node.next:
                node.next.prev = node.prev
            else:
                self.most_recent = None

        del self.map[item]
        return temp

#     def popitem(self):
#         if len(self.map.keys()) == 0:
#             raise KeyError("Dict is empty")
#         self.pop(self.most_recent)


d = OrderedDict()
d['a'] = 1
d['b'] = 2
d['c'] = 3
d['a'] = 5

print d.pop('c')
d.pop('b')
d.pop('a')








class Cache:
    def __init__(self,size=100):
        if int(size)<1 :
            raise AttributeError('size < 1 or not a number')
        self.size = size
        self.dict = OrderedDict()
        self.lock = Lock()

    def __getitem__(self,key):
        with self.lock:
            return self.dict[key]

    def __setitem__(self,key,value):
        with self.lock:
            while len(self.dict) >= self.size:
                self.dict.popitem(last=False)
            self.dict[key]=value

    def __delitem__(self,key):
        with self.lock:
            del self.dict[key]

