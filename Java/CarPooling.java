/*

Source: https://leetcode.com/problems/car-pooling/

Time: O(n), where n is the length of the given array(trips)
Space: O(n)

*/

class Solution {
  public boolean carPooling(int[][] trips, int capacity) {

    int[] locations = new int[1001];
    int len = trips.length;

    for(int i = 0; i < len; ++i) {

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
}
