package easy;

public class no704_binarySearch {
    public static void main(String[] args) {
        // 三个测试用例
        int[] nums = {-1,0,3,5,9,12};
        int target1 = 9;
        int result1 = binarySearch(nums,target1);
        System.out.println(result1); // 4
        
        int[] nums2 = {-1,0,3,5,9,12};
        int target2 = 2;
        int result2 = binarySearch(nums2,target2);
        System.out.println(result2); // -1
        
        int[] nums3 = {-1,0,3,5,9,12};
        int target3 = 12;
        int result3 = binarySearch(nums3,target3);
        System.out.println(result3); // -5
    }
    /**
     * 对整数数组进行二分查找。
     * @param nums 需要进行查找的整数数组，该数组必须是有序的。
     * @param target 需要查找的目标值。
     * @return 如果目标值存在于数组中，返回其在数组中的索引；否则返回-1。
     */
    public static int binarySearch(int[] nums, int target){
        // 初始化左边界为0
        int left = 0;
        // 初始化右边界为数组最后一个元素的索引
        int right = nums.length - 1;
        // 当左边界小于等于右边界时继续循环
        while(left <= right) {
            // 计算中间位置的索引
            int mid = (right + left) / 2;
            // 如果目标值大于中间位置的值
            if (target > nums[mid] ) {
                // 将左边界移动到中间位置的右侧
                left = mid + 1;
                // 重新计算中间位置的索引
                mid = (left + right) / 2;
            // 如果目标值小于中间位置的值
            } else if (target < nums[mid]) {
                // 将右边界移动到中间位置的左侧
                right = mid - 1;
                // 重新计算中间位置的索引
                mid = (left + right) / 2;
            // 如果目标值等于中间位置的值
            } else {
                // 返回中间位置的索引
                return mid;
            }
        }
        // 如果未找到目标值，返回-1
        return -1;
    }
}
