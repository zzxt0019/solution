package cn.leetcode.no_901_1000.no_994;

import java.util.ArrayList;
import java.util.List;

public class 腐烂的橘子 {
    public static void main(String[] args) {
//        int[][] matrix = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int[][] matrix = ArrayUtil.toIntArray2("[[2,1,1],[0,1,1],[1,0,1]]");
        int[][] matrix = {{0, 1}};
        System.out.println(orangesRotting(matrix));
    }

    public static int orangesRotting(int[][] grid) {
        List<int[]> next = new ArrayList<>();
        int goodCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    next.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    goodCount++;
                }
            }
        }
        if (goodCount == 0) {
            return 0;
        }
        int time = 0;
        while (!(next = doing(grid, next)).isEmpty()) {
            goodCount -= next.size();
            time++;
        }
        if (goodCount == 0) {
            return time;
        } else {
            return -1;
        }
    }

    public static List<int[]> doing(int[][] grid, List<int[]> current) {
        List<int[]> next = new ArrayList<>();
        for (int[] position : current) {
            // left
            if (position[0] > 0) {
                if (grid[position[0] - 1][position[1]] == 1) {
                    grid[position[0] - 1][position[1]] = 2;
                    next.add(new int[]{position[0] - 1, position[1]});
                }
            }
            // right
            if (position[0] < grid.length - 1) {
                if (grid[position[0] + 1][position[1]] == 1) {
                    grid[position[0] + 1][position[1]] = 2;
                    next.add(new int[]{position[0] + 1, position[1]});
                }
            }
            // up
            if (position[1] > 0) {
                if (grid[position[0]][position[1] - 1] == 1) {
                    grid[position[0]][position[1] - 1] = 2;
                    next.add(new int[]{position[0], position[1] - 1});
                }
            }
            // down
            if (position[1] < grid[0].length - 1) {
                if (grid[position[0]][position[1] + 1] == 1) {
                    grid[position[0]][position[1] + 1] = 2;
                    next.add(new int[]{position[0], position[1] + 1});
                }
            }
        }
        return next;
    }
}
