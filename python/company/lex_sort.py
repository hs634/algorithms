__author__ = 'hs634'


class LexSort():
    def __init__(self, arr, order):
        self.arr = arr
        self.order = order

    def _custom_cmp(self, a, b):
        p1 = 0
        p2 = 0
        for i in range(min(len(a), len(b))):
            if p1 != p2:
                break
            p1 = self.order.index(a[i])
            p2 = self.order.index(b[i])

        if p1 == p2 and len(a) != len(b):
            return len(a) - len(b)
        return p1 - p2

    def sort_arr(self):
        return sorted(self.arr, cmp=self._custom_cmp)


class TestLexSort():
    def test1(self):
        l = LexSort(["acb", "abc", "bca"], "abc")
        assert l.sort_arr() ==  ["abc","acb","bca"]

    def test2(self):
        l = LexSort(["acb", "abc", "bca"], "cba")
        assert l.sort_arr() == ["bca", "acb", "abc"]

    def test3(self):
        l = LexSort(["aaa","aa",""], "a")
        assert l.sort_arr() == ["", "aa", "aaa"]

    def run_tests(self):
        self.test1()
        self.test2()
        self.test3()


TestLexSort().run_tests()
