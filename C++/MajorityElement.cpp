/*

Source: https://leetcode.com/problems/majority-element/

Approach 1 (using extra space by taking map)

Time: O(n), where n is the length of the given vector(nums)
Space: O(n), map is required to store the frequency of each element

*/

class Solution {
public:
  int majorityElement(vector<int>& nums) {

    unordered_map<int, int> map;
    int majorityElement = 0;
    int halfSize = nums.size() >> 1;

    for(int num : nums) {

      if(++map[num] > halfSize) {
        majorityElement = num;
        break;
      }
    }

    return majorityElement;
  }
};

/*

Approach 2 (More optimized than approach 1 without using map)

Time: O(n), where n is the length of the given vector(nums)
Space: O(1), in-place

*/

class Solution {
public:
  int majorityElement(vector<int>& nums) {

    int majorityElement = nums[0];
    int count = 1;
    int size = nums.size();

    for(int i = 1; i < size; ++i) {

      if(count == 0) {
        majorityElement = nums[i];
      }

      count += (nums[i] == majorityElement) ? 1 : -1;
    }

    return majorityElement;
  }
};

/*

Slight modification to make it more optimized than approach 2

Time: O(n), where n is the length of the given vector(nums)
Space: O(1), in-place

*/

class Solution {
public:
  int majorityElement(vector<int>& nums) {

    int majorityElement = nums[0];
    int count = 1;
    int size = nums.size();

    for(int i = 1; i < size; ++i) {

      if(count == 0) {
        majorityElement = nums[i];
        count = 1;
      } else if(nums[i] != majorityElement) {
        --count;
      } else {
        ++count;
      }
    }

    return majorityElement;
  }
};
