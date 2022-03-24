/*

Source: https://leetcode.com/problems/longest-palindrome/

Time: O(n + m), where n is the length of the given string(s)
Space: O(n), map is needed to store the frequency of each character in the given String(s)

*/

class Solution {
  public int longestPalindrome(String s) {

    Map<Character, Integer> charFreq = new HashMap<>();

    for(char sChar : s.toCharArray()) {
      charFreq.put(sChar, charFreq.getOrDefault(sChar, 0) + 1);
    }

    int longestPalindrome = 0;
    boolean isCharFreqOdd = false;

    for(int val : charFreq.values()) {

      if((val & 1) == 0) {
        longestPalindrome += val;
      } else {
        longestPalindrome += val - 1;
        if(!isCharFreqOdd) {
          isCharFreqOdd = true;
          longestPalindrome += 1;
        }
      }
    }

    return longestPalindrome;
  }
}

------------------------------------------------------------------------------------------------------

/*

Approach 2 (Faster than Approach 1)

Time: O(n + m), where n is the length of the given string(s) and m is the size of array taken to store frequency(charFreq)
Space: O(1), in-place though we are using extra array(charFreq) to store the frequency of each character, but the array size
will be constant for all the input string and does not depend on the input, so we treat constant(123) as O(1)

*/

class Solution {
  public int longestPalindrome(String s) {

    int[] charFreq = new int[123];// 123(0-122) because ASCII for small letter alphabets ends at 122(122 is ASCII of 'z')
    for(char sChar : s.toCharArray()) {
      ++charFreq[sChar];
    }

    int longestPalindrome = 0;
    boolean isCharFreqOdd = false;
    for(int freq : charFreq) {

      if(freq != 0) {
        if((freq & 1) == 0) {
          longestPalindrome += freq;
        } else {
          longestPalindrome += freq - 1;
          if(!isCharFreqOdd) {
            isCharFreqOdd = true;
            longestPalindrome += 1;
          }
        }
      }
    }

    return longestPalindrome;
  }
}

------------------------------------------------------------------------------------------------------
/*

Approach 3 (Better than Approach 2)

Time: O(n + m), where n is the length of the given string(s) and m is the size of array taken to store frequency(charFreq)
Space: O(1), in-place; though we are using extra array(charFreq) to store the frequency of each character, but the array size
will be constant for all the input string and does not depend on the input, so we treat constant(123) as O(1)

*/

class Solution {
  public int longestPalindrome(String s) {

    int[] charFreq = new int[123];

    for(char sChar : s.toCharArray()) {
      ++charFreq[sChar];
    }

    int longestPalindrome = 0;
    boolean isCharFreqOdd = false;

    for(int freq : charFreq) {

      if(freq != 0) {
        longestPalindrome += freq;
        if((freq & 1) != 0) {
          --longestPalindrome;
          if(!isCharFreqOdd) {
            isCharFreqOdd = true;
            longestPalindrome += 1;
          }
        }
      }
    }

    return longestPalindrome;
  }
}

------------------------------------------------------------------------------------------------------

/*

Approach 4 (Better than Approach 3)

Time: O(n + m), where n is the length of the given string(s) and m is the size of map(charFreq)
Space: O(n), map is needed to store the frequency of each character in the given String(s)

*/

class Solution {
  public int longestPalindrome(String s) {

    Map<Character, Integer> charFreq = new HashMap<>();
    for(char sChar : s.toCharArray()) {
      charFreq.put(sChar, charFreq.getOrDefault(sChar, 0) + 1);
    }

    int charWithOddFreq = 0;
    for(int val : charFreq.values()) {
      if((val & 1) != 0) {
        ++charWithOddFreq;
      }
    }

    int len = s.length();
    return (charWithOddFreq == 0) ? len : (len - charWithOddFreq + 1);
  }
}

------------------------------------------------------------------------------------------------------

/*

Approach 5(Better than approach 4)

Time: O(n + m), where n is the length of the given string(s) and m is the size of array taken to store frequency(charFreq)
Space: O(1), in-place; though we are using extra array(charFreq) to store the frequency of each character, but the array size
will be constant for all the input string and does not depend on the input, so we treat constant(123) as O(1)

*/

class Solution {
  public int longestPalindrome(String s) {

    int[] charFreq = new int[58]; // 58 --> 26(upper case alphabets(65 - 90)) + 26(lower case alphabets(97 - 122)) + 6(in between 'Z' and 'a')
    for(char sChar : s.toCharArray()){
      ++charFreq[sChar - 'A'];
    }

    int charsWithOddFreq = 0;
    for(int freq : charFreq){
      if((freq & 1) != 0){
        charsWithOddFreq++;
      }
    }

    int len = s.length();
    return (charsWithOddFreq == 0) ? len : (len - charsWithOddFreq + 1);
  }
}
