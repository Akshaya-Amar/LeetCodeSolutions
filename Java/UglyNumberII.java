/*

Source: https://leetcode.com/problems/ugly-number-ii/

Time: O(n), where n is a given positive integer
Space: O(n), an array is needed of length equal to the given positive integer n

*/

class Solution {
  public int nthUglyNumber(int n) {

    int[] uglyNumbers = new int[n];
    uglyNumbers[0] = 1;
    int multipleOf2 = 2;
    int multipleOf3 = 3;
    int multipleOf5 = 5;
    int ptr2 = 0;
    int ptr3 = 0;
    int ptr5 = 0;
    int index = 1;

    while(index < n) {

      int minValue = (multipleOf2 < multipleOf3) ? multipleOf2 : multipleOf3;

      if(multipleOf5 < minValue) {
        minValue = multipleOf5;
      }

      uglyNumbers[index++] = minValue;

      if(minValue == multipleOf2) {
        multipleOf2 = uglyNumbers[++ptr2] << 1;
      }
      if(minValue == multipleOf3) {
        multipleOf3 = 3 * uglyNumbers[++ptr3];
      }
      if(minValue == multipleOf5) {
        multipleOf5 = 5 * uglyNumbers[++ptr5];
      }
    }

    return uglyNumbers[index - 1];
  }
}
