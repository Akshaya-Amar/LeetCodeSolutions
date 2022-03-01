class Solution {
  public int[] countBits(int n) {

    int[] res = new int[n + 1];

    for(int i = 1; i <= n; ++i) {

      int num = i;
      int setBits = 0;

      while(num != 0) {

        if((num & 1) != 0) {
          ++setBits;
        }

        num >>= 1;
      }

      res[i] = setBits;
    }

    return res;

  }
}


class Solution {
  public int[] countBits(int n) {

    int[] res = new int[n + 1];

    for(int i = 1; i <= n; ++i) {

      if((i & 1) == 0) {
        res[i] = res[i >> 1];
      } else {
        res[i] = res[i >> 1] + 1;
      }
    }

    return res;

  }
}

class Solution {
  public int[] countBits(int n) {

    int[] res = new int[n + 1];

    for(int i = 1; i <= n; ++i) {
      res[i] = res[i >> 1] + (i & 1);
    }

    return res;
  }
}
