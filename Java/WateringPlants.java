/*

Source: https://leetcode.com/problems/watering-plants/

Check at each steps if the water left in the water can is less than the capacity then,
count steps for going back to the river + coming back to water the plants, else just increment the steps as we proceed further

Time: O(n), where n is the length of the given array(plants)
Space: O(1), constant space

*/

class Solution {
  public int wateringPlants(int[] plants, int capacity) {

    int waterLeft = capacity;
    int steps = 0;
    int len = plants.length;

    for(int i = 0; i < len; ++i) {

      if(waterLeft < plants[i]) {
        waterLeft = capacity;
        steps += (i << 1) + 1; // (i << 1) is equivalent to (i * 2);
      } else {
        ++steps;
      }

      waterLeft -= plants[i];
    }

    return steps;
  }
}

/*

Approach 2(Same as Approach 1, but more optimized)

Time: O(n), where n is the length of the given array(plants)
Space: O(1), constant space

*/

class Solution {
  public int wateringPlants(int[] plants, int capacity) {

    int waterLeft = capacity;
    int steps = 0;
    int len = plants.length;

    for(int i = 0; i < len; ++i) {

      if(waterLeft < plants[i]) {
        waterLeft = capacity;
        steps += (i << 1);
      }
      waterLeft -= plants[i];
    }

    // here steps is increasing everytime as we move forward, so no need to add steps for each element repeatidly
    // eg: [1, 2, 3, 4], capacity = 10, here it's guaranteed that we will take 4 steps.
    // eg: [1, 2, 3, 4], capacity = 5, here it's guaranteed that we will take atleast 4 steps for sure.
    return steps + len;
  }
}
