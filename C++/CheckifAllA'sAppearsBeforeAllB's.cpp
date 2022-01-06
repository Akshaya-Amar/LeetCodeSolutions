class Solution {
public:
  bool checkString(string s) {

    int len = s.length();
    int i = 0;
    while(i < len && s[i] == 'a') {
      ++i;
    }

    while(i < len) {
      if(s[i] == 'a') {
        return false;
      }
      ++i;
    }

    return true;
  }
};
