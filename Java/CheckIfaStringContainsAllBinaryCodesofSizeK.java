/*

Source: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

Time: O(n)
Space: O(2 ^ k)

*/

class Solution {
  public static boolean hasAllCodes(String s, int k) {
    int need = 1 << k;
    boolean[] got = new boolean[need];
    int allOne = need - 1;
    int hashVal = 0;

    for (int i = 0; i < s.length(); i++) {
      hashVal = ((hashVal << 1) & allOne) | (s.charAt(i) - '0');
      if (i >= k - 1 && !got[hashVal]) {
        got[hashVal] = true;
        need--;
        if (need == 0) {
          return true;
        }
      }
    }
    return false;
  }
}
