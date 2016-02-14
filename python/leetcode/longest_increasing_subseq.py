class Solution(object):
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        longest_path = 0
        if len(matrix) <= 0:
            return 0
        dp = [[None for j in range(len(matrix[0]))] for i in range(len(matrix))]
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                path = self.get_increasing_path(matrix, row, col, dp)
                if path > longest_path:
                    longest_path = path
        print dp
        return longest_path

    def get_increasing_path(self, matrix, row, col, dp):
        #if row < 0 or row >= len(matrix) or col < 0 or col >= len(matrix[0]):
        #    return 0
        if dp[row][col] is not None:
            return dp[row][col]
        max_l = 0
        points = [(row-1,col),(row+1,col), (row, col+1), (row,col-1)]
        for p in points:
            if p[0]>=0 and p[1]>=0 and p[0]<len(matrix) and p[1]<len(matrix[0]):
                if matrix[row][col] < matrix[p[0]][p[1]]:
                    max_l = max(max_l, self.get_increasing_path(matrix, p[0],
                                                                p[1], dp))
        
        dp[row][col] = max_l + 1

        return dp[row][col]