/*

Source: https://leetcode.com/problems/keyboard-row/

*/

class Solution {

  public String[] findWords(String[] words) {

    String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

    List<String> list = new ArrayList<>();

    for(String word : words){

      String element = word.toLowerCase();

      if(isValid(rows[0], element) || isValid(rows[1], element) || isValid(rows[2], element)) {
        list.add(word);
      }
    }

    return list.toArray(new String[list.size()]);
  }

  private boolean isValid(String row, String element){

    int elementLen = element.length();
    int rowLen = row.length();

    for(int i = 0; i < elementLen; ++i){

      char ch = element.charAt(i);
      int j = 0;

      while(j < rowLen && ch != row.charAt(j)) {
        ++j;
      }

      if(j == rowLen) {
        return false;
      }
    }
    return true;
  }
}
