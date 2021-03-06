package solutions;

/**
 * https://leetcode.com/problems/n-queens-ii/
 *
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 */
public class NQueensII_052 {
    public int totalNQueens(int n) {
        return n <= 0 ? 0 : placeQueens(new int[n], 0);
    }

    private int placeQueens(int[] solution, int rowNum) {
        int cnt = 0;
        if (rowNum == solution.length) {
            return 1;
        } else {
            for (int colNum = 0; colNum < solution.length; ++colNum) {
                if (canPlaceQueen(solution, rowNum, colNum)) {
                    solution[rowNum] = colNum;
                    cnt += placeQueens(solution, rowNum + 1);
                }
            }
        }
        return cnt;
    }

    private boolean canPlaceQueen(int[] solution, int rowNum, int colNum) {
        for (int row = 0; row < rowNum; ++row) {
            if (colNum == solution[row]) return false;
            if (rowNum - row == Math.abs(colNum - solution[row])) return false;
        }
        return true;
    }
}
