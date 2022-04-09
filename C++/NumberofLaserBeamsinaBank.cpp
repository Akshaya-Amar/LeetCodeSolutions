/*

Source: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/

Basic Idea:
Find the number of laser beams between 2 adjacent rows by multiplying number of security devices present in the first row of pair with the number of security devices in the second row of that pair
Add number of laser beams from each pair of adjacent row

Time: O(n * m), where n is the size of the given vector(bank) and m is the length of each string
Space: O(1), constant space

*/

class Solution {
public:
  int numberOfBeams(vector<string>& bank) {

    int laserBeams = 0;
    int prevDevicesFreq = 0;

    for(string row : bank) {

      int currDevicesFreq = 0;

      for(char ch : row) {
        if(ch == '1') {
          ++currDevicesFreq;
        }
      }

      if(currDevicesFreq > 0) {
        laserBeams += prevDevicesFreq * currDevicesFreq;
        prevDevicesFreq = currDevicesFreq;
      }
    }

    return laserBeams;

  }
};
