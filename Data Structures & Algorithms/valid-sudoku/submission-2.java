class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
                Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.' ) continue;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
        }
        for (int i = 0; i < board[0].length; i++) {
                Set<Character> set = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if(board[j][i] == '.' ) continue;
                if (set.contains(board[j][i]))
                    return false;
                set.add(board[j][i]);
            }
        }
        Set<Character> set[][] = new HashSet[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set[i][j] = new HashSet<>();
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.' ) continue;
                if (set[i / 3][j / 3].contains(board[i][j]))
                    return false;
                set[i / 3][j / 3].add(board[i][j]);
            }
        }
        return true;
    }
}
