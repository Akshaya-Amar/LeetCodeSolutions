/*

Source: https://leetcode.com/problems/majority-element-ii/

Time: O(n), where n is the size of the given vector(nums)
Space: O(1), in-place

*/

class Solution {
public:
  vector<int> majorityElement(vector<int>& nums) {

    int firstCandidate = nums[0];
    int firstCandidateCount = 1;

    int secondCandidate = nums[0];
    int secondCandidateCount = 0;

    int size = nums.size();

    for(int i = 1; i < size; ++i) {

      if(nums[i] == firstCandidate) {
        ++firstCandidateCount;
      } else if(nums[i] == secondCandidate) {
        ++secondCandidateCount;
      } else if(firstCandidateCount == 0) {
        firstCandidate = nums[i];
        firstCandidateCount = 1;
      } else if(secondCandidateCount == 0) {
        secondCandidate = nums[i];
        secondCandidateCount = 1;
      } else {
        --firstCandidateCount;
        --secondCandidateCount;
      }
    }

    firstCandidateCount = 0;
    secondCandidateCount = 0;

    for(int num : nums) {
      if(num == firstCandidate) {
        ++firstCandidateCount;
      } else if(num == secondCandidate) {
        ++secondCandidateCount;
      }
    }

    vector<int> candidates;
    int nByThree = size / 3;

    if(firstCandidateCount > nByThree) {
      candidates.push_back(firstCandidate);
    }

    if(secondCandidateCount > nByThree) {
      candidates.push_back(secondCandidate);
    }

    return candidates;
  }
};
