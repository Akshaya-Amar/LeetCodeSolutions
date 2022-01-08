/*

Source: https://leetcode.com/problems/car-pooling/

Time: O(n), where n is the length of the given array(trips)
Space: O(n)

*/

class Solution {
public:
  bool carPooling(vector<vector<int>>& trips, int capacity) {

    int locations[1001] = {};
    int size = trips.size();

    for(int i = 0; i < size; ++i) {

      int passengers = trips[i][0];
      locations[trips[i][1]] += passengers;
      locations[trips[i][2]] -= passengers;

    }

    for(int location : locations) {

      if(location != 0) {

        capacity -= location;

        if(capacity < 0) {
          return false;
        }
      }

    }

    return true;
  }
};
