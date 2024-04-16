package cn.leetcode.no_401_500.no_438;

import java.util.ArrayList;
import java.util.List;

public class 找到字符串中所有字母异位词 {
    public static void main(String[] args) {

    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] pKey = toKey(p, 0, p.length());
        List<Integer> list = new ArrayList<>();
        int[] key = toKey(s, 0, p.length());
        if (equals(key, pKey)) {
            list.add(0);
        }
        for (int i = 1; i <= s.length() - p.length(); i++) {
            key[s.charAt(i - 1) - 'a']--;
            key[s.charAt(i + p.length() - 1) - 'a']++;
            if (equals(key, pKey)) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean equals(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] toKey(String word, int start, int end) {
        int[] arr = new int[26];
        for (int i = start; i < end; i++) {
            arr[word.charAt(i) - 'a']++;
        }
        return arr;
    }
}
