class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int minimumAbsoluteDistance = Integer.MAX_VALUE;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (hashMap.containsKey(nums[i])) {
                minimumAbsoluteDistance = Math.min(minimumAbsoluteDistance, i - hashMap.get(nums[i]));
            }

            hashMap.put(reverse(nums[i]), i);
        }

        return minimumAbsoluteDistance == Integer.MAX_VALUE ? -1 : minimumAbsoluteDistance;
    }

    public int reverse(int x) {
        int reverse = 0;
        while (x!=0) {
            int temp = x%10;
            x = x /10;
            reverse = reverse * 10 + temp;
        }
        
        return reverse;
    }
}