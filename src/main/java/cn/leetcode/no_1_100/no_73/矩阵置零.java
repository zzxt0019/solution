package cn.leetcode.no_1_100.no_73;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 矩阵置零 {
    public static void main(String[] args) {

    }

    public static void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (Integer row : rowSet) {
            Arrays.fill(matrix[row], 0);
        }
        for (Integer col : colSet) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
