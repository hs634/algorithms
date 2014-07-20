__author__ = 'hs634'

"""Given a value N, if we want to make change for N cents, and we have
infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many
ways can we make the change The order of coins doesn't matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions:
{1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10
and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3},
{2,2,6}, {2,3,5} and {5,5}. So the output should be 5."""


class CoinChange(object):

    def count_recursive(self, coin_set, len_coin_set, N):
        if N == 0:
            return 1
        if N < 0:
            return 0

        if len_coin_set <= 0 and N >= 1:
            return 0

        return self.count_recursive(coin_set, len_coin_set-1, N) + \
               self.count_recursive(coin_set, len_coin_set, N-coin_set[len_coin_set-1])

    def count_dp(self, S, N):

        m = len(S)
        table = [0 for i in range(0, N+1)]
        table[0] = 1
        for i in range(0, m):
            for j in range(S[i], N+1):
                table[j] += table[j-S[i]]

        return table[N]

    @staticmethod
    def main():
        S = [1,2,4]
        N = 3
        print "Recursive Version: "
        print CoinChange().count_recursive(S, len(S), N)
        print "DP Version"
        print CoinChange().count_dp(S, N)

CoinChange.main()



