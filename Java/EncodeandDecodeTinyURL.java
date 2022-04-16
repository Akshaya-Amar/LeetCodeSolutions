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

/*

2nd Approach

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
    return map.get(getStoredHashCode(shortUrl));
  }

  private int getStoredHashCode(String shortUrl) {

    int end = shortUrl.length() - 1;

    while(shortUrl.charAt(end) != '/') {
      --end;
    }

    ++end;

    boolean isNegative = false;
    if(shortUrl.charAt(end) == '-') {
      isNegative = true;
      ++end;
    }

    int num = 0;
    int len = shortUrl.length();

    for(int i = end; i < len; ++i) {
      num = (num * 10) + (shortUrl.charAt(i) - '0');
    }

    if(isNegative) {
      num *= -1;
    }

    return num;
  }
}
