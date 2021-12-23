class Solution {
public:
  int countPoints(string rings) {

    int colorCodes[10] = {0};
    int len = rings.length();

    for(int i = 0; i < len; i += 2) {

      colorCodes[rings[i + 1] - '0'] |= getColorCode(rings[i]);
    }

    int rodsWithAllColors = 0;
    for(int colorCode : colorCodes) {
      if(colorCode == 7) {
        ++rodsWithAllColors;
      }
    }

    return rodsWithAllColors;
  }

private:
  int getColorCode(char ch) {

    int colorCode = 0;

    switch(ch) {
      case 'R':
      colorCode = 1;
      break;

      case 'G':
      colorCode = 2;
      break;

      default:
      colorCode = 4;
    }

    return colorCode;
  }
};
