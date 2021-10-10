/*

Source: https://leetcode.com/problems/two-sum/

*/

class Solution {
  public int[] twoSum(int[] nums, int target) {

    HashMap<Integer, Integer> map = new HashMap<>();
    int len = nums.length;
    int complement = 0;
    int index;

    for(index = 0; index < len; ++index) {

      int num = nums[index];
      complement = target - num;

      if(map.containsKey(complement)){
        break;
      }

      map.put(num, index);
    }
    return new int[]{map.get(complement), index};
  }
}
