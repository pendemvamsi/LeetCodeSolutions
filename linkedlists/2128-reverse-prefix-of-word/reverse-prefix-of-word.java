class Solution {
    public String reversePrefix(String word, char ch) {
         char[] chars = word.toCharArray();
        int right = word.indexOf(ch);

        if (right == -1) return word;

        int left = 0;

        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }

        return new String(chars);
        
    }
}