__author__ = 'harsh'


class Stack(object):
    """
        Simple Stack Implementation. Uses Python lists for storing
        the elements in the stack.
    """
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

    def peek(self):
        return self.items[len(self.items) - 1]

    def is_empty(self):
        return self.items == []

    def size(self):
        return len(self.items)


class StackWithMin(Stack):
    """
        StackWithMin is a stack along with min operation in O(1).
        It uses a minimum stack to keep track of the current minimum element in the main stack.
        Works as follows:
        Push Operation:
        -> Pushes an element on the minimum stack if the current minimum is greater than new element
        Pop operation:
        -> Pops an element from the minimum stack if the top of main stack is same as top of minimum stack
        Get_Min operation:
        -> return the top of the minimum stack in constant time
    """
    def __init__(self):
        self.main_stack = Stack()
        self.min_stack = Stack()

    def push(self, item):
        self.main_stack.push(item)
        print "Pushed " + str(item) + " to Main Stack"
        if self.min_stack.is_empty() or self.min_stack.peek() >= item:
            self.min_stack.push(item)
            print "Pushed " + str(item) + " to Minimum Stack"

    def pop(self):
        if self.main_stack.peek() == self.min_stack.peek():
            self.min_stack.pop()
        return self.main_stack.pop()

    def peek(self):
        self.main_stack.peek()

    def get_min(self):
        print "Minimum item in the stack is " + str(self.min_stack.peek())
        return self.min_stack.peek()

    def is_empty(self):
        return self.main_stack.is_empty()

    def size(self):
        return self.main_stack.size()


class StackWithMinRunner(object):
    """
        A simple runner class that demonstrates the working of the StackWithMin
    """
    def __init__(self):
        self.stack_with_min = StackWithMin()

    def main(self):
        self.stack_with_min.push(2)
        self.stack_with_min.get_min()
        self.stack_with_min.push(5)
        self.stack_with_min.get_min()
        self.stack_with_min.push(1)
        self.stack_with_min.get_min()
        self.stack_with_min.push(3)
        self.stack_with_min.get_min()


StackWithMinRunner().main()