package org.algorithm.chenjk.lc.search;

import org.algorithm.chenjk.base.model.TreeNode;

/**
 * @class: LC98_DFS
 * @description: 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *   有效 二叉搜索树定义如下：
 * - 节点的左子树只包含 小于 当前节点的数。
 * - 节点的右子树只包含 大于 当前节点的数。
 * - 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 二叉搜索树「中序遍历」得到的值构成的序列一定是升序的
 *
 * 输入：root = [2,1,3]      2
 * 输出：true              1   3
 *
 * @author: jack
 * @create: 2023-05-10 20:17
 **/
public class LC98_DFS {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return validBst(root);
    }

    static int pre = Integer.MIN_VALUE;
    private static boolean validBst(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!validBst(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        if (!validBst(root.right)) {
            return false;
        }
        return true;
    }

}
