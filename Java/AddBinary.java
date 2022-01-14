/*

Source: https://leetcode.com/problems/add-binary/

Time Comlexity : O(max(m, n)), where m and n are the lengths of given Strings a and b respectively.
Space Complexity : O(max(m, n)), as we need a StringBuilder whose size is equal to max of length of 2 input strings

*/

class Solution {
  public String addBinary(String a, String b) {

    int aLen = a.length() - 1;
    int bLen = b.length() - 1;
    int maxLen = Math.max(aLen, bLen) + 2;
    char[] res = new char[maxLen];
    int sum = 0;

    while(aLen >= 0 || bLen >= 0) {

      if(aLen >= 0 && a.charAt(aLen--)  == '1') {
        sum += 1;
      }

      if(bLen >= 0 && b.charAt(bLen--) == '1') {
        sum += 1;
      }

      res[--maxLen] = (char)((sum & 1) + 48);
      sum >>= 1;
    }

    if(sum != 0) {
      res[0] = '1';
      return String.valueOf(res);
    }

    return String.valueOf(res, 1, res.length - 1);
  }
}
