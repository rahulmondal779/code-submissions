class Solution {
    public int maxLength(int[] nums) {
        int ans = 1;

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            int gcd = 0;
            int lcm = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                gcd = greatestCommonDivisor(gcd, nums[j]);
                lcm = leastCommonMultiple(lcm, nums[j]);

                if (product == gcd * lcm) {
                    ans = Math.max(ans , j-i+1);
                }
            }
        }

        return ans;
    }

    public int greatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int leastCommonMultiple(int a, int b) {
        return (a / greatestCommonDivisor(a, b)) * b;
    }
}