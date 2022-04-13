/*

Source: https://leetcode.com/problems/subdomain-visit-count/

Basic Idea:

- Create a map to store the count/frequency of each domain/subdomain
- Pick a count paired domain from the the given array
- Take out the visits and domain name and store them seperately
- Store the domain name and visits in the map
- Iterate through the full domain name and pick it's subdomains and store them too along with their visits
- Iterate through the map and store all the count paired domains of each subdomain in the list one by one

Time: O(n * m), where n is the length of the given String array(cpdomains) and m is the length of each String in the given array
Space: O(n), a map is needed to store the frequency of paired domains

*/


class Solution {
  public List<String> subdomainVisits(String[] cpdomains) {

    Map<String, Integer> subdomainsFreq = new HashMap<>();

    for(String cpdomain : cpdomains) {

      int index = cpdomain.indexOf(' ');
      int visits = Integer.parseInt(cpdomain.substring(0, index));
      String domain = cpdomain.substring(index + 1);
      subdomainsFreq.put(domain, subdomainsFreq.getOrDefault(domain, 0) + visits);
      int domainLen = domain.length();

      for(int i = 0; i < domainLen; ++i) {
        if(domain.charAt(i) == '.') {
          String subdomain = domain.substring(i + 1);
          subdomainsFreq.put(subdomain, subdomainsFreq.getOrDefault(subdomain, 0) + visits);
        }
      }
    }

    List<String> res = new ArrayList<>();
    StringBuilder countPairedSubdomain = new StringBuilder();
    for(String subdomain : subdomainsFreq.keySet()) {
      countPairedSubdomain.append(subdomainsFreq.get(subdomain)).append(' ').append(subdomain);
      res.add(countPairedSubdomain.toString());
      countPairedSubdomain.setLength(0);
    }

    return res;
  }
}
