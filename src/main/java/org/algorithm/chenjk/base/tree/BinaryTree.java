package org.algorithm.chenjk.base.tree;

import org.algorithm.chenjk.base.model.TreeNode;

import java.util.*;

/**
 * @class: BinaryTree 二叉树常规
 * @description:
 * @author: jack
 * @create: 2023-05-10 19:58
 **/
public class BinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                null, new TreeNode(2,
                                new TreeNode(3), null));
        System.out.println(root);
        List<Integer> res = inorderTraversal(root);
        System.out.println(res);
        System.out.println(preorderTraversal(root));
        System.out.println(postorderTraversal(root));
    }


    /**
     * L94: 二叉树中序遍历
     * @param root root
     * @return 节点中序输出
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTree(root, res);
        return res;
    }

    /**
     * 循环方法：
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalWhile(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            // push直到树的底
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            // 这一步会增加 左底+中的val
            res.add(root.val);
            root = root.right;
        }
        return res;
    }



    /**
     * 中序遍历：递归
     * @param node
     * @param res
     */
    private static void inorderTree(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorderTree(node.left, res);
        res.add(node.val);
        inorderTree(node.right, res);
    }

    // ------------------------------------------------------------------------------------------------------------

    /**
     * 前序遍历
     * @param root root
     * @return 节点前序输出
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    // ------------------------------------------------------------------------------------------------------------

    /**
     * 后序遍历
     * @param root root
     * @return 节点后序输出
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }

    public static void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }



}
