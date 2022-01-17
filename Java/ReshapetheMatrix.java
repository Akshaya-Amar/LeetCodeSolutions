/*

Source: https://leetcode.com/problems/reshape-the-matrix/

Time: O(m * n), where m and n are the lengths of rows and columns respectively
Space: O(1), in-place, though we are using extra 2d array(res) but we will still treat space as O(1) and not O(n)
because we usually don't consider the output in the space complexity i.e. only temporary spaces which are used to get the desired output are considered.

*/

class Solution {
  public int[][] matrixReshape(int[][] mat, int r, int c) {

    int m = mat.length;
    int n = mat[0].length;
    int len = r * c;

    if(m * n != len || m == r) {
      return mat;
    }

    int[][] res = new int[r][c];
    for(int i = 0; i < len; ++i) {
      res[i / c][i % c] = mat[i / n][i % n];
    }

    return res;
  }
}
