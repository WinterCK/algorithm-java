package org.algorithm.chenjk.base.model;

/**
 * @class: TreeNode
 * @description: LC 树节点常用数据结构
 * @author: jack
 * @create: 2023-05-07 21:24
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return toString(this, 0);
    }

    private String toString(TreeNode node, int depth) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("\n");
        if (node.left != null) {
            sb.append(indent(depth + 1));
            sb.append("└─L─");
            sb.append(toString(node.left, depth + 1));
        }
        if (node.right != null) {
            sb.append(indent(depth + 1));
            sb.append("└─R─");
            sb.append(toString(node.right, depth + 1));
        }
        return sb.toString();
    }

    private String indent(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }
}
