/*

Source: https://leetcode.com/problems/reshape-the-matrix/

Time: O(m * n), where m and n are the lengths of rows and columns respectively
Space: O(1), in-place, though we are using extra 2d array(res) but we will still treat space as O(1) and not O(n)
because we usually don't consider the output in the space complexity i.e. only temporary spaces which are used to get the desired output are considered.

*/

class Solution {
public:
  vector<vector<int>> matrixReshape(vector<vector<int>>& mat, int r, int c) {

    int m = mat.size();
    int n = mat[0].size();
    int size = r * c;

    if(m * n != size || m == r) {
      return mat;
    }

    vector<vector<int>> res(r, vector<int>(c));
    for(int i = 0; i < size; ++i) {
      res[i / c][i % c] = mat[i / n][i % n];
    }

    return res;
  }
};
