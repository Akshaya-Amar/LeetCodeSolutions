/*

Source: https://leetcode.com/problems/valid-mountain-array/

Time: O(n), where n is the length of the provided array(arr)
Space: O(1), in-place

*/

class Solution {
  public boolean validMountainArray(int[] arr) {

    int len = arr.length;
    if(len < 3) {
      return false;
    }

    int i = 0;
    while(++i < len && arr[i] > arr[i - 1]);

    if(i == 1 || i == len) {
      return false;
    }

    while(i < len && arr[i] < arr[i - 1]) {
      ++i;
    }

    return i == len;
  }
}
