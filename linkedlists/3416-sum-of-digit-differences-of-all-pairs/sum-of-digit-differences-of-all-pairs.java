class Solution {
    public long sumDigitDifferences(int[] nums) {
        long ans = 0;
        int n = nums.length;

        for (int p = 1; p <= nums[0]; p *= 10) {
            int[] freq = new int[10];

            for (int x : nums) freq[x / p % 10]++;

            for (int f : freq)
                ans += (long) f * (n - f);
        }

        return ans / 2;
    }
}