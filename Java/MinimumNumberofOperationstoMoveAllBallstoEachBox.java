/*

Source: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

Time: O(n ^ 2), where n is the length of the given String(boxes)
Space: O(1), constant-space

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

/*

Time: O(n ^ 2), where n is the length of the given String(boxes)
Space: O(n), char array is needed to access the each character of string

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

/*

Time: O(n), where n is the length of the given String(boxes)
Space: O(n), char array is needed to access the each character of string

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

/*

Time: O(n), where n is the length of the given String(boxes)
Space: O(n), char array is needed to access the each character of string

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

/*

Time: O(n), where n is the length of the given String(boxes)
Space: O(n), char array is needed to access the each character of string

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
    left[len - 1] += right[len - 1];

    for(int i = len - 2; i >= 0; --i) {

      right[i] = right[i + 1] + count;
      left[i] += right[i];

      if(ch[i] == '1') {
        count += 1;
      }
    }

    return left;
  }
}

/*

Time: O(n), where n is the length of the given String(boxes)
Space: O(n), char array is needed to access the each character of string

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
