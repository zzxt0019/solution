package cn.leetcode.no_201_300.no_216;

import java.util.ArrayList;
import java.util.List;

public class 组合总和III {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), k, 0, n, result);
        return result;
    }

    private static void backtrack(List<Integer> state, int targetSize, int sum, int targetSum, List<List<Integer>> result) {
        if (sum == targetSum && state.size() == targetSize) {
            result.add(new ArrayList<>(state));
            return;
        }
        int start = state.isEmpty() ? 1 : state.get(state.size() - 1) + 1;
        for (int number = start; number <= 9; number++) {
            if (targetSum >= sum + number) {
                state.add(number);
                backtrack(state, targetSize, sum + number, targetSum, result);
                state.remove(state.size() - 1);
            }
        }
    }
}
