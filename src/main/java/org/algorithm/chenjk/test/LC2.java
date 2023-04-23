package org.algorithm.chenjk.test;

/**
 * @project: algorithm-test
 * @description:
 * @author: chenjk
 * @create: 2022-03-06 00:03
 **/
public class LC2 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,5,6};
        int target = 7;
        int target2 = 4;
        int target3 = 3;
        System.out.println(searchInsert2(nums, target));
        System.out.println(searchInsert2(nums, target2));
        System.out.println(searchInsert2(nums, target3));
    }

    /**
     * 二分法：O(logN)
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                res = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return res;
    }




    /**
     * 时间复杂度O(n),
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i <= nums.length -1; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > target) {
                return i;
            }
            if (nums[i] < target && (i + 1 ) < nums.length &&  nums[i + 1] > target) {
                return i + 1;
            }
        }
        return nums.length;
    }
}
