/*

Source: https://leetcode.com/problems/kth-distinct-string-in-an-array/

Time: O(n), where n is the size of the given string array(arr)
Space: O(n), we need a hashmap for storing the boolean values of each string in the given string array(arr)

*/

class Solution {
  public String kthDistinct(String[] arr, int k) {

    Map<String, Boolean> map = new HashMap<>();
    for(String str : arr) {
      map.put(str, map.containsKey(str) ? false : true);
    }

    for(String str : arr) {
      if(map.get(str)) {
        if(--k == 0) {
          return str;
        }
      }
    }

    return "";
  }
}
