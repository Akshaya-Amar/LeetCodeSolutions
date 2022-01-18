/*

Source: https://leetcode.com/problems/transpose-matrix/

Time: O(m * n), where m and n are the lengths of rows and columns respectively
Space: O(1), in-place, though we are using extra 2d array(res) but we will still treat space as O(1) and not O(n)
because we usually don't consider the output in the space complexity i.e. only temporary spaces which are used to get the desired output are considered

*/

class Solution {
public:
  vector<vector<int>> transpose(vector<vector<int>>& matrix) {

    int m = matrix.size();
    int n = matrix[0].size();

    vector<vector<int>> res(n, vector<int>(m));
    for(int i = 0; i < n; ++i) {
      for(int j = 0; j < m; ++j) {
        res[i][j] = matrix[j][i];
      }
    }

    return res;
  }
};
