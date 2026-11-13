class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
for (int i = 0; i < s.length(); i++) {
    for (int l = i, r = i; l >= 0 && r < s.length() &&
         s.charAt(l) == s.charAt(r); l--, r++) ans++;
    for (int l = i, r = i + 1; l >= 0 && r < s.length() &&
         s.charAt(l) == s.charAt(r); l--, r++) ans++;
}
return ans;
    }
        
}