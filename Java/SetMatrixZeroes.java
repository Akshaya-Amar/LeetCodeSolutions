/*

Source: https://leetcode.com/problems/set-matrix-zeroes/

Time: O(m * n)
Space: O(m * n)

*/

class Solution {
  public void setZeroes(int[][] matrix) {

    int m = matrix.length;
    int n = matrix[0].length;
    boolean isVisited[][] = new boolean[m][n];

    for(int i = 0; i < m; ++i) {

      for(int j = 0; j < n; ++j) {

        if(matrix[i][j] == 0 && !isVisited[i][j]) {

          for(int k = 0; k < m; ++k) {

            if(matrix[k][j] != 0) {
              matrix[k][j] = 0;
              isVisited[k][j] = true;
            }

          }

          for(int k = 0; k < n; ++k) {

            if(matrix[i][k] != 0) {
              matrix[i][k] = 0;
              isVisited[i][k] = true;
            }
          }
        }
      }
    }
  }
}


/*

*/

class Solution {
  public void setZeroes(int[][] matrix) {

    int m = matrix.length;
    int n = matrix[0].length;
    boolean[] rows = new boolean[m];
    boolean[] cols = new boolean[n];

    // O(m * n)
    for(int i = 0; i < m; ++i) {

      for(int j = 0; j < n; ++j) {

        if(matrix[i][j] == 0) {
          rows[i] = true;
          cols[j] = true;
        }

      }
    }

    // O(n * m)
    // iterate columns
    for(int i = 0; i < n; ++i) {

      if(cols[i]) {
        for(int j = 0; j < m; ++j) {
          matrix[j][i] = 0;
        }
      }
    }

    //  O(m * n)
    // iterate rows
    for(int i = 0; i < m; ++i) {

      if(rows[i]) {
        for(int j = 0; j < n; ++j) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}
