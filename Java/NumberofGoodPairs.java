class Solution {
  public int numIdenticalPairs(int[] nums) {

    int[] freq = new int[101];
    int goodPairsCount = 0;

    for(int num : nums) {
      goodPairsCount += freq[num]++;
    }

    return goodPairsCount;
  }
}
