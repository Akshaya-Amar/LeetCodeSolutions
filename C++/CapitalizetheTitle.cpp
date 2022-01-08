/*

Source: https://leetcode.com/problems/capitalize-the-title/

Time: O(n), where n is the length of the given string(title)
Space: O(1), in-place

*/

class Solution {
public:
  string capitalizeTitle(string title) {

    int len = title.length();

    for(int i = 0; i < len; ++i) {

      int firstIndex = i;

      while(i < len && title[i]  != ' ') {
        title[i] |= 32;
        ++i;
      }

      if(i - firstIndex > 2) {
        title[firstIndex] &= ~32;
      }
    }

    return title;
  }
};
