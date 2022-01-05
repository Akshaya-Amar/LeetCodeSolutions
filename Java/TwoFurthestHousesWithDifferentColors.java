/*

Source: https://leetcode.com/problems/two-furthest-houses-with-different-colors/

Time: O(n), where n is the size of the given array(colors)
Space: O(1), in-place

*/

class Solution {
  public int maxDistance(int[] colors) {

    int len = colors.length - 1;
    int j = len;
    int firstElement = colors[0];
    while(colors[j] == firstElement) {
      --j;
    }

    int i = 0;
    int lastElement = colors[len];
    while(colors[i] == lastElement) {
      ++i;
    }

    return Math.max(j, len - i);
  }
}
