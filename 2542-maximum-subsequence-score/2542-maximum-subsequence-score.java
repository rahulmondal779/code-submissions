class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] { nums2[i], nums1[i] };
        }

        // sort in decreasing order
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        // Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        long res = 0, sumS = 0;

        for (int[] pair : pairs) {
            minHeap.add(pair[1]);
            sumS += pair[1];

            if (minHeap.size()>k) {
                sumS-=minHeap.poll();
            }

            if (minHeap.size()==k) {
                res = Math.max(res, (sumS * pair[0]));
            }

        }

        return res;
    }
}