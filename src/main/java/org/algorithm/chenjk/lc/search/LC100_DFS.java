package org.algorithm.chenjk.lc.search;

import org.algorithm.chenjk.base.model.TreeNode;

/**
 * @class: LC100_DFS
 * @description: 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的
 *
 * @author: jack
 * @create: 2023-05-10 22:14
 **/
public class LC100_DFS {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        TreeNode root2 = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        System.out.println(isSameTree(root1, root2));
    }

    /**
     * DFS进行判断：判断当前节点是否相同
     * 递归判断各自的左右子树是否相同
     * @param p
     * @param q
     * @return 树是否相同
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
