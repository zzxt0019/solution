package cn.leetcode.no_1_100.no_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和 {
    public static void main(String[] args) {
        int[] candidates = {8, 7, 4, 3};
        int target = 11;
        System.out.println(combinationSum(candidates, target));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), 0, result);
        return result;
    }

    private static void backtrack(int[] candidates, int index, int target, List<Integer> state, int sum, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(state));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (state.isEmpty() || candidate >= state.get(state.size() - 1)) {
                if (sum + candidate <= target) {
                    state.add(candidate);
                    backtrack(candidates, i, target, state, sum + candidate, result);
                    state.remove(state.size() - 1);
                }
            }
        }
    }

    private static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }
}
