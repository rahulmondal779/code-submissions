class Solution {
    public String predictPartyVictory(String senate) {
        ArrayDeque<Integer> radiant = new ArrayDeque<>();
        ArrayDeque<Integer> dire = new ArrayDeque<>();
        int n = senate.length();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }


        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();
            if (r < d) {
                radiant.offer(r+n);
            } else {
                dire.offer(d+n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}