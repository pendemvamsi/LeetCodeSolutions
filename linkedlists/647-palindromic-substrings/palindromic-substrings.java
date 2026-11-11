class Solution {
    public int countSubstrings(String s) {
        int count = 0, n = s.length();

        for (int i = 0; i < n; i++)
            for (int d = 0; d < 2; d++) {
                int l = i, r = i + d;

                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    count++;
                    l--;
                    r++;
                }
            }

        return count;
        
    }
}