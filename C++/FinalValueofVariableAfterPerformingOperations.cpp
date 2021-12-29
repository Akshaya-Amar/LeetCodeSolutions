/*

Source: https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

Time: O(n), where n is the size of the given string array(operations)
Space: O(1), in-place

*/

class Solution {
public:
  int finalValueAfterOperations(vector<string>& operations) {

    int res = 0;
    for(string operation : operations) {
      res = (operation[1] == '+') ? (res + 1) : (res - 1);
    }

    return res;
  }
};
