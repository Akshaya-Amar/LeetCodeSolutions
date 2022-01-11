/*

Source: https://leetcode.com/problems/add-binary/

Time Comlexity : O(Max(m, n)), where m and n are the length of given Strings a and b respectively.
Space Complexity : O(Max(m, n)), as we need a StringBuilder whose size is equal to max of length of 2 input strings

*/

class Solution {
  public String addBinary(String a, String b) {

    int aLen = a.length() - 1;
    int bLen = b.length() - 1;
    StringBuilder res = new StringBuilder(Math.max(aLen, bLen) + 2);
    int sum = 0;

    while(aLen >= 0 || bLen >= 0) {

      if(aLen >= 0 && a.charAt(aLen--) == '1') {
        sum += 1;
      }

      if(bLen >= 0 && b.charAt(bLen--) == '1') {
        sum += 1;
      }

      res.append(sum & 1);
      sum >>= 1;
    }

    if(sum != 0) {
      res.append(1);
    }

    return res.reverse().toString();
  }
}
