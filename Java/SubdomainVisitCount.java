/*

Source: https://leetcode.com/problems/subdomain-visit-count/

Basic Idea:
Take out domains/subdomains from each count-paired domains and maintain the frequency/count of each of domain/subdomains in a map
Get the number of visits along with the domain/subdomains and add to the list one by one

Algorithm
1. Create a Map to store the frequency of each domain/subdomains
2. Iterate through the given array of Strings(cpdomains)
  - Select a count-paired domain
  - Find index of space to get the number of visits
  - Store the number of visits and the domain
  - Put the domain along with number of visits in the map
  - Iterate through the domain, that we stored earlier
    - if we find period(.) in domain, then it means that we have found the subdomain
        - store this subdomain starting from the index of period(.) to the end of the domain's length
        - put it in the map along with visits
Repeat the same after step 2 for all remaining count-paried domains

3. Create a List to store all the count paired domin/subdomains
4. Create a StringBuilder to form the desired format using visits and domains and subdomains
5. Iterate over all the keys in the map
  - Get the number of visits of each subdomain and the subdomain and append them according to the desired format
  - Add the generated format in the list
Repeat the same after step 5 for all the remaining keys i.e. domains/subdomains in the map

6. Return the list

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
