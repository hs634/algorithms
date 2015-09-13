__author__ = 'hs634'

def check_cycle(first_node):

    # start both runners at the beginning
    slow_runner = first_node
    fast_runner = first_node

    # until we hit the end of the list
    while fast_runner != None and fast_runner.next != None:
        slow_runner = slow_runner.next
        fast_runner = fast_runner.next.next

        # case: fast_runner is about to "lap" slow_runner
        if fast_runner == slow_runner:
            return True

    # case: fast_runner hit the end of the list
    return False