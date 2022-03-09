/*

Source: https://leetcode.com/problems/climbing-stairs/

Approach 1

Time: O(n), where n is the given n
Space: O(n), an array is needed to store the steps

*/

class Solution {
  public int climbStairs(int n) {

    int[] ways = new int[n + 1];
    ways[0] = 1;
    ways[1] = 1;

    for(int i = 2; i <= n; ++i) {
      ways[i] = ways[i - 1] + ways[i - 2];
    }

    return ways[n];
  }
}

/*

Approach 2 (without using extra array)

Time: O(n), where n is the given n
Space: O(1), in-place

*/

class Solution {
  public int climbStairs(int n) {

    int first = 1;
    int second = 1;
    int ways = 0;

    for(int i = 1; i < n; ++i) {
      ways = first + second;
      first = second;
      second = ways;
    }

    return second;
  }
}

-------------------------------------------------------------------------------------------------------

/*

Approach 3 (performing less operations (i.e. no swapping))

Time: O(n), where n is the given n
Space: O(1), in-place

*/

class Solution {
  public int climbStairs(int n) {

    int[] ways = {1, 1};

    for(int i = 2; i <= n; ++i) {
      ways[i % 2] = ways[0] + ways[1];
    }

    return ways[n % 2];
  }
}

-------------------------------------------------------------------------------------------------------

/*

Approach 4 (same as Approach 3 but using bitwise operator)

Time: O(n), where n is the given n
Space: O(1), in-place

*/

class Solution {
  public int climbStairs(int n) {

    int[] ways = {1, 1};

    for(int i = 2; i <= n; ++i) {
      ways[i & 1] = ways[0] + ways[1];
    }

    return ways[n & 1];
  }
}

------------------------------------------------------------------------------------------------------

/*

Approach 5 (making using of n only in loop)

Time: O(n), where n is the given n
Space: O(1), in-place

*/

class Solution {
  public int climbStairs(int n) {

    int first = 1;
    int second = 1;
    int steps = 0;

    while(--n > 0) {
      steps = first + second;
      first = second;
      second = steps;
    }

    return second;
  }
}
