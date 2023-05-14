package org.algorithm.chenjk.lc.search;

import org.algorithm.chenjk.base.model.TreeNode;

/**
 * LC124_DFS_DP 二叉树的最大路径和
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42 解释：最优路径是 15 -> 20 -> 7 ，
 * 路径和为 15 + 20 + 7 = 42
 * @author jack
 * @description
 * @date 2023/5/10 15:39
 */
public class LC124_DFS_DP {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        int max = maxPathSum(root);
        System.out.println(max);
    }

    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        calcNodeNum(root);
        return max;

    }

    private static int calcNodeNum(TreeNode node) {
        if (node == null) {
            return 0 ;
        }
        // 负数则置为0
        int leftVal = Math.max(calcNodeNum(node.left), 0);
        int rightVal = Math.max(calcNodeNum(node.right), 0);
        int nodeNum = node.val + leftVal + rightVal;
        max = Math.max(max, nodeNum);
        return node.val + Math.max(leftVal, rightVal);
    }


}
