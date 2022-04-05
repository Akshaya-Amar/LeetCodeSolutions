/*

Source: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/

Time: O(n * m), where n is the length of the given String(banks) and m is the length of each element
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
