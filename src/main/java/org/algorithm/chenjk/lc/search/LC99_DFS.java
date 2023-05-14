package org.algorithm.chenjk.lc.search;

import org.algorithm.chenjk.base.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @class: LC99_DFS
 * @description: 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 * @author: jack
 * @create: 2023-05-10 21:52
 **/
public class LC99_DFS {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        System.out.println(root);
        recoverTree(root);
        System.out.println(root);
    }


    /**
     * 中序遍历解法：a=[1,2,3,4,5,6,7]  原序列变成了a=[1,6,3,4,5,2,7]
     * 我们交换两个相邻的数字，例 2 和 3 此时交换后的序列只有一个位置不满足
     *
     * @param root root
     */
    public static void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<Integer>();
        inorder(root, nums);
        // 最多找2个该换位的点
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    public static void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    public static int[] findTwoSwapped(List<Integer> nums) {
        int index1 = -1, index2 = -1;
        for (int i = 0; i < nums.size() - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                index2 = i + 1;
                if (index1 == -1) {
                    index1 = i;
                } else {
                    break;
                }
            }
        }
        int x = nums.get(index1), y = nums.get(index2);
        return new int[]{x, y};
    }

    public static void recover(TreeNode root, int count, int x, int y) {
        // 只交换值，不交换链表
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }


}
