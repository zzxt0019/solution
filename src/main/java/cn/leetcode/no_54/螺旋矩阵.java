package cn.leetcode.no_54;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public static void main(String[] args) {

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m0 = 0;
        int m1 = matrix.length;
        int n0 = 0;
        int n1 = matrix[0].length;
        int i = 0;
        int j = 0;
        int flag = 0;
        list.add(matrix[0][0]);
        while (list.size() != matrix.length * matrix[0].length) {
            switch (flag) {
                case 0:
                    if (j + 1 != n1) {
                        j++;
                    } else {
                        m0++;
                        flag++;
                        continue;
                    }
                    break;
                case 1:
                    if (i + 1 != m1) {
                        i++;
                    } else {
                        n1--;
                        flag++;
                        continue;
                    }
                    break;
                case 2:
                    if (j != n0) {
                        j--;
                    } else {
                        m1--;
                        flag++;
                        continue;
                    }
                    break;
                case 3:
                    if (i != m0) {
                        i--;
                    } else {
                        n0++;
                        flag = 0;
                        continue;
                    }
                    break;
            }
            list.add(matrix[i][j]);
        }
        return list;
    }
}
