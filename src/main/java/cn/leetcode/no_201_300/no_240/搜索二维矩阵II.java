package cn.leetcode.no_201_300.no_240;

public class 搜索二维矩阵II {
    public static void main(String[] args) {

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        return true;
    }

    private static void next(int[][] matrix, int target, int[] position, boolean[][] moved) {
        if (matrix[position[0]][position[1]] < target) {
            if (position[0] + 1 < matrix.length && !moved[position[0] + 1][position[1]]) {
                position[0]++;
            } else if (position[1] + 1 < matrix[0].length && !moved[position[0]][position[1] + 1]) {
                position[1]++;
            }
        } else {
            if (position[0] > 0 && !moved[position[0] - 1][position[1]]) {
                position[0]--;
            } else if (position[1] > 0 && !moved[position[0]][position[1] - 1]) {
                position[1]--;
            }
        }
        moved[position[0]][position[1]] = true;
    }
}
