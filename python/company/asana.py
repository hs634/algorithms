class HungryRabbit(object):
    def find_closest_square_with_max_count(self, x, y, matrix):
        """
        find the square adjacent to the given position on the matrix
        with max carrots and return its row and col value

        :param x: row index
        :param y: column index
        :param matrix: matrix
        :return: row and col index of adjacent square with max carrots
        """
        n, m = len(matrix), len(matrix[0])
        adjacent_squares = [(x, y + 1), (x, y - 1), (x + 1, y), (x - 1, y)]

        max_nearby_carrots, max_i, max_j = 0, -1, -1
        for i, j in adjacent_squares:
            if 0 <= i < n and 0 <= j < m:
                if matrix[i][j] != -1:
                    if matrix[i][j] > max_nearby_carrots:
                        max_nearby_carrots, max_i, max_j = matrix[i][j], i, j

        return max_i, max_j

    def find_carrots_eaten(self, matrix):
        """
        method to find number of carrots eaten given a garden matrix
        :param matrix:
        :return:
        """
        if not matrix or len(matrix) < 1:
            return 0

        n, m = len(matrix), len(matrix[0])
        num_carrots = 0

        row, col = (n - 1) / 2, (m - 1) / 2
        if n % 2 == 0 or m % 2 == 0:
            row, col = self.find_closest_square_with_max_count(row, col, matrix)

        while 0 <= row < n and 0 <= col < m:
            num_carrots += matrix[row][col]
            matrix[row][col] = -1
            row, col = self.find_closest_square_with_max_count(row, col, matrix)
            if row == -1 or col == -1:
                break

        return num_carrots


matrix = [[5, 7, 8, 6, 3],
          [0, 0, 7, 0, 4],
          [4, 6, 3, 4, 9],
          [3, 1, 0, 5, 8]]

print HungryRabbit().find_carrots_eaten(matrix)
