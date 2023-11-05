package org.algorithm.chenjk;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class LeetcodeApplicationTests {

    @Test
    void contextLoads() {
    }


    public static int distinctAverages(int[] nums) {
        Set<Double> results = new HashSet<>();
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        while (arr.size() > 0) {
            int[] minMax = getMinMaxInNums(arr);
            double avg = (double)(minMax[0] + minMax[1]) / 2;
            results.add(avg);
            arr.remove(new Integer(minMax[0]));
            arr.remove(new Integer(minMax[1]));
        }
        return results.size();
    }


    private static int[] getMinMaxInNums(List<Integer> arr) {
        if (arr.size() == 2) {
            return new int[] {arr.get(0), arr.get(1)};
        }
        int minIndex = arr.get(0);
        int maxIndex = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > maxIndex) {
                maxIndex = arr.get(i);
            }
            if (arr.get(i) < minIndex) {
                minIndex = arr.get(i);
            }
        }
        return new int[] {minIndex, maxIndex};
    }

    public static void main(String[] args) {

        int[] arr = new int[] {9,5,7,8,7,9,8,2,0,7};
        System.out.println(distinctAverages(arr));

        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        qs(nums, low, high);
    }

    private static void qs(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int p = nums[low];
        while (i < j) {
            while (nums[j] >= p && i < j) {
                j--;
            }
            while (nums[i] <= p && i < j) {
                i++;
            }
            // 都找到了，才交换
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }

        }
        nums[low] = nums[i];
        nums[i] = p;
        qs(nums, low, i - 1);
        qs(nums, i + 1, high);


    }

}
