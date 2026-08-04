class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPiles = piles[0];

        for (int i = 1; i < piles.length; i++) {
            maxPiles = Math.max(maxPiles, piles[i]);
        }
        int answer = maxPiles;

        int low = 1, high = maxPiles;

        while (low<=high) {
            int mid = low + (high - low)/2;
            long hours = 0;
            for (int pile : piles) {
                hours += calculateHour(mid, pile);
            }

            if (hours <= h) {
                answer = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return answer;
    }

    public int calculateHour(int speed, int pile) {
        return Math.ceilDiv(pile, speed);
    }
}