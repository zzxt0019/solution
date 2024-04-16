package cn.leetcode.no_1_100.no_56;

import cn.leetcode.utils.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class 合并区间 {
    public static void main(String[] args) {
        int[][] input = ArrayUtil.toIntArray2("[[1,3],[2,6],[8,10],[15,18]]");
        System.out.println(Arrays.deepToString(merge(input)));
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();
        for (int[] range : intervals) {
            List<int[]> containsList = contains(resultList, range);
            int[] merged = new int[2];
            merged[0] = range[0];
            merged[1] = range[1];
            for (int[] containArr : containsList) {
                merged = merge(containArr, merged);
            }
            resultList.add(merged);
            Iterator<int[]> resultIterator = resultList.iterator();
            while (resultIterator.hasNext()) {
                int[] resultArr = resultIterator.next();
                Iterator<int[]> containsIterator = containsList.iterator();
                while (containsIterator.hasNext()) {
                    int[] containArr = containsIterator.next();
                    if (equals(resultArr, containArr)) {
                        resultIterator.remove();
                        containsIterator.remove();
                        break;
                    }
                }
            }
        }
        int[][] resultArray = new int[resultList.size()][];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }

    private static boolean equals(int[] range1, int[] range2) {
        return range1[0] == range2[0] && range1[1] == range2[1];
    }

    private static int[] merge(int[] range1, int[] range2) {
        return new int[]{Math.min(range1[0], range2[0]), Math.max(range1[1], range2[1])};
    }

    private static List<int[]> contains(List<int[]> list, int[] range) {
        List<int[]> containsList = new ArrayList<>();
        for (int[] arr : list) {
            if (arr[0] <= range[0] && range[0] <= arr[1]) {
                containsList.add(arr);
            } else if (arr[0] <= range[1] && range[1] <= arr[1]) {
                containsList.add(arr);
            } else if (range[0] <= arr[0] && arr[0] <= range[1]) {
                containsList.add(arr);
            } else if (range[0] <= arr[1] && arr[1] <= range[1]) {
                containsList.add(arr);
            }
        }
        return containsList;
    }
}
