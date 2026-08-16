class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining, int index, List<Integer> current,  List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (remaining < 0 || index == candidates.length) {
            return;
        }

        current.add(candidates[index]);
        backtrack(candidates, remaining - candidates[index], index, current, result);

        current.remove(current.size() - 1);
        backtrack(candidates,remaining,index + 1,current,result);
    }
}