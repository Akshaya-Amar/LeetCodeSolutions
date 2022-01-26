/*

Source: https://leetcode.com/problems/valid-mountain-array/

Time: O(n), where n is the size of the provided array(arr)
Space: O(1), in-place

*/

class Solution {
public:
  bool validMountainArray(vector<int>& arr) {

    int size = arr.size();
    if(size < 3) {
      return false;
    }

    int i = 0;
    while(++i < size && arr[i] > arr[i - 1]);

    if(i == 1 || i == size) {
      return false;
    }

    while(i < size && arr[i] < arr[i - 1]) {
      ++i;
    }

    return i == size;
  }
};
