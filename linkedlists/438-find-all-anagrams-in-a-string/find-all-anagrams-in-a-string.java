class Solution {
    public List<Integer> findAnagrams(String s, String p) {
         List<Integer> ans = new ArrayList<>();
        int[] freq = new int[26];
        int left = 0, k = p.length();

        for (char c : p.toCharArray())
            freq[c - 'a']++;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']--;

            if (right - left + 1 == k) {
                if (Arrays.stream(freq).allMatch(x -> x == 0))
                    ans.add(left);

                freq[s.charAt(left++) - 'a']++;
            }
        }
        return ans;
        
    }
}