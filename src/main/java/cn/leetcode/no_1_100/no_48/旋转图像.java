package cn.leetcode.no_1_100.no_48;

import cn.leetcode.utils.ArrayUtil;

import java.util.Arrays;

public class 旋转图像 {
    public static void main(String[] args) {
        int[][] arr = ArrayUtil.toIntArray2("[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]");
        rotate(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            rotate(matrix, i);
        }
    }

    private static void rotate(int[][] matrix, int index) {
        int[] arr = new int[4];
        for (int i = 0; i < matrix.length - index * 2 - 1; i++) {
            arr[0] = matrix[index][index + i];
            arr[1] = matrix[index + i][matrix.length - index - 1];
            arr[2] = matrix[matrix.length - index - 1][matrix.length - index - i - 1];
            arr[3] = matrix[matrix.length - index - i - 1][index];
            matrix[index][index + i] = arr[3];
            matrix[index + i][matrix.length - index - 1] = arr[0];
            matrix[matrix.length - index - 1][matrix.length - index - i - 1] = arr[1];
            matrix[matrix.length - index - i - 1][index] = arr[2];
        }
    }
}
