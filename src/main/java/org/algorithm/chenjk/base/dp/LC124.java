package org.algorithm.chenjk.base.dp;

import org.algorithm.chenjk.base.model.TreeNode;

/**
 * @class: LC124 二叉树中的最大路径和
 * @description: 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * @author: jack
 * @create: 2023-05-13 21:49
 **/
public class LC124 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxPathSum(root));
    }

    static int max = Integer.MIN_VALUE;
    /**
     * 动态规划: f(parent) = Math.max( f(left), f(right) ) + parent.val
     * 递归去算，叶子节点 f(node) = node.val
     * max = Math.max(max, f(node))
     * @param root 根节点
     * @return
     */
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getNodeVal(root);
        return max;
    }

    public static int getNodeVal(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 如果为负数就肯定不是最大路径的部分
        int left = Math.max(getNodeVal(node.left), 0);
        int right = Math.max(getNodeVal(node.right), 0);

        // 自己节点的最大贡献值一定要算自己，因此负数不能取0
        int maxVal = node.val + left + right;
        max = Math.max(max, maxVal);

        return Math.max(left, right) + node.val;
    }

}
