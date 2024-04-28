package cn.leetcode.no_1301_1400.no_1329;

import java.util.Arrays;

public class 将矩阵按对角线排序 {
    public static void main(String[] args) {

    }

    public static int[][] diagonalSort(int[][] mat) {
        int[][] positions = new int[mat.length + mat[0].length - 1][2];
        int positionsIndex = 0;
        for (int i = mat.length - 1; i >= 0; i--) {
            positions[positionsIndex++] = new int[]{i,0};
        }
        for (int i = 1; i < mat[0].length; i++) {
            positions[positionsIndex++] = new int[]{0, i};
        }
        int[][] matrix = new int[mat.length][mat[0].length];
        for (int[] position : positions) {
            int[] line = line(mat, position);
            Arrays.sort(line);
            writeLine(matrix, position, line);
        }
        return matrix;
    }

    private static int[] line(int[][] mat, int[] position) {
        int[] line = new int[Math.min(mat.length - position[0], mat[0].length - position[1])];
        for (int i = 0; i < line.length; i++) {
            line[i] = mat[position[0]][position[1]];
            position[0]++;
            position[1]++;
        }
        return line;
    }

    private static void writeLine(int[][] matrix, int[] position, int[] line) {
        position[0] -= line.length;
        position[1] -= line.length;
        for (int i = 0; i < line.length; i++) {
            matrix[position[0]][position[1]] = line[i];
            position[0]++;
            position[1]++;
        }
    }
}
