package cn.leetcode.no_2601_2700.no_2639;

public class 查询网格图中每一列的宽度 {
    public static void main(String[] args) {

    }

    public static int[] findColumnWidth(int[][] grid) {
        int[] result = new int[grid[0].length];
        for (int j = 0; j < result.length; j++) {
            for (int i = 0; i < grid.length; i++) {
                result[j] = Math.max(String.valueOf(grid[i][j]).length(), result[j]);
            }
        }
        return result;
    }
}
