class Solution {
public:
  vector<int> smallerNumbersThanCurrent(vector<int>& nums) {

    int freq[102] = {0};
    int size = nums.size();

    for(int i = 0; i < size; ++i) {
      ++freq[nums[i] + 1];
    }

    for(int i = 1; i < 102; ++i) {
      freq[i] += freq[i - 1];
    }

    for(int i = 0; i < size; ++i) {
      nums[i] = freq[nums[i]];
    }

    return nums;
  }
};
