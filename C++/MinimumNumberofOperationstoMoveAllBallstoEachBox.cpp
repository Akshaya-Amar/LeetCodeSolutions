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
