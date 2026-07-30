class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        
        for (Integer numInteger : nums) {
            queue.offer(numInteger);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}