package cn.leetcode.no_1_100.no_3;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(lengthOfLongestSubstring("cdd"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int j = 0;
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {  // i和前面某个重复了
                maxLength = Math.max(maxLength, i - j);
                while (true) {
                    if (s.charAt(i) == s.charAt(j)) {
                        set.add(s.charAt(j));
                        break;
                    }
                    set.add(s.charAt(j));
                    j++;
                }
                j++;
                maxLength = Math.max(maxLength, i - j);
            }
        }
        maxLength = Math.max(maxLength, s.length() - j);
        return maxLength;
    }
}
