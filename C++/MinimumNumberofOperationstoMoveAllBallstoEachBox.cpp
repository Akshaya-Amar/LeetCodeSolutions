/*

Source: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

6 Approaches

Approach 1 (Brute force)

Time: O(n ^ 2), where n is the length of the given String(boxes)
Space: O(1), in-place, though we are using a vector(answer) to store the operations,
but we will still treat space as O(1) and not O(n) because we usually don't consider the output in the space
complexity i.e. only temporary spaces which are used to get the desired output are considered.

*/

class Solution {
public:
  vector<int> minOperations(string boxes) {

    int len = boxes.length();
    vector<int> answer(len);

    for(int i = 0; i < len; ++i) {

      int count = 0;

      for(int j = i - 1; j >= 0; --j) {
        if(boxes[j] == '1') {
          count += i - j;
        }
      }

      for(int j = i + 1; j < len; ++j) {
        if(boxes[j] == '1') {
          count += j - i;
        }
      }

      answer[i] = count;
    }

    return answer;
  }
};

-----------------------------------------------------------------------------------------------------------------------------

/*

Approach 2 (More optimized than Approach 1 using 3 vectors and 3 loops)

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
Space: O(n), vector is needed of length equal to the size of the string(boxes) to store the number of operations

*/

class Solution {
public:
  vector<int> minOperations(string boxes) {

    int len = boxes.length();
    vector<int> left(len);
    int ballCount = boxes[0] - '0';

    for(int i = 1; i < len; ++i) {

      left[i] = left[i - 1] + ballCount;

      if(boxes[i] == '1') {
        ballCount += 1;
      }
    }

    vector<int> right(len);
    ballCount = boxes[len - 1] - '0';

    for(int i = len - 2; i >= 0; --i) {

      right[i] = right[i + 1] + ballCount;

      if(boxes[i] == '1') {
        ballCount += 1;
      }
    }

    vector<int> answer(len);
    for(int i = 0; i < len; ++i) {
      answer[i] = left[i] + right[i];
    }

    return answer;
  }
};

-----------------------------------------------------------------------------------------------------------------------------

/*

Approach 3 (Same as Approach 2, but more optimized than Approach 2 using 2 vectors and 3 loops)

Time: O(n), where n is the length of the given String(boxes)
Space: O(n), vector is needed of length equal to the size of the string(boxes) to store the number of operations

*/

class Solution {
public:
  vector<int> minOperations(string boxes) {

    int len = boxes.length();
    vector<int> left(len);
    int ballCount = boxes[0] - '0';

    for(int i = 1; i < len; ++i) {

      left[i] = left[i - 1] + ballCount;

      if(boxes[i] == '1') {
        ballCount += 1;
      }
    }

    vector<int> right(len);
    ballCount = boxes[len - 1] - '0';

    for(int i = len - 2; i >= 0; --i) {

      right[i] = right[i + 1] + ballCount;

      if(boxes[i] == '1') {
        ballCount += 1;
      }
    }

    for(int i = 0; i < len; ++i) {
      left[i] += right[i];
    }

    return left;
  }
};

-----------------------------------------------------------------------------------------------------------------------------

/*

Approach 4 (More optimized than Approach 3 using 2 vectors and 2 loops)

Time: O(n), where n is the length of the given String(boxes)
Space: O(n), vector is needed of length equal to the size of the string(boxes) to store the number of operations

*/

class Solution {
public:
  vector<int> minOperations(string boxes) {

    int len = boxes.length();
    vector<int> left(len);
    int ballCount = boxes[0] - '0';

    for(int i = 1; i < len; ++i) {

      left[i] = left[i - 1] + ballCount;

      if(boxes[i] == '1') {
        ballCount += 1;
      }
    }

    vector<int> right(len);
    ballCount = boxes[len - 1] - '0';

    for(int i = len - 2; i >= 0; --i) {

      right[i] = right[i + 1] + ballCount;

      if(boxes[i] == '1') {
        ballCount += 1;
      }

      left[i] += right[i];
    }

    return left;
  }
};

-----------------------------------------------------------------------------------------------------------------------------

/*

Approach 5 (Same as Approach 4, but more optimized than Approach 4 by eliminating if condition repeatidly)

Time: O(n), where n is the length of the given String(boxes)
Space: O(n), vector is needed of length equal to the size of the string(boxes) to store the number of operations

*/

class Solution {
public:
  vector<int> minOperations(string boxes) {

    int len = boxes.length();
    vector<int> left(len);
    int ballCount = boxes[0] - '0';

    for(int i = 1; i < len; ++i) {
      left[i] = left[i - 1] + ballCount;
      ballCount += boxes[i] - '0';
    }

    vector<int> right(len);
    ballCount = boxes[len - 1] - '0';

    for(int i = len - 2; i >= 0; --i) {
      right[i] = right[i + 1] + ballCount;
      ballCount += boxes[i] - '0';
      left[i] += right[i];
    }

    return left;
  }
};

-----------------------------------------------------------------------------------------------------------------------------

/*

Approach 6 (Same as Approach 5, but more optimized than Approach 5 by using only 1 vector)

Time: O(n), where n is the length of the given String(boxes)
Space: O(1), in-place, though we are using a vector(answer) to store the operations,
but we will still treat space as O(1) and not O(n) because we usually don't consider the output in the space
complexity i.e. only temporary spaces which are used to get the desired output are considered.

*/

class Solution {
public:
  vector<int> minOperations(string boxes) {

    int len = boxes.length();
    vector<int> answer(len);
    int ballCount = boxes[0] - '0';

    for(int i = 1; i < len; ++i) {
      answer[i] = answer[i - 1] + ballCount;
      ballCount += boxes[i] - '0';
    }

    ballCount = boxes[len - 1] - '0';
    int operations = 0;

    for(int i = len - 2; i >= 0; --i) {
      operations += ballCount;
      ballCount += boxes[i] - '0';
      answer[i] += operations;
    }

    return answer;
  }
};
