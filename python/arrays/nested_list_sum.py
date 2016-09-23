
class Solution():
    def __init__(self):
        pass

    def sumall(self, lst):
        return self.sumh(lst, 1)

    def sumh(self, lst, depth):
        sum = 0
        if isinstance(lst, int):
            sum += lst
            return sum

        for item in lst:
            if isinstance(item, int):
                sum += (item * depth)
            elif isinstance(item, list):
                sum += self.sumh(item, depth+1)

        return sum

print Solution().sumall([[1,1],2,[1,1]])
print Solution().sumall([1,[4,[6]]])