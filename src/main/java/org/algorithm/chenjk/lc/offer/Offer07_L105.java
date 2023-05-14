package org.algorithm.chenjk.lc.offer;

import org.algorithm.chenjk.base.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @class: Offer07_L105
 * @description: 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 * Input: preorder = [3,9,20,15,7],
 *         inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * 前序遍历： [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
 * 中序遍历： [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
 *
 * @author: jack
 * @create: 2023-05-07 21:23
 **/
public class Offer07_L105 {

    public static void main(String[] args) {
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9,3,15,20,7};
        TreeNode node = buildTree(preOrder, inOrder);
        System.out.println(node);
    }

    /**
     * 递归分治：时间空间O(n)
     * 递推参数： 根节点在 "前序遍历" 的索引 root 、子树在"中序遍历"的左边界 left 、子树在中序遍历的右边界 right ；
     *
     * 终止条件： 当 left > right ，代表已经越过叶节点，此时返回null;
     *
     * 递推工作：
     * 1. 建立根节点 node ： 节点值为 preorder[root] ；
     * 2. 划分左右子树： 查找根节点在中序遍历 inorder 中的索引 i ；
     * 3. 构建树
     * @param preorder 前序
     * @param inorder 中序
     * @return 树
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> dict = new HashMap<>();
        // 用来寻找下标, 划分树
        for (int i = 0; i < inorder.length; i++) {
            dict.put(inorder[i], i);
        }
        // 前序第一个节点为根节点
        int n = preorder.length;
        return myBuildTree(preorder, inorder, dict, 0, n-1, 0, n-1);
    }

    public static TreeNode myBuildTree(int[] preorder, int[] inorder, Map<Integer, Integer> dict,
                                int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点，在中序遍历中定位根节点在中序的位置index
        int preRoot = preLeft;
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preRoot]);
        int inRoot = dict.get(preorder[preRoot]);

        // 前序遍历： [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
        // 中序遍历： [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
        int leftSubtreeSize = inRoot - inLeft; // 得到左子树中的节点数目
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, dict,
                preRoot + 1, preRoot + leftSubtreeSize, inLeft, inRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, dict,
                // 右节点的前序起始preLeft = 根root+左树长度+1, 前序终止就是最后，不变;
                preRoot + leftSubtreeSize + 1, preRight, inRoot + 1, inRight);
        return root;
    }

}
