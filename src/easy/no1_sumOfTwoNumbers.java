package easy;

import java.util.HashMap;

public class no1_sumOfTwoNumbers {
    public static void main(String[] args) {
        // 示例
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = Solution(nums, target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }
    public static int[] Solution(int[] nums, int target){
        // 使用 HashMap 储存数据
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            // 储存数值以及下标，数值为 key 作为索引，下标为 value
            // 如果 if 语句执行了,那么就直接返回了,所以在这之前都是要存进去的,故而不需要else
            map.put(nums[i], i);
        }
        // 返回空数组
        return new int[]{};
    }
}