class Solution {
  public boolean checkString(String s) {

    int i = 0;
    int len = s.length();
    char[] ch = s.toCharArray();
    while(i < len && ch[i] == 'a') {
      ++i;
    }

    while(i < len) {
      if(ch[i] == 'a') {
        return false;
      }
      ++i;
    }

    return true;
  }
}
