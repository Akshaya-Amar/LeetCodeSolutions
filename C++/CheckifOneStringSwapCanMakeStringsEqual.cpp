/*

Source: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

Time: O(n), where n is the size of the string(s1)
Space: O(1), in-place

*/

class Solution {
public:
  bool areAlmostEqual(string s1, string s2) {

    int size = s1.size();

    int start = 0;
    while(start < size && s1[start] == s2[start]) {
      ++start;
    }

    int end = size - 1;
    while(end >= 0 && s1[end] == s2[end]) {
      --end;
    }

    if(start != end && start < size && end >= 0) {
      char temp = s2[start];
      s2[start] = s2[end];
      s2[end] = temp;
    }

    return s1 == s2;
  }
};
