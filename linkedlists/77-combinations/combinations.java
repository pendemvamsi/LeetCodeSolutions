class Solution {
    public List<List<Integer>> combine(int n, int k) {
         List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k,
                           List<Integer> path, List<List<Integer>> result) {

        // STOP: Combination complete
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // MOVE: Try available numbers
        for (int i = start; i <= n; i++) {

            // UPDATE: CHOOSE
            path.add(i);

            // EXPLORE
            backtrack(i + 1, n, k, path, result);

            // UNDO
            path.remove(path.size() - 1);
        }
    
        
    }
}