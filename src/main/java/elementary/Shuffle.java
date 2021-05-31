package elementary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shuffle {
    /*
        打乱数组
            给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组
            实现 Solution class:
                Solution(int[] nums) 使用整数数组 nums 初始化对象
                int[] reset() 重设数组到它的初始状态并返回
                int[] shuffle() 返回数组随机打乱后的结果

        示例：
            输入
            ["Solution", "shuffle", "reset", "shuffle"]
            [[[1, 2, 3]], [], [], []]
            输出
            [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

            解释
            Solution solution = new Solution([1, 2, 3]);
            solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
            solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
            solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
     */

    private int[] array;
    private int[] original;
    private final Random rand = new Random();

    // 初始化
    public Shuffle(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    // 返回打乱前的数组
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    /*
        返回打乱后的数组
            Fisher-Yates 洗牌算法
                定义一个指针 a , a 指向数组中第一个元素,然后逐步向右边移动
                每次移动用random生成一个下标sub,下标的范围(a ~ len)
                交换sub与a指向的元素
     */
    public int[] shuffle1() {
        for (int i = 0; i < array.length; i++) {
            int sub = i + rand.nextInt(array.length - i);
            int temp = array[i];
            array[i] = array[sub];
            array[sub] = temp;
        }
        return array;
    }

    /*
        返回打乱后的数组
        暴力算法
            将数组中的元素全部放到list集合中,用Random随机生成下标,然后逐个取出放入要返回的数组中
     */
    public int[] shuffle() {
        List<Integer> aux = getArrayCopy();
        for (int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }
        return array;
    }

    private List<Integer> getArrayCopy() {
        int len = array.length;
        List<Integer> list = new ArrayList<>(len);
        for (int j : array) {
            list.add(j);
        }
        return list;
    }
}
