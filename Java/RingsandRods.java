/*

Source: https://leetcode.com/problems/rings-and-rods/

Time: O(n), where n is the length of given string(rings)
Space: O(1), i.e. in-place.

*/

class Solution {
  public int countPoints(String rings) {

    int[] colorCodes = new int[10];
    int len = rings.length();

    for(int i = 0; i < len; i += 2) {

      colorCodes[rings.charAt(i + 1) - '0'] |= getColorCode(rings.charAt(i));
    }

    int rodsWithAllColors = 0;
    for(int colorCode : colorCodes) {
      if(colorCode == 7) {
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
