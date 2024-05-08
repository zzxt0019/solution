package cn.leetcode.no_101_200.no_102;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class 二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> parentList = new ArrayList<>();
        parentList.add(root);
        while (!parentList.isEmpty()) {
            List<Integer> innerList = new ArrayList<>();
            List<TreeNode> childList = new ArrayList<>();
            for (TreeNode treeNode : parentList) {
                innerList.add(treeNode.val);
                if (treeNode.left != null) {
                    childList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    childList.add(treeNode.right);
                }
            }
            res.add(innerList);
            parentList = childList;
        }
        return res;
    }

    private static class TreeNode {
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
