class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder(s.length());
        int end = s.length();
        while (end > 0 && s.charAt(end - 1) == ' ') {
            end--;
        }

        int start = end - 1;
        while (start >= 0) {
            if (s.charAt(start) == ' ') {
                if (start + 1 < end) {
                    if (ans.length() > 0) {
                        ans.append(' ');
                    }
                    ans.append(s.substring(start + 1, end));
                }
                while (start >= 0 && s.charAt(start) == ' ') {
                    start--;
                }
                end = start + 1;
            } else {
                start--;
            }
        }

        if (end > 0) {
            if (ans.length() > 0) {
                ans.append(' ');
            }
            ans.append(s.substring(0, end));
        }
        return ans.toString();
    }
 }