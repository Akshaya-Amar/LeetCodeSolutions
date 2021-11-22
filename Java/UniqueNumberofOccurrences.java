class Solution {
  public boolean uniqueOccurrences(int[] arr) {

    Map<Integer, Integer> count = new HashMap<>();
    for(int element : arr) {
      count.put(element, count.getOrDefault(element, 0) + 1);
    }

    HashSet<Integer> seen = new HashSet<>();
    for(int value : count.values()) {
      if(!seen.add(value)) {
        return false;
      }
    }

    return true;
  }
}
