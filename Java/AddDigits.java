/*

Source: https://leetcode.com/problems/add-digits/

1st approach(brute force)

Time: O(log base10 n), where n is the given integer(num) and O(log base10 n) means the maximum possible iterations
Space: O(1), in-place

*/
class Solution {
  public int addDigits(int num) {

    while(num > 9) {

      int sum = 0;

      while(num != 0) {

        sum += num % 10;
        num /= 10;
      }

      num = sum;
    }

    return num;
  }
}
----------------------------------------------------------------

/*
2nd approach(optimized)

Time: O(1), constant time
Space: O(1), in-place

*/
class Solution {
  public int addDigits(int num) {

    if(num == 0) {
      return 0;
    }

    int rem = num % 9;

    if(rem == 0) {
      return 9;
    }

    return rem;
  }
}
----------------------------------------------------------------

/*
3rd approach(most optimized)

Time: O(1), constant time
Space: O(1), in-place

*/
class Solution {
  public int addDigits(int num) {

    return (num - 1) % 9 + 1;
  }
}
