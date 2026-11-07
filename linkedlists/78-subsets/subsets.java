
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
         bt(nums, 0, new ArrayList<>());
        return ans;
    }

    void bt(int[] a, int i, List<Integer> path) {

        // S → STOP + A → ANSWER
        if (i == a.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // M → MOVE / CHOOSE
        path.add(a[i]);

        // EXPLORE → INCLUDE
        bt(a, i + 1, path);

        // UNDO
        path.remove(path.size() - 1);

        // EXPLORE → EXCLUDE
        bt(a, i + 1, path);
    }
}
