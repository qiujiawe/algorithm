import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
        两数之和

            给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标
            你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现
            你可以按任意顺序返回答案

            示例 1：

                输入：nums = [2,7,11,15], target = 9
                输出：[0,1]
                解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]

            示例 2：

                输入：nums = [3,2,4], target = 6
                输出：[1,2]

            示例 3：

                输入：nums = [3,3], target = 6
                输出：[0,1]
     */

    /*
        穷举法
            1. 遍历数组
                1. 用 target - 元素(1) 获取 newTarget
                2. 遍历数组
                    1. 看有没有 元素(2) 等于 newTarget
                        如果有则返回 元素(1) 和 元素(2) 的下标
     */
    public static int[] twoSumOne(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int newTarget = target - nums[i];
            for (int j = i + 1; j < len; j++) {
                if (newTarget == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException();
    }


    /*
        查找表法
            1. 遍历数组
                1. 用 target - 元素(1) 获取 newTarget
                2. 然后用 newTarget 作为key去哈希表里查找有没有对应的 元素(2)
                    如果有则返回 元素(1) 的下标 和 元素(2) 的value
                    如果没有则将 元素(1) 作为key,元素(1) 的下标 作为value储存到哈希表中

        相较与穷举法: 查找表法用的时间更少(只需要遍历一次数组),用的内存更多(创建了一个哈希表)

     */
    public static int[] twoSumTwo(int[] nums, int target) {
        int len = nums.length;
        // 初始化哈希表
        Map<Integer, Integer> map = new HashMap<>(len - 1);
        // i == 0 时哈希表中肯定不存在 newTarget 所以直接加
        map.put(nums[0], 0);
        // 遍历数组
        for (int i = 1; i < len; i++) {
            // 得到新目标值 newTarget
            int newTarget = target - nums[i];
            // 判断哈希表中是否存在 newTarget
            if (map.containsKey(newTarget)) {
                // 返回结果
                return new int[]{map.get(newTarget), i};
            } else {
                // 记录到哈希表
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException();
    }

}
