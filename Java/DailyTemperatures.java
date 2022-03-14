/*

Source: https://leetcode.com/problems/daily-temperatures/

Time: O(n), where n is the length of the given array(temperatures)
Space: O(n), extra array(stack) is required

*/

class Solution {
  public int[] dailyTemperatures(int[] temperatures) {

    int len = temperatures.length;
    int[] stack = new int[len];
    int[] answer = new int[len];
    int top = -1;

    for(int i = 0; i < len; i++) {

      while(top > -1 && temperatures[i] > temperatures[stack[top]]) {
        int idx = stack[top--];
        answer[idx] = i - idx;
      }

      stack[++top] = i;
    }

    return answer;
  }
}
