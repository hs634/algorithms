__author__ = 'hs634'

def read_input():
    rs, cols = raw_input().split(',')
    rows = int(rs)
    matrix = []
    for i in range(rows):
        m_row = raw_input().split(',')
        matrix.append(m_row)

def print_spiral(matrix, rows, cols):
    k, l, m, n = 0, 0, rows, cols
    while k < m and l < n:
        for i in range(l, n):
            print matrix[k][i]
        k += 1

        for i in range(k, m):
            print matrix[i][n-1]
        n -= 1
        if k < m:
            for i in range(n-1, l-1, -1):
                print matrix[m-1][i]
            m -= 1
        if l < n:
            for i in range(m-1, k-1, -1):
                print matrix[i][l]
            l += 1

matrix = [[1,  2,  3,  4,  5,  6],
        [7,  8,  9,  10, 11, 12],
        [13, 14, 15, 16, 17, 18]]

print_spiral(matrix, len(matrix), len(matrix[0]))

"""

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>> &matrix) {
        vector<int> result;
        if (matrix.empty()) return result;
        result = matrix[0];  // no need to check the first row
        int dirs[4][2] = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};  // direction offsets
        int d = 0;  // direction index
        int m = matrix.size();
        int n = matrix[0].size();
        int pos[2] = {0, n - 1};  // start from the top right corner
        int i = (m - 1) * n;  // number of the rest numbers
        while (i > 0) {
            for (int j = 1; j < m; j++) {
                i--;
                pos[0] += dirs[d][0]; pos[1] += dirs[d][1];
                result.push_back(matrix[pos[0]][pos[1]]);
            }
            m--;  // decrease the size of row or column
            swap(m, n);  // switch between horizontal and vertical mode
            d = (d + 1) % 4;  // loop between direction offsets
        }
        return result;
    }
};


"""
