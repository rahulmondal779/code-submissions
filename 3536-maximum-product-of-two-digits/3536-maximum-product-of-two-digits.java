class Solution {
    public int maxProduct(int n) {
        List<Integer> nums = new ArrayList<>();
        while (n!=0) {
            int num = n%10;
            nums.add(num);
            n=n/10;
        }

        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i+1; j < nums.size(); j++) {
                maxProduct = Math.max(maxProduct, nums.get(i) * nums.get(j));
            }
        }

        return maxProduct;
    }
}