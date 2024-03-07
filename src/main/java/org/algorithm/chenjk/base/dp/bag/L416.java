package org.algorithm.chenjk.base.dp.bag;

/**
 * @class: L416 分割等和子集 (01背包)
 * @description: 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * @author: jack
 * @create: 2024-03-07 20:35
 **/
public class L416 {

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        int[] nums2 = {2,4,1,5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition(nums2));
    }

    /**
     * 套用01背包
     * 背包的体积为 sum / 2
     * 背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
     * 背包如果正好装满，说明找到了总和为 sum / 2 的子集。
     * 背包中每一个元素是不可重复放入。
     *
     * 01背包中，dp[j] 表示： 容量为j的背包，所背的物品价值最大可以为dp[j]。
     * 如果使用一维dp数组，物品遍历的for循环放在外层，遍历背包的for循环放在内层，且内层for循环倒序遍历
     * @param nums 数组
     * @return 是否满足
     */
    public static boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        //总和为奇数，不能平分
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < n; i++) {
            // 当前背包j的容量，至少要大于 num[i]: 重量/价值
            for (int j = target; j >= nums[i]; j--) {
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }

            //剪枝一下，每一次完成內層的for-loop，立即檢查是否dp[target] == target，優化時間複雜度（26ms -> 20ms）
            if(dp[target] == target)
                return true;
        }
        return dp[target] == target;
    }
}
