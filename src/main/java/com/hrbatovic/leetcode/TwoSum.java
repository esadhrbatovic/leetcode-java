package com.hrbatovic.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    //accepted, Runtime 2 ms Beats 88.28% of users with Java, Memory 45.12 MB Beats 5.93% of users with Java
    public static void main(String[] args) {
        System.out.println("{2, 7, 11, 15}, target 9, TwoSum: " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(nums[i])) {
                return new int[]{ (int) map.get(nums[i]), i};
            }

            map.put(target - nums[i], i);

        }
        return null;
    }
}