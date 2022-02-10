/*

Source: https://leetcode.com/problems/k-diff-pairs-in-an-array/

Time: O(n), where n is the length of the given array(nums)
Space: O(n), we need a map to store the elements of array(nums)

*/

class Solution {
  public int findPairs(int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap<>();
    for(int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    int uniquePairs = 0;
    for(Integer key : map.keySet()) {

      if((k > 0 && map.containsKey(key + k)) || (k == 0 && map.get(key) > 1)) {
        ++uniquePairs;
      }
    }

    return uniquePairs;
  }
}
