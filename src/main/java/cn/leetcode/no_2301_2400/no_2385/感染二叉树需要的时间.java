package cn.leetcode.no_2301_2400.no_2385;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 感染二叉树需要的时间 {
    public static void main(String[] args) {

    }

    // 全部感染当前节点下子节点的时间是固定的, 因此往上找
    public static int amountOfTime(TreeNode root, int start) {
        // key:child  value:parent
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        List<TreeNode> startNodeList = new ArrayList<>();
        init(root, parentMap, startNodeList, start);
        TreeNode startNode = startNodeList.get(0);
        TreeNode current = startNode;
        int maxTime = childrenTime(startNode);
        int parentCount = 0;
        // 找到当前节点的父节点, 计算父节点以下全部感染完的时间(只需计算另一边的节点的时间)
        while (parentMap.containsKey(current)) {
            TreeNode currentParent = parentMap.get(current);
            TreeNode another;
            if (currentParent.left == current) {
                another = currentParent.right;
            } else {
                another = currentParent.left;
            }
            maxTime = Math.max(maxTime, parentCount + 2 + childrenTime(another));
            current = currentParent;
            parentCount++;
        }
        return maxTime;
    }

    /**
     * 初始化, 找到开始节点对象, 放置parentMap(根据子节点找到父节点)
     */
    private static void init(TreeNode root, Map<TreeNode, TreeNode> parentMap, List<TreeNode> startNodeList, int start) {
        if (root.val == start) {
            startNodeList.add(root);
        }
        if (root.left != null) {
            parentMap.put(root.left, root);
            init(root.left, parentMap, startNodeList, start);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            init(root.right, parentMap, startNodeList, start);
        }
    }

    /**
     * 当前节点已感染的情况下, 感染其所有子节点要多长时间
     */
    private static int childrenTime(TreeNode node) {
        if (node == null) {
            return -1;  // 当前节点不存在, 所以就没有感染到null的时间, 应把这次时间减去(所以是-1)
        }
        return 1 + Math.max(childrenTime(node.left), childrenTime(node.right));
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
