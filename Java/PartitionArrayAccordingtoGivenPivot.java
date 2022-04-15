class Solution {
  public int[] pivotArray(int[] nums, int pivot) {

    int len = nums.length;
    int[] res = new int[len];
    int j = 0;

    for(int i = 0; i < len; ++i) {
      if(nums[i] < pivot) {
        res[j++] = nums[i];
      }
    }

    for(int i = 0; i < len; ++i) {
      if(nums[i] == pivot) {
        res[j++] = nums[i];
      }
    }

    for(int i = 0; i < len; ++i) {
      if(nums[i] > pivot) {
        res[j++] = nums[i];
      }
    }

    return res;
  }
}

class Solution {
  public int[] pivotArray(int[] nums, int pivot) {

    int len = nums.length;
    int[] res = new int[len];
    int elementsEqualToPivot = 0;
    int j = 0;

    for(int i = 0; i < len; ++i) {
      if(nums[i] < pivot) {
        res[j++] = nums[i];
      } else if(nums[i] == pivot) {
        ++elementsEqualToPivot;
      }
    }

    while(--elementsEqualToPivot >= 0) {
      res[j++] = pivot;
    }

    for(int i = 0; i < len; ++i) {
      if(nums[i] > pivot) {
        res[j++] = nums[i];
      }
    }

    return res;
  }
}

class Solution {
  public int[] pivotArray(int[] nums, int pivot) {

    int len = nums.length;
    int[] res = new int[len];
    int left = 0;
    int right = len - 1;
    int elementsEqualToPivot = 0;

    for(int i = 0, j = len - 1; i < len; ++i, --j) {

      if(nums[i] < pivot) {
        res[left++] = nums[i];
      } else if(nums[i] == pivot) {
        ++elementsEqualToPivot;
      }

      if(nums[j] > pivot) {
        res[right--] = nums[j];
      }
    }

    while(--elementsEqualToPivot >= 0) {
      res[left++] = pivot;
    }

    return res;
  }
}

class Solution {
  public int[] pivotArray(int[] nums, int pivot) {

    int len = nums.length;
    int[] res = new int[len];
    int left = 0;
    int right = len - 1;

    for(int i = 0, j = len - 1; i < len; ++i, --j) {

      if(nums[i] < pivot) {
        res[left++] = nums[i];
      }

      if(nums[j] > pivot) {
        res[right--] = nums[j];
      }
    }

    while(left <= right) {
      res[left++] = pivot;
    }

    return res;
  }
}
