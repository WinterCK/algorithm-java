package org.algorithm.chenjk.base.backtrack;

import java.util.*;

/**
 * @class: L51 N 皇后
 * @description: n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * @author: jack
 * @create: 2024-03-31 19:09
 **/
public class L51 {

    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(1);
        for (List<String> q : res) {
            System.out.println(q);
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        LinkedList<String> bord = new LinkedList<>();
        backtracking(result, bord, n, 0);
        return result;
    }

    /**
     * void backtracking(参数) {
     *     if (终止条件) {
     *         存放结果;
     *         return;
     *     }
     *     for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
     *         处理节点;
     *         backtracking(路径，选择列表); // 递归
     *         回溯，撤销处理结果
     *     }
     * }
     */
    private static void backtracking(List<List<String>> result, LinkedList<String> board, int n, int row) {
        if (n == row) {
            List<String> r = new ArrayList<>(board);
            result.add(r);
            return;
        }
        for (int i = 0; i < n; i++) {
            // 判断i为Q的情况下，和当前board是否合法
            if (isValid(board, row, i)) {
                // 根据 i 拼接Q的字符串
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                String cur = sb.toString();
                board.add(cur);
                backtracking(result, board, n, row + 1);
                board.removeLast();
            }


        }

    }

    private static boolean isValid(List<String> bord, int row, int i) {
        if (bord.isEmpty()) {
            return true;
        }
        // j 从每一行开始取board
        for (int j = 0; j < bord.size(); j++) {
            String cur = bord.get(j);
            // Q...
            // Q...
            int p = cur.indexOf('Q');
            // 垂直一致
            if (p == i) {
                return false;
            }
            // Q...0
            // .Q..1
            // ..Q.2
            // row - j  判断是否和 row对应的i 与 j取出的cur对应的p 差值是否一致
            // 一致说明为斜角
            if (Math.abs(i - p) == Math.abs(row - j)) {
                return false;
            }

        }
        return true;
    }



}
