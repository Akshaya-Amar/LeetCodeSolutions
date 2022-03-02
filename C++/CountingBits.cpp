/*

Source: https://leetcode.com/problems/counting-bits/

Total 5 Approaches

1st Approach (brute force)

Time: O(n log base2 n)
Space: O(n), vector of size n is required

*/

class Solution {
public:
  vector<int> countBits(int n) {

    vector<int> res;
    res.push_back(0);

    for(int i = 1; i <= n; ++i) {

      int num = i;
      int setBits = 0;

      while(num != 0) {

        if((num & 1) != 0) { // is equivalent to num % 2 != 0 to check whether the number is even or odd
          ++setBits;
        }

        num >>= 1;
      }

      res.push_back(setBits);
    }

    return res;
  }
};

/*

2nd Approach (using Brian Kernighan Algorithm)

Refer to the following link for detailed explanation of Brian Kernighan Algorithm
https://leetcode.com/problems/number-of-1-bits/discuss/1519675/JAVA-C%2B%2B-%3A-Simple-or-O(1)-Time-or-Faster-than-100-or-Detailed-Explanation

Time: O(n log base2 n)
Space: O(n), array of size n is required

*/

class Solution {
public:
  vector<int> countBits(int n) {

    vector<int> res;
    res.push_back(0);

    for(int i = 1; i <= n; ++i) {

      int num = i;
      int setBits = 0;

      while(num != 0) {
        num &= num - 1;
        ++setBits;
      }

      res.push_back(setBits);
    }

    return res;
  }
};

/*

3rd Approach (more optimized than 2nd approach based on observation of the pattern formed)

A number can be either even or odd, and
Last bit of even number is 0 and odd number is 1

1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
6 --> 110
7 --> 111
8 --> 1000
9 --> 1001
10 --> 1010

when number is even
suppose x = 6, now x / 2 = 3, here number of bits in x(i.e. 6) are 2 and set bits in x / 2(i.e. 3) are also 2
so, we can say, number of bits in x = number of bits in (x / 2)

and when number is odd
suppose x = 9, now x - 1 = 8, here number of set bits in x(i.e. 9) are 2 and set bits in x - 1(i.e. 8) are 1
so, we can say, number of bits in x = number of bits in (x - 1) + 1

Based on this observation, we can solve this problem in O(n)

Time: O(n)
Space: O(n), array of size n is required

*/

class Solution {
public:
  vector<int> countBits(int n) {

    vector<int> res(n + 1);
    res[0] = 0;

    for(int i = 1; i <= n; ++i) {

      if((i & 1) == 0) {
        res[i] = res[i >> 1];
      } else {
        res[i] = res[i - 1] + 1;
      }
    }

    return res;
  }
};

/*

4th Approach (more optimized than 3rd approach also based on observation)

A number can be either even or odd, and
Last bit of even number is 0 and odd number is 1

1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
6 --> 110
7 --> 111
8 --> 1000
9 --> 1001
10 --> 1010

when number is even
suppose x = 6, now x / 2 = 3, here number of bits in x(i.e. 6) are 2 and set bits in x / 2(i.e. 3) are also 2
so, we can say, number of bits in x = number of bits in (x / 2)

and when number is odd
suppose x = 9, now x / 2 = 4, here number of set bits in x(i.e. 9) are 2, but set bits in x / 2(i.e. 4) are 1
so, we can say, number of bits in x = number of bits in (x / 2) + 1

Based on this observation, we can solve this problem in O(n)

Time: O(n)
Space: O(n), vector of size n is required

*/

class Solution {
public:
  vector<int> countBits(int n) {

    vector<int> res(n + 1);
    res[0] = 0;

    for(int i = 1; i <= n; ++i) {

      if((i & 1) == 0) {
        res[i] = res[i >> 1];
      } else {
        res[i] = res[i >> 1] + 1;
      }
    }

    return res;
  }
};

/*

5th Approach (more optimized than 4th approach without using if/else condition)

Time: O(n)
Space: O(n), vector of size n is required

*/

class Solution {
public:
  vector<int> countBits(int n) {

    vector<int> res(n + 1);
    res[0] = 0;

    for(int i = 1; i <= n; ++i) {
      res[i] = res[i >> 1] + (i & 1);
    }

    return res;
  }
};
