package cn.leetcode.no_1_100.no_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));

    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                if (i != map.get(target - nums[i])) {
                    return new int[]{i, map.get(target - nums[i])};
                }
            }
        }
        return new int[]{-1, -1};
    }
    // 通用方法
//    public static int[] twoSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        int left = 0;
//        int right = nums.length - 1;
//        List<int[]> resultList = new ArrayList<>();
//        while (left < right) {
//            int sum = nums[left] + nums[right];
//            int leftValue = nums[left];
//            int rightValue = nums[right];
//            if (sum < target) {
//                while (left < right && nums[left] == leftValue) {
//                    left++;
//                }
//            } else if (sum > target) {
//                while (left < right && nums[right] == rightValue) {
//                    right--;
//                }
//            } else {
//                resultList.add(new int[]{leftValue, rightValue});
//                while (left < right && nums[left] == leftValue) {
//                    left++;
//                }
//                while (left < right && nums[right] == rightValue) {
//                    right--;
//                }
//            }
//        }
//        return resultList.get(0);
//    }
}
