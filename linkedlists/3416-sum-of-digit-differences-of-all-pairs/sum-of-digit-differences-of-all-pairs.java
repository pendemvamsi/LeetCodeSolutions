class Solution {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        long pairs = (long) n * (n - 1) / 2, ans = 0;

        for (long place = 1; place <= nums[0]; place *= 10) {
            int[] freq = new int[10];

            for (int x : nums)
                freq[(int)(x / place % 10)]++;

            ans += pairs;

            for (int f : freq)
                ans -= (long) f * (f - 1) / 2;
        }

        return ans;
        
    }
}