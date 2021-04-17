import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RemoveDuplicate {
    /*
    删除数组中重复的元素,返回数组删除重复元素后的长度

    例子:

    输入 new int[]{0,0,1,1,2,2,3,4,5,5}
    返回 6

    思路1:
        双指针算法:
            遍历数组，创建两个变量来储存数组前两个值(变量就是指针)
                靠左的指针被成为 慢指针
                靠右的指针被称为 快指针

                 a b
                 ↓ ↓
                {0,0,1,1,2,2,3,4,5,5}

                如上图 a 为慢指针，b 为快指针

            比较两个变量是否相等
                不相等: 两个变量有一起向右移动一位
                相等: a 不移动，b 向右移动一位 (此时会发现b移动的比a快，这就是被称为快慢指针的原因)
                    移动后进行比较如果不相等则 把 j 赋值给 i + 1
                      a b                             a   b
                      ↓ ↓                   ==》      ↓   ↓
                     {0,0,1,1,2,2,3,4,5,5}           {0,0,1,1,2,2,3,4,5,5}

                                                       ↓↓

                                                     {0,1,1,1,2,2,3,4,5,5}
                重复次步骤直到 b 为数组最后一个元素，然后返回 （a的下标 + 1）

    思路2
        利用set集合的无重复特性，将数组的数据存入set集合，set集合会自动删掉数组中的重复元素

     */

    public static void main(String[] args) {
        System.out.println(removeDuplicateTwo(new int[]{0,0,1,1,2,2,3,4,5,5}));
    }
    // 思路1的实现
    public static int removeDuplicate(int[] arr){
        int j = 0;
        for (int i=1; i < arr.length; i++) {
            if (!Objects.equals(arr[j],arr[i])) {
                arr[++j] = arr[i];
            }
        }
        return j + 1;
    }
    // 思路2的实现
    public static int removeDuplicateTwo(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int temp : arr) {
            set.add(temp);
        }
        return set.size();
    }

}
