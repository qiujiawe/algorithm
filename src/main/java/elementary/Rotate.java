package elementary;

public class Rotate {
    /*
        旋转数组
            给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数

        示例 1:

            输入: nums = [1,2,3,4,5,6,7], k = 3
            输出: [5,6,7,1,2,3,4]
            解释:
            向右旋转 1 步: [7,1,2,3,4,5,6]
            向右旋转 2 步: [6,7,1,2,3,4,5]
            向右旋转 3 步: [5,6,7,1,2,3,4]

        示例2:

            输入：nums = [-1,-100,3,99], k = 2
            输出：[3,99,-1,-100]
            解释:
            向右旋转 1 步: [99,-1,-100,3]
            向右旋转 2 步: [3,99,-1,-100]

     */

    /*
        使用额外的数组
            例如: nums = [1,2,3,4,5,6,7]
            1. 复制 nums = [1,2,3,4,5,6,7] temp = [5,6,7]
            2. 移动 nums = [1,2,3,1,2,3,4] temp = [5,6,7]
            3. 粘贴 nums = [5,6,7,1,2,3,4] temp = [5,6,7]

     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        k = k > len ? k % len : k;
        int[] temp = new int[k];
        int j = 0;
        // 复制
        // 例如: nums = [1,2,3,4,5,6,7], k = 3
        //      temp = [5,6,7]
        for (int i = len - k; i < len; i++) {
            temp[j++] = nums[i];
        }
        // 移动
        // 例如: nums = [1,2,3,4,5,6,7], k = 3
        //      temp = [5,6,7]
        //      nums = [1,2,3,1,2,3,4]
        j = len - k - 1;
        for (int i = len - 1; i > k - 1; i--) {
            nums[i] = nums[j--];
        }
        // 粘贴
        // 例如: nums = [1,2,3,4,5,6,7], k = 3
        //      temp = [5,6,7]
        //      nums = [5,6,7,1,2,3,4]
        if (k >= 0) System.arraycopy(temp, 0, nums, 0, k);
    }

    /*
        数组翻转
            例如: nums = [1,2,3,4,5,6,7] k = 3
            1. 颠倒数组
                [7,6,5,4,3,2,1]
            2. 颠倒[0~(k-1)]部分
                [5,6,7,4,3,2,1]
            3. 颠倒[k~(len-1)]部分
                [5,6,7,1,2,3,4]

     */
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        // 1. 颠倒数组
        perversion(nums,0,len - 1);
        // 2. 颠倒[0~(k-1)]部分
        perversion(nums,0,k - 1);
        // 3. 颠倒[k~(len-1)]部分
        perversion(nums,k,len - 1);
    }
    private void perversion(int[] arr,int left,int right){
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }


    public static void main(String[] args) {
    }

}
