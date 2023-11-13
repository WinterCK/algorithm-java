package org.algorithm.chenjk.lc.a_usual;

/**
 * @class: LC662 二叉树最大宽度
 * @description: 给你一棵二叉树的根节点 root ，返回树的 最大宽度。 树的 最大宽度 是所有层中最大的 宽度。
 * 输入：root = [1,3,2,5,3,null,9]
 * 输出：4
 * 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9)
 *
 * 输入：root = [1,3,2,5]
 * 输出：2
 * 解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2)
 *
 * 关键点：因为两端点间的 null 节点也需要计入宽度，因此可以对节点进行编号。一个编号为
 * index 的左子节点的编号记为 2×index，右子节点的编号记为2×index+1，计算每层宽度时，
 * 用每层节点的最大编号减去最小编号再加 1 即为宽度
 *
 * @author: jack
 * @create: 2023-06-11 14:46
 **/
public class LC662 {
}