/*

1st Approach

*/

public class Codec {

  Map<Integer, String> map = new HashMap<>();

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    int longUrlHashCode = longUrl.hashCode();
    map.put(longUrlHashCode, longUrl);
    return "http://tinyurl.com/" + longUrlHashCode;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    return map.get(Integer.parseInt(shortUrl.substring(shortUrl.lastIndexOf('/') + 1)));
  }
}
