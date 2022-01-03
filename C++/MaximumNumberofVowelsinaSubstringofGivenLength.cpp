/*

Source: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

Time: O(n), where n is the length of the given string(s)
Space: O(1), in-place

*/

class Solution {
public:
  int maxVowels(string s, int k) {

    bool vowels[126] = {};
    vowels[0] = vowels[4] = vowels[8] = vowels[14] = vowels[20] = true;
    int currVowelCount = 0;

    for(int i = 0; i < k; ++i) {
      if(vowels[s[i] - 'a']) {
        currVowelCount += 1;
      }
    }

    int maxVowelCount = currVowelCount;
    int len = s.length();

    for(int i = k; i < len; ++i) {

      if(vowels[s[i] - 'a']) {
        currVowelCount += 1;
      }

      if(vowels[s[i - k] - 'a']) {
        currVowelCount -= 1;
      }

      if(currVowelCount == k) {
        return k;
      }

      if(currVowelCount > maxVowelCount) {
        maxVowelCount = currVowelCount;
      }
    }

    return maxVowelCount;
  }
};
