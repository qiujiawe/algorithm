package elementary;

public class MoveZeroes {
    /*
        移动零
            给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

        示例:

            输入: [0,1,0,3,12]
            输出: [1,3,12,0,0]
     */

    /*
        双指针
            输入: [0,1,0,3,12]
            1. [0,1,0,3,12] j = 0
            2. [1,0,0,3,12] j = 1
            3. [1,0,0,3,12] j = 1
            4. [1,3,0,0,12] j = 2
            5. [1,3,12,0,0] j = 2
     */
    public void moveZeroes(int[] nums) {
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (j == -1) {
                    j = i;
                }
            } else {
                if (j != -1) {
                    nums[j++] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }


}
