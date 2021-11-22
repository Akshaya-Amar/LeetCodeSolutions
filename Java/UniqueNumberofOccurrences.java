/*

Source: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

Time: O(n), where n is the length of the given array
Space: O(n), not an in-place

*/

class Solution {
  public boolean uniqueOccurrences(int[] arr) {

    Map<Integer, Integer> count = new HashMap<>();
    for(int element : arr) {
      count.put(element, count.getOrDefault(element, 0) + 1);
    }

    HashSet<Integer> seen = new HashSet<>();
    for(int value : count.values()) {
      if(!seen.add(value)) {
        return false;
      }
    }

    return true;
  }
}
