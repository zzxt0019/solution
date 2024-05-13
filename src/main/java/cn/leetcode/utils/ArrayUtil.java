package cn.leetcode.utils;

import com.google.gson.Gson;

import java.util.List;

public class ArrayUtil {
    private static final Gson gson = new Gson();

    public static int[][] toIntArray2(String arrayStr) {
        return gson.fromJson(arrayStr, int[][].class);
    }

    public static long[][] toLongArray2(String arrayStr) {
        return gson.fromJson(arrayStr, long[][].class);
    }

    public static String[][] toStringArray2(String arrayStr) {
        return gson.fromJson(arrayStr, String[][].class);
    }

    public static String toString(List<int[]> arrList) {
        return gson.toJson(arrList);
    }

}
