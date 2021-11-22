/*

Source: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

Time: O(logn), where log base2 n is the number of iterations done
Space: O(1), in-place

*/

class Solution {
  public int numberOfSteps(int num) {

    if(num == 0) {
      return 0;
    }

    int steps = 0;
    while(num != 0) {
      steps += (num & 1) + 1;
      num >>= 1;
    }

    return steps - 1;
  }
}
