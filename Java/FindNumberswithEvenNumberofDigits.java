class Solution {
  public int findNumbers(int[] nums) {

    int count = 0;
    for(int num : nums) {
      if((num >= 10 && num < 100) || (num >= 1000 && num < 10000) || (num == 100000)) {
        ++count;
      }
    }

    return count;
  }
}
