class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
          Map<String, Integer> map = new HashMap<>();
        int[] freq = new int[26];
        int distinct = 0, ans = 0;

        for (int l = 0, r = 0; r < s.length(); r++) {
            if (freq[s.charAt(r) - 'a']++ == 0) distinct++;

            if (r - l + 1 > minSize &&
                --freq[s.charAt(l++) - 'a'] == 0) distinct--;

            if (r - l + 1 == minSize && distinct <= maxLetters)
                ans = Math.max(ans, map.merge(s.substring(l, r + 1), 1, Integer::sum));
        }
        return ans;
    }
}