/*

Source: https://leetcode.com/problems/remove-all-occurrences-of-a-substring/

Time: O(m * n), where m is the length of the given String(s) and n is the length of the string(part)
Space: O(n), string is needed to add characters of given String(s)

*/

class Solution {
public:
  string removeOccurrences(string s, string part) {

    string res;
    int partLen = part.length();

    for(auto ch : s) {

      res.push_back(ch);

      if(res.size() >= partLen) {

        if(res.substr(res.size() - partLen) == part) {

          int j = partLen;
          while(j != 0) {

            res.pop_back();
            --j;
          }
        }
      }
    }

    return res;
  }
};
