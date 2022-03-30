/*

Source: https://leetcode.com/problems/find-the-duplicate-number/

3 Approaches

1st Approach(By using extra space)

Time: O(n), where n is the length of the given array(nums)
Space: O(n), hashset is needed to add each num in nums

*/

class Solution {
  public int findDuplicate(int[] nums) {

    Set<Integer> seen = new HashSet<>();
    for(int num : nums) {
      if(!seen.add(num)) {
        return num;
      }
    }

    return -1;
  }
}

/*

Approach 2 (By modifying array)

Time: O(n), where n is the length of the given array(nums)
Space: O(1), in-place

*/

class Solution {
  public int findDuplicate(int[] nums) {

    for(int num : nums) {

      int curr = Math.abs(num);
      if(nums[curr] < 0) {
        return curr;
        // return -nums[i];// will not work for cases like [2,1,4,4,3], but will work for [3,4,2,1,4]
      }

      nums[curr] = -nums[curr];
    }

    return -1;
  }
}

/*

Approach 3 (Using Floyd's cycle detection algorithm(Tortoise and Hare or Slow and Fast pointer))

Time: O(n), where n is the length of the given array(nums)
Space: O(1), in-place

*/

class Solution {
  public int findDuplicate(int[] nums) {

    int slow = nums[0];
    int fast = nums[0];

    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while(fast != slow);

    fast = nums[0];
    while(fast != slow) {
      fast = nums[fast];
      slow = nums[slow];
    }

    return fast;
    // return slow;
  }
}
