class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int[] successPairs = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i<n; i++) {
            int index = binarySearch(potions, spells[i], success);
            successPairs[i] = m-index;
        }

        return successPairs;
    }

    public int binarySearch(int[] potions, int spell, long success) {
        int low = 0, high = potions.length-1;
        int ans = potions.length;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if ((long) spell * potions[mid] >= success) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}