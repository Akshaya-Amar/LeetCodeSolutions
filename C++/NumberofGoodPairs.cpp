class Solution {
public:
  int numIdenticalPairs(vector<int>& nums) {

    int freq[101] = {0};
    int goodPairsCount = 0;

    for(int num : nums) {
      goodPairsCount += freq[num]++;
    }

    return goodPairsCount;
  }
};
