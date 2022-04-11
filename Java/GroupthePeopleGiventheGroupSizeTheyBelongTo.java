/*

Source: https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

Basic Idea:
Keep adding people in their corresponding group.
If the group is filled completely, add it to the list of groups and reset that group.

Time: O(n), where n is the length of the given array(groupSizes)
Space: O(n), map is needed to store the group

*/

class Solution {
  public List<List<Integer>> groupThePeople(int[] groupSizes) {

    List<List<Integer>> groups = new ArrayList<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int len = groupSizes.length;

    for(int i = 0; i < len; ++i) {

      List<Integer> group = map.getOrDefault(groupSizes[i], new ArrayList<>());
      group.add(i); // add people in their corresponding group

      // If the group is filled completely,
      if(group.size() == groupSizes[i]) {
        groups.add(group); // add it to the list of groups and
        group = new ArrayList<>(); // reset that group
      }

      map.put(groupSizes[i], group);
    }

    return groups;
  }
}
