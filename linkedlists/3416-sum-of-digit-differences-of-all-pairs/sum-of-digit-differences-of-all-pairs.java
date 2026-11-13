class Solution {
    public long sumDigitDifferences(int[] nums) {
       int n = nums.length;
        long ans = 0;

        for (long div = 1; nums[0] / div > 0; div *= 10) {
            int[] freq = new int[10];

            for (int x : nums) freq[(int)(x / div % 10)]++;

            long same = 0;
            for (int f : freq) same += (long) f * (f - 1) / 2;

            ans += (long) n * (n - 1) / 2 - same;
        }
        return ans;
    }
}