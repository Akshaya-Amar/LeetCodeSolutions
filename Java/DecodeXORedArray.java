/*

Source: https://leetcode.com/problems/decode-xored-array/

Time: O(n), where n is the size of the given encoded array
Space: O(1), in-place

*/

class Solution {
  public int[] decode(int[] encoded, int first) {

    int len = encoded.length;
    int[] decodedArr = new int[len + 1];
    decodedArr[0] = first;

    for(int i = 0; i < len; ++i) {
      decodedArr[i + 1] = decodedArr[i] ^ encoded[i];
    }

    return decodedArr;
  }
}
