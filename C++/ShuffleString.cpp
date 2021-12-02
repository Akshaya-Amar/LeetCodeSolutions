/*

Source: https://leetcode.com/problems/shuffle-string/

Time: O(n), maximum number of possible iterations is 2 * n, so O(2n) ~ O(n)
Space: O(1), in-place

*/

class Solution {
public:
  string restoreString(string s, vector<int>& indices) {

    int size = indices.size();

    for(int i = 0; i < size; ++i) {

      while(i != indices[i]) {

        int index = indices[i];

        // swap characters according to the indexes provided in the given indices array
        char temp = s[index];
        s[index] = s[i];
        s[i] = temp;

        // swap indexes given in the indices array of corresponding characters
        int temp1 = indices[index];
        indices[index] = indices[i];
        indices[i] = temp1;
      }
    }

    return s;
  }
};
