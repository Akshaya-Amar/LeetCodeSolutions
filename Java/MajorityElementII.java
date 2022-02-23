/*

Source: https://leetcode.com/problems/majority-element-ii/

Time: O(n), where n is the size of the given array(nums)
Space: O(1), in-place

*/

class Solution {
  public List<Integer> majorityElement(int[] nums) {

    int firstCandidate = nums[0];
    int firstCandidateCount = 1;

    int secondCandidate = nums[0];
    int secondCandidateCount = 0;

    int len = nums.length;

    for(int i = 1; i < len; ++i) {

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

    List<Integer> candidates = new ArrayList<>();
    int nByThree = len / 3;

    if(firstCandidateCount > nByThree) {
      candidates.add(firstCandidate);
    }

    if(secondCandidateCount > nByThree) {
      candidates.add(secondCandidate);
    }

    return candidates;
  }
}
