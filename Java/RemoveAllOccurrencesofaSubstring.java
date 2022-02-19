/*

Source: https://leetcode.com/problems/remove-all-occurrences-of-a-substring/

1st approach
Time: O(m * n), where m is the length of the given String(s) and n is the length of the string(part)
Space: O(n), StringBuilder is needed to append characters of given String(s)

*/

class Solution {
  public String removeOccurrences(String s, String part) {

    StringBuilder res = new StringBuilder();
    int partLen = part.length();

    for(char ch : s.toCharArray()) {

      res.append(ch);
      int resLen = res.length();

      if(resLen >= partLen) {

        if(res.substring(resLen - partLen).equals(part)) {
          res.setLength(resLen - partLen);
        }
      }
    }

    return res.toString();
  }
}

/*

2nd approach (More optimzed than the 1st approach)

Time: O(m * n), where m is the length of the given string(s) and n is the length of the string(part)
Space: O(1), in-place

*/

class Solution {
  public String removeOccurrences(String s, String part) {

    int partLen = part.length();
    int index = s.indexOf(part);

    while(index != -1) {
      s = s.substring(0, index) + s.substring(index + partLen);
      index = s.indexOf(part);
    }

    return s;
  }
}

/*

3rd approach (More optimzed than the 2nd approach)

Time: O(m * n), where m is the length of the given string(s) and n is the length of the string(part)
Space: O(n), for the given String(s), an equivalent StringBuider object is needed

*/
class Solution {
  public String removeOccurrences(String s, String part) {

    StringBuilder res = new StringBuilder(s);
    int partLen = part.length();
    int index = res.indexOf(part);

    while(index != -1) {
      res.delete(index, index + partLen);
      index = res.indexOf(part, index - partLen); // indexOf(string, fromIndex) to avoid starting from 0
    }

    return res.toString();
  }
}
