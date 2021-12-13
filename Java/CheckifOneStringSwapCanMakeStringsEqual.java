class Solution {
  public boolean areAlmostEqual(String s1, String s2) {

    char ch1 =  '\u0000';
    char ch2 =  '\u0000';
    int diffElement = 0;

    for(int i = 0; i < s1.length(); ++i) {

      if(s1.charAt(i) != s2.charAt(i)) {

        ++diffElement;

        if(diffElement == 1) {
          ch1 = s1.charAt(i);
          ch2 = s2.charAt(i);
        } else if(diffElement >= 2) {
          if((s1.charAt(i) != ch2 || s2.charAt(i) != ch1) || diffElement == 3) {
            return false;
          }
        }
      }
    }

    return diffElement != 1;
  }
}
