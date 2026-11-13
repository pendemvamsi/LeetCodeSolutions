class Solution {
    public long sumDigitDifferences(int[] nums) {
         int n = nums.length;
        long ans = 0;

        for (long p = 1; nums[0] / p > 0; p *= 10) {
            int[] f = new int[10];
            for (int x : nums) f[(int)(x / p % 10)]++;

            long pairs = 0;
            for (int x : f) pairs += (long)x * (n - x);

            ans += pairs / 2;
        }
        return ans;
    }
}