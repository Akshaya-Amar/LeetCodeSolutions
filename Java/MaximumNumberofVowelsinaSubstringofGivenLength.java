/*

Source: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/submissions/

Time: O(n), where n is the length of the given string(s)
Space: O(n), we need a char array equal to the length of the given string(s) to check weather a particular character is vowel or not

*/

class Solution {
  public int maxVowels(String s, int k) {

    int[] vowels = new int[26];
    vowels[0] = vowels[4] = vowels[8] = vowels[14] = vowels[20] = 1;

    char[] ch = s.toCharArray();
    int len = ch.length;

    int currVowelCount = 0;
    for(int i = 0; i < k; ++i) {
      currVowelCount += vowels[ch[i] - 'a'];
    }

    int maxVowelCount = currVowelCount;
    for(int i = k; i < len; ++i) {

      currVowelCount += vowels[ch[i] - 'a'];
      currVowelCount -= vowels[ch[i - k] - 'a'];

      if(currVowelCount > maxVowelCount) {
        maxVowelCount = currVowelCount;
      }

      if(maxVowelCount == k) {
        break;
      }
    }

    return maxVowelCount;
  }
}
