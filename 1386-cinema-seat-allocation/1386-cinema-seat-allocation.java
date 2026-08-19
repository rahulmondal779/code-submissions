class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> rowAndSeatReservedMapping = new HashMap<>();
        boolean groupA = true;
        boolean groupB = true;
        boolean groupC = true;

        for(int[] seat : reservedSeats) {
            if(!rowAndSeatReservedMapping.containsKey(seat[0])){
                rowAndSeatReservedMapping.put(seat[0], new ArrayList<>());
            }

            rowAndSeatReservedMapping.get(seat[0]).add(seat[1]);
        }

        int group = 0;
        int reservedSeatRowcount = 0;

        for(int reservedSeatRow : rowAndSeatReservedMapping.keySet()) {
            groupA = true;
            groupB = true;
            groupC = true;
            reservedSeatRowcount++;
            for(int reservedSeat : rowAndSeatReservedMapping.get(reservedSeatRow)) {
                if (reservedSeat == 2 || reservedSeat == 3 || reservedSeat == 4 || reservedSeat == 5) {
                    groupA = false;
                }

                if (reservedSeat == 4 || reservedSeat == 5 || reservedSeat == 6 || reservedSeat == 7) {
                    groupB = false;
                }

                if (reservedSeat == 6 || reservedSeat == 7 || reservedSeat == 8 || reservedSeat == 9) {
                    groupC = false;   
                }
            }

            if (groupA && groupC) {
                group += 2;
            } else if(groupA || groupB || groupC){
                group++;
            }
        }

        group += (n - reservedSeatRowcount) * 2;
        return group;
    }
}