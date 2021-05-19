package elementary;

public class RotateImg {
    /*
        旋转图像
            给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度

            你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像

        示例 1：

            输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
            输出：[[7,4,1],[8,5,2],[9,6,3]]

        示例 2：


            输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
            输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

        示例 3：

            输入：matrix = [[1]]
            输出：[[1]]

        示例 4：

            输入：matrix = [[1,2],[3,4]]
            输出：[[3,1],[4,2]]

     */

    /*
        先上下交换，在右上与左下交换
            例如:
            1 2 3
            4 5 6
            7 8 9
            上下交换后:
            7 8 9
            4 5 6
            1 2 3
            将7 5 3连成一条直线(对角线),左下与右上对称交换
            7 4 1
            8 5 2
            9 6 3
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        // 上下交换
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int[] temp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = temp;
            left++;
            right--;
        }
        // 右上与左下交换
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /*
        逐层旋转
            例如:
               1  2  3  4
               5  6  7  8
               9  10 11 12
               13 14 15 16

               旋转外层

               1. 13  2  3  1   0.0 -> 0.3
                  5   6  7  8       0.3 -> 3.3
                  9   10 11 12          3.3 -> 3.0
                  16  14 15 4               3.0 -> 0.0

               2. 13  9  3  1   0.1 -> 1.3
                  5   6  7  2       1.3 -> 3.2
                  15  10 11 12          3.2 -> 2.0
                  16  14 8  4               2.0 -> 0.1

               3. 13  9  5  1   0.2 -> 2.3
                  14  6  7  2       2.3 -> 3.1
                  15  10 11 3           3.1 -> 1.0
                  16  12 8  4               1.0 -> 0.2

               旋转内层

               1. 13  9  5  1   1.1 -> 1.2
                  14  10 6  2   1.2 -> 2.2
                  15  11 7  3   2.2 -> 2.1
                  16  12 8  4   2.1 -> 1.1

               2. 完成

     */
    public void rotate2(int[][] matrix) {
        int len = matrix.length;
        // i 表示需要旋转层数
        for (int i = 0; i < len / 2; i++) {
            // 当前这层的长度
            int currLen = len - (i * 2);
            // j 表示旋转需要交换元素的次数
            for (int j = i; j < currLen - 1 + i; j++) {
                /*
                    最外层坐标如下
                     top      [0,0]               [0,1]               …… [0,len - 2]
                     left     [len - 1,0]         [len - 2,0]         …… [1,0]
                     bottom   [len - 1,len - 1]   [len - 1,len - 2]   …… [len - 1,1]
                     right    [0,len - 1]         [1,len - 1]         …… [len - 2,len - 1]
                 */
                // 减少计算次数
                int n = len - 1 - j;
                int m = len - 1 - i;
                // 先储存top
                int temp = matrix[i][j];
                // top = left
                matrix[i][j] = matrix[n][i];
                // left = bottom
                matrix[n][i] = matrix[m][n];
                // bottom = right
                matrix[m][n] = matrix[j][m];
                // right = top
                matrix[j][m] = temp;
            }
        }
    }

}
