/*

Source: https://leetcode.com/problems/excel-sheet-column-number/

Time: O(n), where n is the length of the given string(columnTitle)
Space: O(1), in-place

*/

class Solution {
public:
  int titleToNumber(string columnTitle) {

    int columnNumber = 0;
    for(char ch : columnTitle) {
      int currentLetterMapping = ch - 'A' + 1;
      columnNumber = (columnNumber * 26) + currentLetterMapping;
    }

    return columnNumber;
  }
};
