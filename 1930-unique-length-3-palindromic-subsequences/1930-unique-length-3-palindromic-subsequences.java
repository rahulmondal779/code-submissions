class Solution {
    public int countPalindromicSubsequence(String s) {
        int count = 0;
        Set<Character> letters = new HashSet();
        for (Character character : s.toCharArray()) {
            letters.add(character);
        }

        for (Character character : letters) {
            int i = -1;
            int j = 0;

            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == character) {
                    if (i == -1) {
                        i = k;
                    }
                    j = k;
                }
            }

            Set<Character> set = new HashSet();
            for (int k = i + 1; k < j; k++) {
                set.add(s.charAt(k));
            }
            count += set.size();
        }
        return count;
    }
}