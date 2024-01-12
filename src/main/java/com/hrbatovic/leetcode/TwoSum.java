package com.hrbatovic.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    //accepted, runtime 2ms, memory 44.80 mb - beats 88.28% of java submissions
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(nums[i])) {
                return new int[]{ (int) map.get(nums[i]), i};
            }

            map.put(target - nums[i], i);

        }
        return null;
    }
}