/*

Source: https://leetcode.com/problems/counting-bits/

1st Approach (brute force)

Time: O(n log base 2 n)
Space: O(n), array of size n is required

*/

class Solution {
  public int[] countBits(int n) {

    int[] res = new int[n + 1];

    for(int i = 1; i <= n; ++i) {

      int num = i;
      int setBits = 0;

      while(num != 0) {

        if((num & 1) != 0) {
          ++setBits;
        }

        num >>= 1;
      }

      res[i] = setBits;
    }

    return res;

  }
}

/*

2nd Approach (optimized approach)

Time: O(n)
Space: O(n), array of size n is required

*/

class Solution {
  public int[] countBits(int n) {

    int[] res = new int[n + 1];

    for(int i = 1; i <= n; ++i) {

      if((i & 1) == 0) {
        res[i] = res[i >> 1];
      } else {
        res[i] = res[i >> 1] + 1;
      }
    }

    return res;

  }
}

/*

3rd Approach (more optimized than 2nd approach without using if/else condition)

Time: O(n)
Space: O(n), array of size n is required

*/

class Solution {
  public int[] countBits(int n) {

    int[] res = new int[n + 1];

    for(int i = 1; i <= n; ++i) {
      res[i] = res[i >> 1] + (i & 1);
    }

    return res;
  }
}
