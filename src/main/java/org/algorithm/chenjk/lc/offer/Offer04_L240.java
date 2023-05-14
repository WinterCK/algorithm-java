package org.algorithm.chenjk.lc.offer;

/**
 * @class: Offer04_L240
 * @description: 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减的顺序排序，每一列都按照从上到下非递减的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例：matrix=
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false
 *
 * @author: jack
 * @create: 2023-05-07 20:38
 **/
public class Offer04_L240 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1,4,7,11,15},
                new int[]{2,5,8,12,19},
                new int[]{3,6,9,16,22},
        };
        System.out.println(findNumberIn2DArray(matrix, 4));
        System.out.println(findNumberIn2DArray(matrix, 222));
        System.out.println(findNumberIn2DArray2(matrix, 4));
        System.out.println(findNumberIn2DArray2(matrix, 5555));
    }

    /**
     * Z 字形查找：设置左下角为标准值，类似二叉搜索树
     * @param matrix 矩阵
     * @param target 目标值
     * @return 是否存在
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return false;
        }
        // 取左下角的值为标准值，y轴(n)--的都比其小，x轴(m)++的都比其大
        int std = matrix[n-1][0];
        if (std == target) {
            return true;
        }
        int i = 0;
        while (n >= 1 && i <= m - 1) {
            // 大于target则需减小
            if (matrix[n-1][i] > target) {
                n--;
                continue;
            }
            // 小于target则需增大
            if (matrix[n-1][i] < target) {
                i++;
                continue;
            }
            if (matrix[n-1][i] == target) {
                return true;
            }
        }
        return false;

    }

    /**
     * 二分法：O(nlogm)：针对每层做二分搜索
     * @param matrix 矩阵
     * @param target 目标值
     * @return 是否存在
     */
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int n = matrix.length - 1;
        if (n == 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            int index = search(matrix[i], target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            // 防止int溢出 (y-x)/2+x = (x+y)/2
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }



}
