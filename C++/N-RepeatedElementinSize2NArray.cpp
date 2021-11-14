class Solution {
public:
  int repeatedNTimes(vector<int>& nums) {

    const int size = nums.size();

    for(int i = 2; i < size; ++i) {

      const int num = nums[i];

      if(num == nums[i - 1] || num == nums[i - 2]) {
        return num;
      }
    }

    return nums[0];
  }
};
