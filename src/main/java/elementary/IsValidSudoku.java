package elementary;

public class IsValidSudoku {
    /*
        有效的数独
            请你判断一个9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可

            数字1-9在每一行只能出现一次
            数字1-9在每一列只能出现一次
            数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次

            数独部分空格内已填入了数字，空白格用'.'表示

        示例 1：


            输入：board =
            [["5","3",".",".","7",".",".",".","."]
            ,["6",".",".","1","9","5",".",".","."]
            ,[".","9","8",".",".",".",".","6","."]
            ,["8",".",".",".","6",".",".",".","3"]
            ,["4",".",".","8",".","3",".",".","1"]
            ,["7",".",".",".","2",".",".",".","6"]
            ,[".","6",".",".",".",".","2","8","."]
            ,[".",".",".","4","1","9",".",".","5"]
            ,[".",".",".",".","8",".",".","7","9"]]

            输出：true

        示例 2：

            输入：board =
            [["8","3",".",".","7",".",".",".","."]
            ,["6",".",".","1","9","5",".",".","."]
            ,[".","9","8",".",".",".",".","6","."]
            ,["8",".",".",".","6",".",".",".","3"]
            ,["4",".",".","8",".","3",".",".","1"]
            ,["7",".",".",".","2",".",".",".","6"]
            ,[".","6",".",".",".",".","2","8","."]
            ,[".",".",".","4","1","9",".",".","5"]
            ,[".",".",".",".","8",".",".","7","9"]]

            输出：false

            解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的

     */

    /*
        暴力解法
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] line = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        // i 表示行
        for (int i = 0; i < 9; i++) {
            // j 表示列
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int sub = board[i][j] - 49;
                    if (line[i][sub]) {
                        return false;
                    } else {
                        line[i][sub] = true;
                    }
                    if (column[j][sub]) {
                        return false;
                    } else {
                        column[j][sub] = true;
                    }
                    int boxId = (i / 3) * 3 + j / 3;
                    if (box[boxId][sub]) {
                        return false;
                    } else {
                        box[boxId][sub] = true;
                    }
                }
            }
        }
        return true;
    }

    /*
        暴力解法优化1
    */
    public boolean isValidSudoku1(char[][] board) {
        int[] line = new int[9];
        int[] column = new int[9];
        int[] box = new int[9];
        // i 表示行
        for (int i = 0; i < 9; i++) {
            // j 表示列
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int value = board[i][j] - 48;
                    if ((line[i] >> value & 1) == 1) {
                        return false;
                    } else {
                        line[i] = (1 << value) | line[i];
                    }
                    if ((column[j] >> value & 1) == 1) {
                        return false;
                    } else {
                        column[j] = (1 << value) | column[j];
                    }
                    int boxId = (i / 3) * 3 + j / 3;
                    if ((box[boxId] >> value & 1) == 1) {
                        return false;
                    } else {
                        box[boxId] = (1 << value) | box[boxId];
                    }
                }
            }
        }
        return true;
    }
}
