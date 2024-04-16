package cn.leetcode.no_1_100.no_51;

import java.util.ArrayList;
import java.util.List;

public class N皇后 {
    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(8);
        int count = 0;
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            count++;
            System.out.println("============");
        }
        System.out.println(count);
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> resultList = new ArrayList<>();
        backtrack(new ArrayList<>(), n, resultList);
        return resultList;
    }

    private static void backtrack(List<Integer> state, int n, List<List<String>> res) {
        if (state.size() == n) {
            List<String> result = new ArrayList<>();
            for (int index : state) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (index == j) {
                        builder.append("Q");
                    } else {
                        builder.append(".");
                    }
                }
                result.add(builder.toString());
            }
            res.add(result);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(state, i)) {
                state.add(i);
                backtrack(state, n, res);
                state.remove(state.size() - 1);
            }
        }
    }

    private static boolean check(List<Integer> state, int number) {
        for (int i = 0; i < state.size(); i++) {
            if (state.get(i) == number) {
                return false;
            }
            if (state.get(i) - number == state.size() - i) {
                return false;
            }
            if (state.get(i) - number == i - state.size()) {
                return false;
            }
        }
        return true;
    }
}
