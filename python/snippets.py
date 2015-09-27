__author__ = 'harsh'


class Snippets(object):

    @staticmethod
    def main():
        Snippets.convert_integer_to_binary(16)
        Snippets.towers_of_hanoi(2)
        Snippets.twenty_questions()

    @staticmethod
    def convert_integer_to_binary(num):
        print "Running Binary to Integer Conversion Snippet ..."
        print "Converting %s to binary ..." % num
        inum = int(num)
        itemp = 1
        while itemp <= inum/2:
            itemp *= 2

        while itemp > 0:
            if inum < itemp:
                print 0,
            else:
                print 1,
                inum = inum - itemp
            itemp /= 2
        print "\nEnd of Binary to Integer Conversion Snippet"

    @staticmethod
    def towers_of_hanoi(num):
        def moves(num, left):
            assert isinstance(num, int)
            assert isinstance(left, bool)
            if num == 0:
                return
            moves(num-1, not(left))
            assert isinstance(left, bool)
            if left:
                print num, " left"
            else:
                print num, " right"
            moves(num-1, not(left))
        moves(num, True)

    @staticmethod
    def twenty_questions():
        def guess(lo, hi):
            if hi - lo == 1:
                return lo
            mid = lo + (hi-lo)/2
            ans = raw_input("> Is it less than %s? " % mid)
            if ans == 'y' or ans == 'yes':
                return guess(lo, mid)
            else:
                return guess(mid, hi)
        n = raw_input("> Enter a number :")
        N = int(n) ** 2
        print "> Think of number between %d and %d", 0, N-1
        guessed = guess(0, N)
        print "You thought of %d" % guessed



if __name__ == '__main__':
    Snippets.main()



