class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long totalCost = 0;
        int left = 0, right = costs.length - 1;

        PriorityQueue<Integer> leftCandidates = new PriorityQueue<>();
        PriorityQueue<Integer> rightCandidates = new PriorityQueue<>();

        while (k-- > 0) {
            while (leftCandidates.size() < candidates && left <= right) {
                leftCandidates.offer(costs[left++]);
            }

            while (rightCandidates.size() < candidates && left <= right) {
                rightCandidates.offer(costs[right--]);
            }

            int leftCost = leftCandidates.size() > 0 ? leftCandidates.peek() : Integer.MAX_VALUE;
            int rightCost = rightCandidates.size() > 0 ? rightCandidates.peek() : Integer.MAX_VALUE;

            if (leftCost <= rightCost) {
                totalCost+=leftCost;
                leftCandidates.poll();
            } else {
                totalCost+=rightCost;
                rightCandidates.poll();
            }
        }

        return totalCost;
    }
}