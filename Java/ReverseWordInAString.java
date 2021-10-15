/*

Source: https://leetcode.com/problems/reverse-words-in-a-string/submissions/

*/

class Solution {
    public String reverseWords(String s) {

        char[] ch = s.toCharArray();
        char[] res = new char[ch.length + 1]; // + 1 in [ch.length + 1] is for extra space
        int index = 0;

        for(int i = ch.length - 1; i >= 0; --i) {

            if(ch[i] == ' ') {
                continue;
            }

            int lastIndex = i;

            while(i >= 0 && ch[i] != ' ') {
                --i;
            }

            for(int firstIndex = i + 1; firstIndex <= lastIndex; ++firstIndex) {
                res[index++] = ch[firstIndex];
            }

            res[index++] = ' ';
        }

        return new String(res, 0 , index - 1); // to truncate the very last space after the word
    }
}
