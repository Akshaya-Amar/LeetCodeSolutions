/*

Source: https://leetcode.com/problems/boats-to-save-people/submissions/

Approach 1(Extended version of Approach 2 for easy understanding)

Basic Idea:
Try to make larger weight people sit first and if some space left afterwards, then check whether smaller weight person can fit in same boat


Time: O(n logn), where n is the size of the given array(people)
Space: O(1), in-place

*/

class Solution {
  public int numRescueBoats(int[] people, int limit) {

    Arrays.sort(people);

    int start = 0;
    int end = people.length - 1;
    int boats = 0;

    while(start <= end) {

      if(people[end] == limit) {
        --end;
      } else if(people[start] + people[end] <= limit) {
        ++start;
        --end;
      } else { // for cases like [6, 7, 8] and limit = 13, make the person sit having weight 8 (because 6 + 8 > 13)
        --end;
      }
      ++boats;
    }

    return boats;
  }
}

----------------------------------------------------------------------------------------------------

/*

Approach 2(More optimised)

Time: O(n logn), where n is the size of the given array(people)
Space: O(1), in-place

*/

class Solution {
  public int numRescueBoats(int[] people, int limit) {

    Arrays.sort(people);

    int boats = 0;
    int start = 0;
    int end = people.length - 1;

    while(start <= end) {

      if(people[start] + people[end] <= limit) {
        ++start;
      }
      --end;
      ++boats;
    }

    return boats;
  }
}

----------------------------------------------------------------------------------------------------

/*

Approach 3(More optimised without using extra variable boats and thus eliminating ++boats operation)

Time: O(n logn), where n is the size of the given array(people)
Space: O(1), in-place


*/

class Solution {
  public int numRescueBoats(int[] people, int limit) {

    Arrays.sort(people);

    int start = 0;
    int end = people.length - 1;

    while(start <= end) {

      if(people[start] + people[end] <= limit) {
        ++start;
      }
      --end;
    }

    return people.length - 1 - end;
  }
}
