class Solution {
     private static final String[] KEYS = {
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
          List<String> result = new ArrayList<>();

        if (digits.isEmpty()) return result;

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index,
                           StringBuilder path, List<String> result) {

        // STOP
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        // STATE: Get letters for current digit
        String letters = KEYS[digits.charAt(index) - '0'];

        // MOVE: Try each available letter
        for (char ch : letters.toCharArray()) {

            // UPDATE: PICK + APPEND
            path.append(ch);

            // EXPLORE
            backtrack(digits, index + 1, path, result);

            // UNDO: DELETE
            path.deleteCharAt(path.length() - 1);
        }
    
        
    }
}