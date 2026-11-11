class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;

        while (l < r) {
            // I1: h ↔ o → [o,e,l,l,h]
            // I2: e ↔ l → [o,l,l,e,h]

            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;

            l++;
            r--;
        }
    
        
    }
}