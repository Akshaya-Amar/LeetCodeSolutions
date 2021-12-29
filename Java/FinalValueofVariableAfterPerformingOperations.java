/*

Source: https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

Time: O(n), where n is the size of the given string array(operations)
Space: O(1), in-place

*/

class Solution {
  public int finalValueAfterOperations(String[] operations) {

    int res = 0;
    for(String operation : operations) {
      res += (operation.charAt(1) == '+') ? 1 : -1;
    }

    return res;
  }
}
