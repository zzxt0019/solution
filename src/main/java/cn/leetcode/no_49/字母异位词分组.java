package cn.leetcode.no_49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 字母异位词分组 {
    public static void main(String[] args) {

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // key:str value:[...]
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i)-'a']++;
            }
            String key = toString(arr);
            if (!resultMap.containsKey(key)) {
                resultMap.put(key, new ArrayList<>());
            }
            resultMap.get(key).add(str);
        }
        return new ArrayList<>(resultMap.values());
    }

    private static String toString(int[] nums) {
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num).append("_");
        }
        return builder.substring(0, builder.length() - 1);
    }
}
