package cn.leetcode.no_2001_2100.no_2096;

import java.util.ArrayList;
import java.util.List;

public class 从二叉树一个节点到另一个节点每一步的方向 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<String> _start = new ArrayList<>();
        backtrack(root, startValue, _start, new StringBuilder());
        List<String> _dest = new ArrayList<>();
        backtrack(root, destValue, _dest, new StringBuilder());
        String start = _start.get(0);
        String dest = _dest.get(0);
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < start.length() && i < dest.length() && start.charAt(i) == dest.charAt(i)) {
            i++;
        }
        for (int j = i; j < start.length(); j++) {
            builder.append("U");
        }
        for (int j = i; j < dest.length(); j++) {
            builder.append(dest.charAt(j));
        }
        return builder.toString();
    }


    private void backtrack(TreeNode root, int target, List<String> result, StringBuilder state) {
        if (root.val == target) {
            result.add(state.toString());
            return;
        }
        if (root.left != null) {
            state.append("L");
            backtrack(root.left, target, result, state);
            state.deleteCharAt(state.length() - 1);
        }
        if(root.right != null) {
            state.append("R");
            backtrack(root.right, target, result, state);
            state.deleteCharAt(state.length() - 1);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
