class Solution {

    // partition based solution
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // search on the smaller array for better time complexity
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            int nums1Left = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int nums1Right = partition1 == m ? Integer.MAX_VALUE : nums1[partition1];
            int nums2Left = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int nums2Right = partition2 == n ? Integer.MAX_VALUE : nums2[partition2];

            // partition correct
            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                if ((m + n) % 2 == 1) {
                    return Math.max(nums1Left, nums2Left);
                }

                int leftMiddle = Math.max(nums1Left, nums2Left);
                int rightMiddle = Math.min(nums1Right, nums2Right);

                return (leftMiddle + rightMiddle) / 2.0;
            } else if (nums1Left > nums2Right) { // partition is too far right
                right = partition1 - 1;
            } else { // partition is too far left
                left = partition1 + 1;
            }
        }
        return 0.0d;
    }
}