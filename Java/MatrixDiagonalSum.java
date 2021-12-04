/*

Source: https://leetcode.com/problems/matrix-diagonal-sum/

Time: O(n), where n is the length of the given matrix array
Space: O(1), in-place

*/

class Solution {
  public int diagonalSum(int[][] mat) {

    int n = mat.length - 1;
    int sum = 0;

    for(int i = 0; i <= n; ++i) {
      sum += mat[i][i] + mat[i][n - i];
    }

    return ((n & 1) == 0) ? (sum - mat[n >> 1][n >> 1]) : sum;
  }
}

/*

Here, return ((n & 1) == 0) ? (sum - mat[n >> 1][n >> 1]) : sum; is because
if matrix length is odd, then the middle element has been added twice, so we have to subtract
that element from the sum in order to get the desired result.
NOTE: here n = mat.length - 1, so we will subtract the middle element when n is even
eg:
when matrix length = 5, then n = mat.length - 1 ==> n = 5 - 1 ==> n = 4
So, we will subtract the middle element when length is odd, but n will be even in that case

and the statement,

return ((n & 1) == 0) ? (sum - mat[n >> 1][n >> 1]) : sum;

is equivalent to

if((n % 2) == 0) {
return sum - mat[n / 2][n / 2];
}

return sum;
*/
