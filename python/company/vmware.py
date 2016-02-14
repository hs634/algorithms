__author__ = 'hs634'

import sys

class Solution():
    def __init__(self):
        self.n = 0
        self.inputs = []

    def read_input(self):
        stdin_input = []
        for line in sys.stdin:
            stdin_input.append(line)

        self.n = int(stdin_input[0])
        for i in range(1, len(stdin_input)):
            l = stdin_input[i].strip().split()
            nl = []
            for k in l:
                try:
                    nl.append(int(k))
                except:
                    nl.append(k)
            self.inputs.append(nl)

    def validate_input(self):
        for i in range(self.n):
            if len(self.inputs[i]) > 0:
                print self._validate_input(i + 1, self.inputs[i])
        if len(self.inputs) > self.n:
            for i in range(self.n, len(self.inputs)):
                print "FAILURE => WRONG INPUT (LINE " + str(i+2) + ")"

    def _validate_input(self, index, line):
        for item in line:
            if not isinstance(item, int):
                return "FAILURE => WRONG INPUT (LINE " + str(index+1) + ")"

        line_max = max(line)
        if len(line) == line_max:
            sorted_line = sorted(line)
            for i, x in enumerate(sorted_line):
                if (i+1) != x:
                    return ('FAILURE => RECEIVED: ' + str(len(line))
                            + ', EXPECTED: ' + str(line_max))
            return "SUCCESS => RECEIVED: " + str(line_max)
        else:
            set_line = set(line)
            return ('FAILURE => RECEIVED: ' + str(len(set_line))
                    + ', EXPECTED: ' + str(line_max))

    def main(self):
        self.read_input()
        self.validate_input()


Solution().main()



