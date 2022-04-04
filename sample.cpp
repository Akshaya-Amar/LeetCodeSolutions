class Solution {
private:
  bool canPalindrome(string& s, int low, int high, bool chanceLeft = true) {

    while (low < high)  {

      if (s[low] != s[high]) {   // mismatch happened
        if (!chanceLeft) { // We used up our chance and we had another mimsmtch, so definately not a palindrome :()
          return false;
        }
        // Ok, so this was the first mismatch. But as only 1 chance was allowed, no no more chances are left!
        // chanceLeft = false;

        // Going forward, we have two options:
        // Option 1: we move low to the right by 1 and see if by doing that we get a palindrome
        // bool option1 = canPalindrome(s, low + 1, high, chanceLeft);

        // Option 2: we move hight to the left by 1 and see if by doing that we get a palindrome
        // bool option2 = canPalindrome(s, low, high - 1, chanceLeft);

        // Either one is a palindrome. We are good!
        return canPalindrome(s, low + 1, high, false) || canPalindrome(s, low, high - 1, false);
      }
      // If no mismatch we just keep incrementing low and decrementing high like we will do in a normal palindrome check.
      low++; high--;
    }
    return true;
  }

public:
  bool validPalindrome(string s) {

    int low = 0;
    int high = s.size() - 1;
    return canPalindrome(s,low,high);
  }
};
