class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
         Map<Integer, Integer> freq = new HashMap<>();
        long sum = 0, maxSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            freq.merge(nums[right], 1, Integer::sum);

            if (right - left + 1 > k) {
                sum -= nums[left];
                freq.merge(nums[left], -1, Integer::sum);

                if (freq.get(nums[left]) == 0)
                    freq.remove(nums[left]);

                left++;
            }

            if (right - left + 1 == k && freq.size() == k)
                maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
        
    }
}