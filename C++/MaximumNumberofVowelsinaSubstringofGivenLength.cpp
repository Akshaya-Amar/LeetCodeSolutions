/*

Source: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/submissions/

Time: O(n), where n is the length of the given string(s)
Space: O(1), in-place

*/

class Solution {
public:
  int maxVowels(string s, int k) {

    int vowels[26] = {};
    vowels[0] = vowels[4] = vowels[8] = vowels[14] = vowels[20] = 1;

    int currVowelCount = 0;
    for(int i = 0; i < k; ++i) {
      currVowelCount += vowels[s[i] - 'a'];
    }

    int maxVowelCount = currVowelCount;
    int len = s.length();
    for(int i = k; i < len; ++i) {

      currVowelCount += vowels[s[i] - 'a'];

      currVowelCount -= vowels[s[i - k] - 'a'];

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
