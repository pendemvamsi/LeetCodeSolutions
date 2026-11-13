
class Solution {
    

    public List<List<Integer>> subsets(int[] nums) {
          List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start,
                           List<Integer> path, List<List<Integer>> result) {

        // STOP / SAVE
        result.add(new ArrayList<>(path));

        // MOVE
        for (int i = start; i < nums.length; i++) {

            // UPDATE: CHOOSE
            path.add(nums[i]);

            // EXPLORE
            backtrack(nums, i + 1, path, result);

            // UNDO
            path.remove(path.size() - 1);
        }
    }
}
