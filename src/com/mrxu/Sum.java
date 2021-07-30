package com.mrxu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jlxu@telenav.cn
 * @date 2021/7/13 10:27
 */
public class Sum {
    static int[] arrs = new int[]{3, 2, 4};

    public static void main(String[] args) {
        int[] ints = new Sum().sum(arrs, 6);
        for (int anInt : ints) {
            System.out.print(anInt + "\t");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ints = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            int j = binarySearch(nums, i, nums.length, result);
            if (j >= 0) {
                indices[0] = getIndex(ints, 0, nums[i]);
                indices[1] = getIndex(ints, 0, nums[j]);
                if (indices[0] == indices[1]) {
                    indices[1] = getIndex(ints, indices[0] + 1, nums[j]);
                }
                return indices;
            }
        }
        return indices;
    }

    static int binarySearch(int[] arr, int head, int tail, int target) {
        int j = (head + tail) / 2;
        if (head < tail - 1) {
            if (arr[j] == target)
                return j;
            else if (arr[j] > target)
                return binarySearch(arr, head, j, target);
            else
                return binarySearch(arr, j, tail, target);
        } else
            return -1;
    }

    static int getIndex(int[] arr, int head, int target) {
        for (int i = head; i < arr.length; i++) {
            if (target == arr[i])
                return i;
        }
        return -1;
    }

    public int[] sum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
