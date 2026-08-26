class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int stream = 1;
        for(Integer num : target) {
            
            while (stream < num) {
                result.add("Push");
                result.add("Pop");
                stream++;
            }
            result.add("Push");
            stream++;
        }
        
        return result;
    }
}