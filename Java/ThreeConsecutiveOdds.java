/*

Source: https://leetcode.com/problems/three-consecutive-odds/submissions/

Time: O(n), where n is the length of the array
Space: O(1), in-place

*/

class Solution {
  public boolean threeConsecutiveOdds(int[] arr) {

    int len = arr.length - 2;
    for(int i = 0; i < len; ++i) {
      if((arr[i] & 1) == 1 && (arr[i + 1] & 1) == 1 && (arr[i + 2] & 1) == 1) {
        return true;
      }
    }
    return false;
  }
}
