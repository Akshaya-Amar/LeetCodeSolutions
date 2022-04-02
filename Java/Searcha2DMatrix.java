/*

Source: https://leetcode.com/problems/search-a-2d-matrix/submissions/

3 Approaches

1st Approach

Basic Idea:
Check each row and if target is less than or equal to the last element of any row, then do binary search on elements of that row

Time: O(m), more specifically (O(m + log₂(n))) where m is the number of rows and n is the number of columns
Space: O(1), constant space

*/

class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {

    int m = matrix.length;
    int n = matrix[0].length;

    for(int i = 0; i < m; ++i) {

      if(target <= matrix[i][n - 1]) {
        return isTargetPresent(matrix[i], target);
      }
    }

    return false;
  }

  private boolean isTargetPresent(int[] row, int target) {

    int start = 0;
    int end = row.length - 1;

    while(start <= end) {

      int mid = (start + end) >> 1;

      if(row[mid] == target) {
        return true;
      }

      if(target > row[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return false;
  }
}

--------------------------------------------------------------------------------------------

/*

2nd Approach

Basic Idea:
First do binary search on rows and if there is a possibility of having target in a row, then do binary search on elements of that row

Time: O(log₂(m * n)), more specifically (O(log₂(m) + log₂(n))) where m is the number of rows and n is the number of columns
Space: O(1), constant space

*/

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {

    int top = 0;
    int down = matrix.length - 1;
    int n = matrix[0].length - 1;

    while(top <= down) {

      int mid = (top + down) >> 1;

      // log(m) to search for the row having possibility of containing target
      if(target >= matrix[mid][0] && target <= matrix[mid][n]) {
        return isTargetPresent(matrix[mid], target); // log(n) to search for the target in that row
      }

      if(target > matrix[mid][n]) {
        top = mid + 1;
      } else {
        down = mid - 1;
      }
    }

    return false;
  }

  private boolean isTargetPresent(int[] row, int target) {

    int start = 0;
    int end = row.length - 1;

    while(start <= end) {

      int mid = (start + end) >> 1;

      if(row[mid] == target) {
        return true;
      }

      if(target > row[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return false;
  }
}

--------------------------------------------------------------------------------------------

/*

Approach 3 (Treat as 1D sorted array)

Time: O(log₂(m * n)), where m is the number of rows and n is the number of columns
Space: O(1), constant space

*/

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {

    int m = matrix.length;
    int n = matrix[0].length;

    int start = 0;
    int end = m * n - 1;

    while(start <= end) {

      int mid = (start + end) >> 1;
      int currElement = matrix[mid / n][mid % n]; // [mid / n] to get row and [mid % n] to get column

      if(currElement == target) {
        return true;
      }

      if(target > currElement) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return false;
  }
}
