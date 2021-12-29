/*

Source: https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/

Time: O(n * m), where n is the size of the given array of strings(nums) and m is the average length of all the strings in array
Space: O(n), we need a map of size equal to the size of the given array of strings(nums)

*/

class Solution {
  public int numOfPairs(String[] nums, String target) {

    Map<String, Integer> map = new HashMap<>();
    int count = 0;
    int targetLen = target.length();

    for(String num : nums) {

      if(target.startsWith(num)) {

        String sub = target.substring(num.length());
        Integer val = map.get(sub);
        if(val != null) {
          count += val;
        }
      }

      if(target.endsWith(num)) {

        String sub = target.substring(0, targetLen - num.length());
        Integer val = map.get(sub);
        if(val != null) {
          count += val;
        }
      }

      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    return count;
  }
}
