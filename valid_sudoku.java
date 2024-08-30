import java.util.*;

class valid_sudoku {
    public static boolean isValidSudoku(char[][] board) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Set<Integer> rset = new HashSet<>();
                if (board[i][j] == '.')
                    continue;
                int num = board[i][j] - '0';
                if (rset.contains(num)) {
                    return false;
                }
                rset.add(num);
            }

            for (int k = 0; k < n; k++) {
                Set<Integer> cset = new HashSet<>();
                if (board[k][i] == '.')
                    continue;
                int num = board[k][i] - '0';
                if (cset.contains(num)) {
                    return false;
                }
                cset.add(num);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] b1 = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        char[][] b2 = { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        // System.out.println(isValidSudoku(b1));
        System.out.println(isValidSudoku(b2));
    }
}