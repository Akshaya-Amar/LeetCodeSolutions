/*

Source: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

Time: O(n), where n is the length of the given string(s)
Space: O(n), a char array equal to the length of the given string(s) is needed to check weather a particular character is vowel or not

*/

class Solution {
  public int maxVowels(String s, int k) {

    boolean[] vowels = new boolean[26];
    vowels[0] = vowels[4] = vowels[8] = vowels[14] = vowels[20] = true;
    char[] ch = s.toCharArray();
    int currVowelCount = 0;

    for(int i = 0; i < k; ++i) {
      if(vowels[ch[i] - 'a']) {
        currVowelCount += 1;
      }
    }

    int maxVowelCount = currVowelCount;
    int len = ch.length;

    for(int i = k; i < len; ++i) {

      if(vowels[ch[i] - 'a']) {
        currVowelCount += 1;
      }

      if(vowels[ch[i - k] - 'a']) {
        currVowelCount -= 1;
      }

      if(currVowelCount > k) {
        return k;
      }

      if(currVowelCount > maxVowelCount) {
        maxVowelCount = currVowelCount;
      }
    }

    return maxVowelCount;
  }
}
