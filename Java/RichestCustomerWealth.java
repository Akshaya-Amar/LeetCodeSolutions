/*

Source: https://leetcode.com/problems/richest-customer-wealth/

Time: O(m * n), where m is the length of array accounts and n is the length of each customer's wealth
Space: O(1), in-place

*/

class Solution {
  public int maximumWealth(int[][] accounts) {

    int maxWealth = 0;

    for(int[] customerAccount : accounts) {

      int totalCustomerWealth = 0;

      for(int wealth : customerAccount) {
        totalCustomerWealth += wealth;
      }

      if(totalCustomerWealth > maxWealth) {
        maxWealth = totalCustomerWealth;
      }
    }

    return maxWealth;
  }
}
