/*

Source: https://leetcode.com/problems/decode-xored-array/

Time: O(n), where n is the size of the given encoded array
Space: O(1), in-place

*/

class Solution {
public:
  vector<int> decode(vector<int>& encoded, int first) {

    encoded.insert(encoded.begin(), first);
    int size = encoded.size();

    for(int i = 1; i < size; ++i) {
      encoded[i] ^= encoded[i - 1];
    }

    return encoded;
  }
};
