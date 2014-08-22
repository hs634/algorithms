__author__ = 'hs634'

'''Given an array where elements are sorted in ascending order, convert it to a height balanced BST.'''
'''Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.'''


def sorted_arr_to_balanced_btree(arr, start, end):
    if start > end:
        return None

    mid = start + (end-start) / 2
    root = BinaryTree().add_node(arr[mid])
    root.left = sorted_arr_to_balanced_btree(arr, start, mid-1)
    root.right = sorted_arr_to_balanced_btree(arr, mid+1, end)
    return root

def sorted_linked_list_to_balanced_btree(list, start, end):
    if start > end:
        return None

    mid = start + (end-start) / 2
    left_child = sorted_linked_list_to_balanced_btree(list, start, mid-1)
    parent = BinaryTree.add_node(list.data)
    parent.left = left_child
    list = list.next
    parent.right = sorted_linked_list_to_balanced_btree(list, mid+1, end)
    return parent


class LinkedList():
    def __init__(self):
        self.head = None

    def add_node(self, data):
        new_node = LinkedListNode(data)
        if self.head is None:
            self.head = new_node
        else:
            new_node.next = self.head
            self.head = new_node


class LinkedListNode():

    def __init__(self, data):
        self.data = data
        self.next = None



class BinaryTree(object):

    def add_node(self, data):
        return Node(data)


class Node(object):

    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None