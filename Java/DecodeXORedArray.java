/*

Source: https://leetcode.com/problems/decode-xored-array/

Time: O(n), where n is the size of the given encoded array
Space: O(1), in-place, though we are using an extra array(decoded) but we will still treat space as O(1) and
not O(n) because we usually don't consider the output in the space complexity
i.e. only temporary spaces which are used to get the desired output are considered.

*/

class Solution {
  public int[] decode(int[] encoded, int first) {

    int len = encoded.length;
    int[] decoded = new int[len + 1];
    decoded[0] = first;

    for(int i = 0; i < len; ++i) {
      decoded[i + 1] = decoded[i] ^ encoded[i];
    }

    return decoded;
  }
}
