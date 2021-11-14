class Solution {
public:
  int tribonacci(int n) {

    int series[] = {0, 1, 1};

    for(int i = 3; i <= n; ++i) {
      series[i % 3] = series[0] + series[1] + series[2];
    }

    return series[n % 3];
  }
};
