/*

Source: https://leetcode.com/problems/reverse-words-in-a-string/

*/

class Solution {
    public String reverseWords(String s) {

        char[] ch = s.toCharArray();
        char[] res = new char[ch.length + 1]; // + 1 in [ch.length + 1] is for extra space
        int index = 0;

        for(int i = ch.length - 1; i >= 0; --i) {

            if(ch[i] == ' ') { // skip the spaces
                continue;
            }

            int lastIndex = i; // store the last index of the word founded

            // decrement the index until we encounter the space to get the first index of the word
            while(i >= 0 && ch[i] != ' ') {
                --i;
            }


            for(int firstIndex = i + 1; firstIndex <= lastIndex; ++firstIndex) {
                res[index++] = ch[firstIndex]; // add each character of word from first index to last index one by one
            }

            res[index++] = ' '; // add space after every word
        }

        return new String(res, 0 , index - 1); // (index - 1) to truncate the very last space which was added after the word
    }
}
