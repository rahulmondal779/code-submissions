class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int pushes = 1;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            
            answer+=pushes;
            if ((i+1) % 8 == 0) {
                pushes++;
            }
        }
        

        return answer;
    }
}