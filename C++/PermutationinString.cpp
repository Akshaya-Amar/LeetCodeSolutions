/*

Source: https://leetcode.com/problems/permutation-in-string/

1st approach

Time: O(m * n), where m is total number lower case english letters(26) and n is the length of the given string s2
Space: O(1), in-place

*/

class Solution {
public:
  bool checkInclusion(string s1, string s2) {

    int s1Len = s1.length();
    int s2Len = s2.length();

    if(s1Len > s2Len) {
      return false;
    }

    vector<int> s1CharFreq(26, 0);
    vector<int> s2CharFreq(26, 0);
    for(int i = 0; i < s1Len; ++i) {
      ++s1CharFreq[s1[i] - 'a'];
      ++s2CharFreq[s2[i] - 'a'];
    }

    for(int i = s1Len; i < s2Len; ++i) {

      if(s1CharFreq == s2CharFreq) {
        return true;
      }

      ++s2CharFreq[s2[i] - 'a'];
      --s2CharFreq[s2[i - s1Len] - 'a'];
    }

    return s1CharFreq == s2CharFreq;
  }
};

---------------------------------------------------------------------------------------------------

/*

2nd approach (More optimized as we are using only a single vector(charFreq))

Time: (m * n), where m is total number lower case english letters(26) and n is the length of the given string s2
Space: O(1), in-place

*/

class Solution {
public:
  bool checkInclusion(string s1, string s2) {

    int s1Len = s1.length();
    int s2Len = s2.length();

    if(s1Len > s2Len) {
      return false;
    }

    vector<int> charFreq(26, 0);
    for(int i = 0; i < s1Len; ++i) {
      ++charFreq[s1[i] - 'a'];
      --charFreq[s2[i] - 'a'];
    }

    for(int i = s1Len; i < s2Len; ++i) {

      if(isPerm(charFreq)) {
        return true;
      }

      --charFreq[s2[i] - 'a'];
      ++charFreq[s2[i - s1Len] - 'a'];
    }

    return isPerm(charFreq);
  }

private:
  bool isPerm(vector<int>& charFreq) {

    for(int i = 0; i < 26; ++i) {

      if(charFreq[i] != 0) {
        return false;
      }
    }

    return true;
  }
};

---------------------------------------------------------------------------------------------------

/*

3rd approach (Most optimized)

Time: O(n), where n is the length of the given string s2
Space: O(1), in-place, though we are using an array(charFreq) of size 26, but still the size will remain same for
all cases as the array size of 26 is fixed and doesn't depend on the input

*/

class Solution {
public:
  bool checkInclusion(string s1, string s2) {

    int s1Len = s1.length();
    int s2Len = s2.length();

    if(s1Len > s2Len) {
      return false;
    }

    int charFreq[26] = {};
    for(int i = 0; i < s1Len; ++i) {
      ++charFreq[s1[i] - 'a'];
    }

    int i = 0;
    int j = 0;
    int totalChars = 0;
    while(j < s2Len) {

      if(charFreq[s2[j] - 'a']-- > 0) {
        ++totalChars;
      }

      if(totalChars == s1Len) {
        return true;
      }

      if(++j - i == s1Len){

        if(charFreq[s2[i] - 'a']++ >= 0) {
          --totalChars;
        }

        ++i;
      }
    }

    return false;
  }
};
