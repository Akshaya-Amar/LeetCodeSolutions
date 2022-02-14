/*

Source: https://leetcode.com/problems/permutation-in-string/

1st approach

Time: O(m * n), where m is total number lower case english letters(26) and n is the length of the given string s2
Space: O(n + k), we need char array for both the string i.e. s2 and s1

*/

class Solution {
  public boolean checkInclusion(String s1, String s2) {

    int s1Len = s1.length();
    int s2Len = s2.length();

    if(s1Len > s2Len) {
      return false;
    }

    char[] s1CharFreq = new char[26];
    char[] s2CharFreq = new char[26];
    char[] s1Chars = s1.toCharArray();
    char[] s2Chars = s2.toCharArray();

    for(int i = 0; i < s1Len; ++i) {
      ++s1CharFreq[s1Chars[i] - 'a'];
      ++s2CharFreq[s2Chars[i] - 'a'];
    }

    for(int i = s1Len; i < s2Len; ++i) {

      if(isPerm(s1CharFreq, s2CharFreq)) {
        return true;
      }

      ++s2CharFreq[s2Chars[i] - 'a'];
      --s2CharFreq[s2Chars[i - s1Len] - 'a'];
    }

    return isPerm(s1CharFreq, s2CharFreq);
  }

  private boolean isPerm(char[] s1CharFreq, char[] s2CharFreq) {

    for(int i = 0; i < 26; ++i) {
      if(s1CharFreq[i] != s2CharFreq[i]) {
        return false;
      }
    }

    return true;
  }
}

---------------------------------------------------------------------------------------------------

/*

2nd approach (More optimized as we are using only a single array(charFreq))

Time: (n * m), where m is total number lower case english letters(26) and n is the length of the given string s2
Space: O(1), in-place, though we are using an array(charFreq) of size 26, but still the size will remain same for
all cases as the array size of 26 is fixed and doesn't depend on the input

*/

class Solution {
  public boolean checkInclusion(String s1, String s2) {

    int s1Len = s1.length();
    int s2Len = s2.length();

    if(s1Len > s2Len) {
      return false;
    }

    char[] charFreq = new char[26];
    for(int i = 0; i < s1Len; ++i) {
      ++charFreq[s1.charAt(i) - 'a'];
      --charFreq[s2.charAt(i) - 'a'];
    }

    for(int i = s1Len; i < s2Len; ++i) {

      if(isPerm(charFreq)) {
        return true;
      }

      --charFreq[s2.charAt(i) - 'a'];
      ++charFreq[s2.charAt(i - s1Len) - 'a'];
    }

    return isPerm(charFreq);
  }

  private boolean isPerm(char[] charFreq) {

    for(int i = 0; i < 26; ++i) {

      if(charFreq[i] != 0) {
        return false;
      }
    }

    return true;
  }
}

---------------------------------------------------------------------------------------------------

/*

3rd approach (Most Optimized)

Time: O(n), where n is the length of the given string s2
Space: O(1), in-place, though we are using an array(charFreq) of size 26, but still the size will remain same for
all cases as the array size of 26 is fixed and doesn't depend on the input

*/
class Solution {
  public boolean checkInclusion(String s1, String s2) {

    int s1Len = s1.length();
    int s2Len = s2.length();

    if(s1Len > s2Len) {
      return false;
    }

    int[] charFreq = new int[26];
    for(int i = 0; i < s1Len; ++i) {
      ++charFreq[s1.charAt(i) - 'a'];
    }

    int i = 0;
    int j = 0;
    int totalChars = 0;
    while(j < s2Len) {

      if(charFreq[s2.charAt(j) - 'a']-- > 0) {
        ++totalChars;
      }

      if(totalChars == s1Len) {
        return true;
      }

      if(++j - i == s1Len) {

        if(charFreq[s2.charAt(i) - 'a']++ >= 0) {
          --totalChars;
        }

        ++i;
      }
    }

    return false;
  }
}
