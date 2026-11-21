class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
          if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m, half = (m + n + 1) / 2;

        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = half - i;

            int a = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int b = i == m ? Integer.MAX_VALUE : nums1[i];
            int c = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int d = j == n ? Integer.MAX_VALUE : nums2[j];

            if (a > d) right = i - 1;
            else if (c > b) left = i + 1;
            else return (m + n) % 2 == 1
                    ? Math.max(a, c)
                    : ((double) Math.max(a, c) + Math.min(b, d)) / 2;
        }
        return 0;
    
        
    }
}