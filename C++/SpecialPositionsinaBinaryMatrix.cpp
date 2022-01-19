/*

Source: https://leetcode.com/problems/special-positions-in-a-binary-matrix/

Time: O(m * n), where m and n are the lengths of the rows and columns respectively
Space: O(1), in-place

*/

class Solution {
public:
  int numSpecial(vector<vector<int>>& mat) {

    int m = mat.size();
    int n = mat[0].size();
    int count = 0;

    for(int i = 0; i < m; ++i) {

      for(int j = 0; j < n; ++j) {

        if(mat[i][j] == 1) {

          if(isSpecial(mat, i, j, m, n)) {
            ++count;
          }

          break;
        }
      }
    }

    return count;
  }

private:
  bool isSpecial(vector<vector<int>>& mat, int i, int j, int m, int n) {

    for(int k = i - 1; k >= 0; --k) {

      if(mat[k][j] == 1) {
        return false;
      }
    }

    for(int k = i + 1; k < m; ++k) {

      if(mat[k][j] == 1) {
        return false;
      }
    }

    for(int k = j + 1; k < n; ++k) {

      if(mat[i][k] == 1) {
        return false;
      }
    }

    return true;
  }
};
