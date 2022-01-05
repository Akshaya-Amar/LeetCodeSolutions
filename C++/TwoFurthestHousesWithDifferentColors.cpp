/*

Source: https://leetcode.com/problems/two-furthest-houses-with-different-colors/

Time: O(n), where n is the size of the given array(colors)
Space: O(1), in-place

*/

class Solution {
public:
  int maxDistance(vector<int>& colors) {

    int size = colors.size() - 1;
    int j = size;
    int firstElement = colors[0];
    while(colors[j] == firstElement) {
      --j;
    }

    int i = 0;
    int lastElement = colors[size];
    while(colors[i] == lastElement) {
      ++i;
    }

    return max(j, size - i);
  }
};
