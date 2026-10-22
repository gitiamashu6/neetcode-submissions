class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (wordSearch(i, j, 0, board, word))
                    return true;
            }
        }
        return false;
    }

    private boolean wordSearch(int x, int y, int i, char[][] board, String word) {
        if (isValid(x, y, board) || board[x][y] != word.charAt(i))
            return false;
        if (i == word.length() - 1)
            return true;
        char temp = board[x][y];
        board[x][y] = 'x';
        if (wordSearch(x - 1, y, i + 1, board, word)) return true;
        if (wordSearch(x + 1, y, i + 1, board, word)) return true;
        if (wordSearch(x, y - 1, i + 1, board, word)) return true;
        if (wordSearch(x, y + 1, i + 1, board, word)) return true;
        board[x][y] = temp;
        return false;
    }

    private boolean isValid(int x, int y, char[][] board) {
        return (x < 0 || y < 0 || x >= board.length || y >= board[x].length);
    }
}