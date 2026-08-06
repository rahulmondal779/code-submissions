class Solution {
    public int[] countBits(int n) {
        int[] onesBits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            onesBits[i] =  onesBits[i >> 1] + (i & 1);
        }

        return onesBits;
    }
}