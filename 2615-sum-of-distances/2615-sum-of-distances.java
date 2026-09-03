class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> numsIndeces = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            numsIndeces.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        

        long[] result = new long[n];
        
        for(List<Integer> indeces : numsIndeces.values()) {
            int size = indeces.size();
            long[] prefix = new long[size];

            prefix[0] = indeces.get(0);
            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i-1] + indeces.get(i);
            }

            for (int i = 0; i < size; i++) {
                int idx = indeces.get(i);

                long left = 0;
                if (i > 0) {
                    left = (long) idx * i - prefix[i - 1];
                }

                long right = 0;
                if (i < size - 1) {
                    right = (prefix[size - 1] - prefix[i]) - (long) idx * (size - i - 1);
                }

                result[idx] = left + right;
            }
        }

        return result;
    }
}