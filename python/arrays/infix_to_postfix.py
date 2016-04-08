__author__ = 'hs634'

def infix_to_postfix(infix):
    ops = {
        '*': 3,
        '/': 3,
        '+': 2,
        '-': 2,
        '(': 1
    }
    parans = ['(', ')']
    postfix = []
    opstack = []
    infix_tokens = list(infix)
    for t in infix_tokens:
        if t not in ops and t not in parans:
            postfix.append(t)
        elif t == '(':
            opstack.append(t)
        elif t == ')':
            top = opstack.pop()
            while top != '(':
                postfix.append(top)
                top = opstack.pop()
        elif t in ops:
            while len(opstack) > 0 and ops.get(opstack[-1], 0) > ops[t]:
                postfix.append(opstack.pop())
            opstack.append(t)

    while len(opstack) > 0:
        postfix.append(opstack.pop())

    return postfix




assert infix_to_postfix("A*B+C*D") == ['A', 'B', '*', 'C', 'D', '*', '+']
assert infix_to_postfix("(a+b)*c") == ['a', 'b', '+', 'c', '*']


def postfix_eval(postfix_tokens):
    operandstack = []
    ops = {
        '*': 3,
        '/': 3,
        '+': 2,
        '-': 2,
        '(': 1
    }
    parans = ['(', ')']
    for t in postfix_tokens:
        if t not in ops and t not in parans:
            operandstack.append(int(t))
        elif t in ops:
            second = operandstack.pop()
            first = operandstack.pop()
            result = 0
            if t == '*':
                result = first * second
            elif t == '+':
                result = first + second
            elif t == '-':
                result = first - second
            elif t == '/':
                result = first / second
            operandstack.append(result)
    return operandstack.pop()

print postfix_eval(list('78+32+/'))








