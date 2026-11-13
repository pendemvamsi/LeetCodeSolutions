class Solution {
    public long sumDigitDifferences(int[] nums) {
         int n = nums.length;
        long answer = 0;
        long divisor = 1;

        while (nums[0] / divisor > 0) {
            int[] freq = new int[10];

            for (int num : nums)
                freq[(int) (num / divisor % 10)]++;

            long differentPairs = 0;

            for (int count : freq)
                differentPairs += (long) count * (n - count);

            answer += differentPairs / 2;
            divisor *= 10;
        }

        return answer;
    }
}