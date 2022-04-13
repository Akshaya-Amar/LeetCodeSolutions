/*

Source: https://leetcode.com/problems/subdomain-visit-count/

Time: O(n * m), where n is the length of the given String array(cpdomains) and m is the length of each String in the given array
Space: O(n), Map is needed to store the frequency of paired domains

*/


class Solution {
  public List<String> subdomainVisits(String[] cpdomains) {

    Map<String, Integer> count = new HashMap();

    for (String cd : cpdomains) {
      int i = cd.indexOf(' ');
      int n = Integer.valueOf(cd.substring(0, i));
      String s = cd.substring(i + 1);
      int sLen = s.length();
      for (i = 0; i < sLen; ++i) {
        if (s.charAt(i) == '.') {
          String d = s.substring(i + 1);
          count.put(d, count.getOrDefault(d, 0) + n);
        }
      }
      count.put(s, count.getOrDefault(s, 0) + n);
    }

    List<String> res = new ArrayList();
    StringBuilder subDomain = new StringBuilder();
    for (String d : count.keySet()){
      res.add(subDomain.append(count.get(d)).append(' ').append(d).toString());
      subDomain.setLength(0);
    }
    return res;
  }
}
