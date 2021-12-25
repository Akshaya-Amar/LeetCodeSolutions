/*

Source: https://leetcode.com/problems/rings-and-rods/

Time: O(n), where n is the length of given string(rings)
Space: O(1), i.e. in-place because though we are using array of size 10, but still it will be same for
all cases as the array size of 10 is fixed and doesn't depend on the input

*/

class Solution {
  public int countPoints(String rings) {

    int[] rods = new int[10];
    int len = rings.length();

    for(int i = 0; i < len; i += 2) {

      rods[rings.charAt(i + 1) - '0'] |= getColorCode(rings.charAt(i));
    }

    int rodsWithAllColors = 0;
    for(int colorCodesSum : rods) {
      if(colorCodesSum == 7) {
        ++rodsWithAllColors;
      }
    }

    return rodsWithAllColors;
  }

  private int getColorCode(char ch) {

    int colorCode = 0;

    switch(ch) {
      case 'R':
      colorCode = 1;
      break;

      case 'G':
      colorCode = 2;
      break;

      default:
      colorCode = 4;
    }

    return colorCode;
  }
}
