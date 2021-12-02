/*

Source: https://leetcode.com/problems/shuffle-string/

Time: O(n), maximum number of possible iterations is 2 * n, so O(2n) ~ O(n)
Space: O(n), not in-place as we need a char array of size equal to the length of the provided string

*/

class Solution {
  public String restoreString(String s, int[] indices) {

    char[] res = s.toCharArray();
    int len = indices.length;

    for(int i = 0; i < len; ++i) {

      while(i != indices[i]) {

        int index = indices[i];

        // swap characters according to the indexes provided in the given indices array
        char temp = res[index];
        res[index] = res[i];
        res[i] = temp;

        // swap indexes given in the indices array of corresponding characters
        int temp1 = indices[index];
        indices[index] = indices[i];
        indices[i] = temp1;
      }
    }

    return String.valueOf(res);
  }
}
