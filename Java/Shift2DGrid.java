/*

Source: https://leetcode.com/problems/shift-2d-grid/

1st Approach(Brute force)

Basic Idea:

- Create a 1-D array from 2-D array
eg:
grid[][] = |10 20 30| and k = 2
           |40 50 60|

[10, 20, 30, 40, 50, 60]

- Rotate this 1-D array according to the k shifts(here k = 2)
[50, 60, 10, 20, 30, 40]

- Add the result of 1-D array into the list
[[50, 60, 10], [20, 30, 40]] --> Desired Output

Time: O(m * n), where m is the number of rows and n is the number of columns
Space: O(m * n), an array(arr) is needed to create 1-D array from 2-D array

*/

class Solution {
  public List<List<Integer>> shiftGrid(int[][] grid, int k) {

    int m = grid.length;
    int n = grid[0].length;
    int len = m * n;
    int[] arr = new int[len];

    // create a 1-D array from 2-D array using (n * row + col)
    for(int row = 0; row < m; ++row) {
      for(int col = 0; col < n; ++col) {
        arr[n * row + col] = grid[row][col];
      }
    }

    k %= len;

    // rotate the 1-D array according to the k shifts
    rotate(arr, 0, len - 1);
    rotate(arr, 0, k - 1);
    rotate(arr, k, len - 1);

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    // add the result of 1-D array into the list
    for(int i = 0; i < len; ++i) {

      list.add(arr[i]);

      if((i + 1) % n == 0) {
        res.add(list);
        list = new ArrayList<>();
      }
    }

    return res;
  }

  private void rotate(int[] arr, int start, int end) {

    while(start < end) {
      int temp = arr[start];
      arr[start++] = arr[end];
      arr[end--] = temp;
    }
  }
}

/*

Approach 2(More optimized than approach 1)

Basic Idea:
Treat 2-D array as 1-D array and find the index of element.
Now, shift that element according to given k.
Convert the founded index of 1-D array into rows and columns of 2-D array and place the elements at their desired positions

Time: O(m * n), where m is the number of rows and n is the number of columns
Space: O(m * n), an array(arr) is needed to create 1-D array from 2-D array

*/

class Solution {
  public List<List<Integer>> shiftGrid(int[][] grid, int k) {

    int m = grid.length;
    int n = grid[0].length;
    int[][] arr = new int[m][n];
    int len = m * n;

    for(int row = 0; row < m; ++row) {

      for(int col = 0; col < n; ++col) {
        int indexOfElementAfterShift = ((row * n) + col + k) % (len);
        arr[indexOfElementAfterShift / n][indexOfElementAfterShift % n] = grid[row][col];
      }
    }

    return (List) Arrays.asList(arr);
  }
}

/*

Approach 3(More optimized than Approach 2)

Time: O(m * n), where m is the number of rows and n is the number of columns
Space: O(1), constant-space

*/

class Solution {
  public List<List<Integer>> shiftGrid(int[][] grid, int k) {

    int m = grid.length;
    int n = grid[0].length;
    int len = m * n;
    k %= len;
    List<List<Integer>> res = new ArrayList<>();

    for(int row = 0; row < m; ++row) {

      List<Integer> al = new ArrayList<>();

      for(int col = 0; col < n; ++col) {
        int indexOfElementBeforeShift = ((row * n) + col + len - k) % (len);
        al.add(grid[indexOfElementBeforeShift / n][indexOfElementBeforeShift % n]);
      }
      res.add(al);
    }

    return res;
  }
}
