/*

Source: https://leetcode.com/problems/excel-sheet-column-number/

Time: O(n), where n is the length of the given string(columnTitle)
Space: O(1), in-place

*/

class Solution {
  public int titleToNumber(String columnTitle) {

    int columnNumber = 0;
    int len = columnTitle.length();

    for(int i = 0; i < len; ++i) {
      int currentLetterMapping = columnTitle.charAt(i) - 'A' + 1;
      columnNumber = (columnNumber * 26) + currentLetterMapping;
    }

    return columnNumber;
  }
}
