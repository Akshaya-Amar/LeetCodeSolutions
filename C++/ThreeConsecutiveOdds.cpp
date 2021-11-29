/*

Source: https://leetcode.com/problems/three-consecutive-odds/submissions/

Time: O(n), where n is the length of the array
Space: O(1),in-place

*/

class Solution {
public:
  bool threeConsecutiveOdds(vector<int>& arr) {

    int size = arr.size() - 2;
    for(int i = 0; i < size; ++i) {
      if((arr[i] & 1) == 1 && (arr[i + 1] & 1) == 1 && (arr[i + 2] & 1) == 1) {
        return true;
      }
    }

    return false;
  }
};
