/*

Source: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

Time: O(n), where n is the length of candies array i.e. N is the number of elements present in the array
Space: O(n), not in-place as we need a list of size equal to the size of candies array to store their corresponding boolean values

*/

class Solution {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

    int max = 0;
    for(int candy : candies) {
      if(candy > max) {
        max = candy;
      }
    }

    max -= extraCandies;
    List<Boolean> res = new ArrayList<>(candies.length);
    for(int candy : candies) {
      res.add(candy >= max);
    }

    return res;
  }
}
