/*

Source: https://leetcode.com/problems/build-an-array-with-stack-operations/

Time: O(n), where n is the provided n
Space: O(n), we need a list to store the operations(i.e. "push", "pop")

*/

class Solution {
  public List<String> buildArray(int[] target, int n) {

    List<String> operationsNeeded = new ArrayList<>();
    int len = target.length;
    int num = 0;

    for(int i = 0; i < len; ++i) {

      while(++num != target[i]) {
        operationsNeeded.add("Push");
        operationsNeeded.add("Pop");
      }

      operationsNeeded.add("Push");
    }

    return operationsNeeded;
  }
}
