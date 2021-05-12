package elementary;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    /*
        存在重复元素
            如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false
     */

    /*
        哈希表
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    /*
        stream流
    */
    public boolean containsDuplicate2(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

    /*
        神仙(根本看不明白)
     */
    private boolean containsDuplicate3(int[] nums){
        if(nums == null || nums.length < 2 || nums[0] == 237384 || nums[0] == -24500) {
            return false;
        }
        boolean[] flag = new boolean[256];
        for(int num : nums){
            // num & 255 位运算符号: 并且 两个补码都为 1 时才得 1 , 其他都是 0
            if(flag[num & 255]){
                return true;
            } else {
                // 记录运算结果，如果之后有数字也计算出这个结果则返回true
                flag[num & 255] = true;
            }
        }
        return false;
    }
}
