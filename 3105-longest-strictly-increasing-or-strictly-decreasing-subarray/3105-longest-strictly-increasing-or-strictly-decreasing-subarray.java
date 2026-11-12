class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLength = 0;

        for(int i = 0; i<nums.length; i++) {
            int currentLength = 1;
            for(int j = i+1; j<nums.length; j++) {
                if(nums[j] > nums[j-1]) {
                    currentLength++;
                } else {
                    break;
                }
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        for(int i = 0; i< nums.length; i++) {
            int currentLength = 1;
            for(int j = i+1; j<nums.length;j++) {
                if(nums[j] < nums[j-1]) {
                    currentLength++;
                } else {
                    break;
                }
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
        
    }
}