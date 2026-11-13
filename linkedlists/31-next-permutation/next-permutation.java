class Solution {
    public void nextPermutation(int[] nums) {
          int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        if (i < 0) {
            Arrays.sort(nums);
            return;
        }

        int j = nums.length - 1;
        while (nums[j] <= nums[i]) j--;

        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;

        Arrays.sort(nums, i + 1, nums.length);
    }
    
}