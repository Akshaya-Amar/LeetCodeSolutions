/*

Source: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/

Basic Idea:
Find the number of laser beams between 2 adjacent rows by multiplying number of security devices present in the first row of pair with the number of security devices in the second row of that pair
Add number of laser beams from each pair of adjacent row

Time: O(n * m), where n is the length of the given array(bank) and m is the length of each string
Space: O(1), constant space

*/

class Solution {
  public int numberOfBeams(String[] bank) {

    int laserBeams = 0;
    int prevDevicesFreq = 0;

    for(String row : bank) {

      int currDevicesFreq = 0;

      for(char ch : row.toCharArray()) {
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
}
