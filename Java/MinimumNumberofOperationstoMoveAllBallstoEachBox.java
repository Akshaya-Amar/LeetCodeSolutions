/*

Source: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

7 Approaches

Approach 1 (Brute force)

Time: O(n ^ 2), where n is the length of the given String(boxes)
Space: O(1), in-place, though we are using an array(answer) to store the operations,
but we will still treat space as O(1) and not O(n) because we usually don't consider the output in the space
complexity i.e. only temporary spaces which are used to get the desired output are considered.

*/

class Solution {
  public int[] minOperations(String boxes) {

    int len = boxes.length();
    int[] answer = new int[len];

    for(int i = 0; i < len; ++i) {

      int count = 0;

      for(int j = i - 1; j >= 0; --j) {

        if(boxes.charAt(j) == '1') {
          count += i - j;
        }

      }

      for(int j = i + 1; j < len; ++j) {

        if(boxes.charAt(j) == '1') {
          count += j - i;
        }
      }

      answer[i] = count;
    }

    return answer;
  }
}

-----------------------------------------------------------------------------------------------------------------------------

/*

Approach 2 (Brute force but faster than Approach 1 by avoiding charAt() repeatidly)

Time: O(n ^ 2), where n is the length of the given String(boxes)
Space: O(n), char array of size equal to length of the given String(boxes) is needed to access the each character of string

*/

class Solution {
  public int[] minOperations(String boxes) {

    char[] ch = boxes.toCharArray();
    int len = ch.length;
    int[] answer = new int[len];

    for(int i = 0; i < len; ++i) {

      int count = 0;

      for(int j = i - 1; j >= 0; --j) {
        if(ch[j] == '1') {
          count += i - j;
        }
      }

      for(int j = i + 1; j < len; ++j) {
        if(ch[j] == '1') {
          count += j - i;
        }
      }

      answer[i] = count;
    }

    return answer;
  }
}

-----------------------------------------------------------------------------------------------------------------------------

/*

Approach 3 (More optimized than Approach 2 using 4 arrays and 3 loops)

Basic Idea:
Move balls from left to right and track the number of operations took place by each ball to reach each box

eg:
String boxes = "1101"

left to right operations - |0|1|3|5|
0 - For 1st box(at index 0 of boxes), no operation took place
1 - For 2nd box(at index 1 of boxes), 1 operation took place to move ball from 1st box(index 0) to 2nd box(index 1)
3 - For 3rd box(at index 2 of boxes), 3 operations took place, i.e. 2 operations to move ball from 1st box(index 0) to 3rd box(index 2) + 1 operation to move ball from 2nd box(index 1) to 3rd box(index 2)
5 - For 4th box(at index 3 of boxes), 5 operations took place, i.e. 3 operations to move ball from 1st box(index 0) to 4th box(index 3) + 2 operations to move ball from 2nd box(index 1) to 4th box(index 3)

Do, the same operation from right to left
right to left operations - |4|2|1|0|

And add the result of left and right operations
  |0|1|3|5|
+ |4|2|1|0|
-----------
  |4|3|4|5| <---- Desired Output

Time: O(n), where n is the length of the given String(boxes)
Space: O(n), char array of size equal to length of the given String(boxes) is needed to access the each character of string

*/

class Solution {
  public int[] minOperations(String boxes) {

    char[] ch = boxes.toCharArray();
    int len = ch.length;

    int[] left = new int[len];
    int count = ch[0] - '0';

    for(int i = 1; i < len; ++i) {

      left[i] = left[i - 1] + count;

      if(ch[i] == '1') {
        count += 1;
      }
    }

    int[] right = new int[len];
    count = ch[len - 1] - '0';

    for(int i = len - 2; i >= 0; --i) {

      right[i] = right[i + 1] + count;

      if(ch[i] == '1') {
        count += 1;
      }

    }

    int[] answer = new int[len];
    for(int i = 0; i < len; ++i) {
      answer[i] = left[i] + right[i];
    }

    return answer;
  }
}

-----------------------------------------------------------------------------------------------------------------------------

/*

Approach 4 (Same as approach 3, but more optimized than Approach 3 using 3 arrays and 3 loops instead of 4 arrays)

Time: O(n), where n is the length of the given String(boxes)
Space: O(n), char array of size equal to length of the given String(boxes) is needed to access the each character of string

*/

class Solution {
  public int[] minOperations(String boxes) {

    char[] ch = boxes.toCharArray();
    int len = ch.length;
    int[] left = new int[len];
    int count = ch[0] - '0';

    for(int i = 1; i < len; ++i) {

      left[i] = left[i - 1] + count;

      if(ch[i] == '1') {
        count += 1;
      }
    }

    int[] right = new int[len];
    count = ch[len - 1] - '0';

    for(int i = len - 2; i >= 0; --i) {

      right[i] = right[i + 1] + count;

      if(ch[i] == '1') {
        count += 1;
      }
    }

    for(int i = 0; i < len; ++i) {
      left[i] += right[i];
    }

    return left;
  }
}

-----------------------------------------------------------------------------------------------------------------------------

/*

Approach 5 (More optimized than Approach 4 using 3 arrays and 2 loops)

Time: O(n), where n is the length of the given String(boxes)
Space: O(n), char array of size equal to length of the given String(boxes) is needed to access the each character of string

*/

class Solution {
  public int[] minOperations(String boxes) {

    char[] ch = boxes.toCharArray();
    int len = ch.length;
    int[] left = new int[len];
    int count = ch[0] - '0';

    for(int i = 1; i < len; ++i) {

      left[i] = left[i - 1] + count;

      if(ch[i] == '1') {
        count += 1;
      }
    }

    int[] right = new int[len];
    count = ch[len - 1] - '0';

    for(int i = len - 2; i >= 0; --i) {

      right[i] = right[i + 1] + count;

      if(ch[i] == '1') {
        count += 1;
      }

      left[i] += right[i];
    }

    return left;
  }
}

-----------------------------------------------------------------------------------------------------------------------------

/*

Approach 6 (Same as Approach 5, but more optimized than Approach 5 by eliminating if condition repeatidly)

Time: O(n), where n is the length of the given String(boxes)
Space: O(n), char array of size equal to length of the given String(boxes) is needed to access the each character of string

*/

class Solution {
  public int[] minOperations(String boxes) {

    char[] ch = boxes.toCharArray();
    int len = ch.length;
    int[] left = new int[len];
    int count = ch[0] - '0';

    for(int i = 1; i < len; ++i) {
      left[i] = left[i - 1] + count;
      count += ch[i] - '0';
    }

    int[] right = new int[len];
    count = ch[len - 1] - '0';
    left[len - 1] += right[len - 1];

    for(int i = len - 2; i >= 0; --i) {
      right[i] = right[i + 1] + count;
      count += ch[i] - '0';
      left[i] += right[i];
    }

    return left;
  }
}

-----------------------------------------------------------------------------------------------------------------------------

/*

Approach 7 (Same as Approach 6, but more optimized than Approach 6 by using only 2 arrays)

Time: O(n), where n is the length of the given String(boxes)
Space: O(n), char array of size equal to length of the given String(boxes) is needed to access the each character of string

*/

class Solution {
  public int[] minOperations(String boxes) {

    char[] ch = boxes.toCharArray();
    int len = ch.length;
    int[] answer = new int[len];
    int count = ch[0] - '0';

    for(int i = 1; i < len; ++i) {
      answer[i] = answer[i - 1] + count;
      count += ch[i] - '0';
    }

    count = ch[len - 1] - '0';
    int operations = 0;

    for(int i = len - 2; i >= 0; --i) {
      operations += count;
      count += ch[i] - '0';
      answer[i] += operations;
    }

    return answer;
  }
}
