__author__ = 'hs634'


class Node(object):
    def __init__(self, v=None):
        self.val = v
        self.next = None

    def __str__(self):
        if self:
            return "{0}".format(self.val)
        else:
            None


class Solution(object):
    def check_cycle(self, head):

        # start both runners at the beginning
        slow = head
        fast = head
        # until we hit the end of the list
        while fast and fast.next:
            fast, slow = fast.next.next, slow.next
            # case: fast_runner is about to "lap" slow_runner
            if fast is slow:
                fast = head
                while fast is not slow:
                    fast, slow = fast.next, slow.next
                return fast
        return None


if __name__ == "__main__":
    head = Node(1)
    head.next = Node(2)
    head.next.next = Node(3)
    head.next.next.next = head.next
    print Solution().check_cycle(head)
