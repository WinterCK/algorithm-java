package org.algorithm.chenjk.base.tree;

import org.algorithm.chenjk.base.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @class: BFS 广度优先搜索 Breadth-First-Search
 * @description: BFS与DFS会先一路走到黑不同，BFS会从根节点开始搜索，
 * 在每一个路口面临分叉的时候，先把每个岔路记录下来，然后再去一个一个的往前走一步。
 *
 * 例题：LC 700 二叉搜索树中的搜索 : 返回以该节点为根的子树
 * 注：二叉搜索树满足如下性质：
 *   左子树所有节点的元素值均小于根的元素值；
 *   右子树所有节点的元素值均大于根的元素值。
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 * @author: jack
 * @create: 2023-06-11 14:49
 **/
public class BFS {
    private static TreeNode node = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7));

        System.out.println(searchBSTByDFS(root, 2));
        System.out.println(searchBSTByBFS(root, 2));
    }

    /**
     * 有二叉搜索树的特性
     * @param root r
     * @param val v
     * @return r
     */
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) {
                return root;
            }
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }

    /**
     * 
     * @param root
     * @param val
     * @return
     */
    private static TreeNode searchBSTByBFS(TreeNode root, int val) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == val) {
                return node;
            }
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }
        }
        return null;
    }


    private static TreeNode searchBSTByDFS(TreeNode root, int val) {
        node = null;
        dfs(root, val);
        return node;
    }

    private static void dfs(TreeNode root, int val) {
        if (root == null) {
            return ;
        }
        if (root.val == val) {
            node = root;
            return;
        }
        if (root.val < val) {
            dfs(root.right, val);
        } else {
            dfs(root.left, val);
        }

    }



}
