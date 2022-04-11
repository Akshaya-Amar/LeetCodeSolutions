/*

Source: https://leetcode.com/problems/watering-plants/

Check at each steps if the water left in the water can is less than the capacity then,
count steps for going back to the river + coming back to water the plants, else just increment the steps as we proceed further

Time: O(n), where n is the size of the given vector(plants)
Space: O(1), constant space

*/

class Solution {
public:
  int wateringPlants(vector<int>& plants, int capacity) {

    int waterLeft = capacity;
    int steps = 0;
    int size = plants.size();

    for(int i = 0; i < size; ++i) {

      if(waterLeft < plants[i]) {
        waterLeft = capacity;
        steps += (i << 1) + 1;
      } else {
        steps += 1;
      }

      waterLeft -= plants[i];
    }

    return steps;
  }
};

/*

Approach 2(Same as Approach 1, but more optimized)

Time: O(n), where n is the size of the given vector(plants)
Space: O(1), constant space

*/

class Solution {
public:
  int wateringPlants(vector<int>& plants, int capacity) {

    int waterLeft = capacity;
    int steps = 0;
    int size = plants.size();

    for(int i = 0; i < size; ++i) {

      if(waterLeft < plants[i]) {
        waterLeft = capacity;
        steps += (i << 1);
      }

      waterLeft -= plants[i];
    }

    return steps + size;
  }
};
