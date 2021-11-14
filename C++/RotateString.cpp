/*

Source: https://leetcode.com/problems/rotate-string/

Time: O(M * N), where M is the length of String s and N is the length of String goal
Space: O(1), in-place

*/

class Solution {
public:
  bool rotateString(string s, string goal) {

    int sSize = s.size();
    int goalSize = goal.size();

    if(sSize != goalSize) {
      return false;
    }

    s = s + s;
    const char goalFirstChar = goal[0];

    for(int i = 0; i < goalSize; ++i) {

      if(s[i] == goalFirstChar) {

        int j = 0;

        while(++j < goalSize && s[i + j] == goal[j]);

        if(j == goalSize) {
          return true;
        }
      }
    }

    return false;
  }
};
