/*
 * Copyright (c) 2000 - 2024 by Raiffeisen Software GmbH.
 * All rights reserved.
 *
 */
package com.hrbatovic.leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] one = {0,0,0,3};
        removeDuplicatesBad(one);
        System.out.println(Arrays.toString(one));

        int[] two = {0,0,0,3};
        removeDuplicates(two);
        System.out.println(Arrays.toString(two));
    }

    //accepted Runtime 1 ms Beats 89.26% of users with Java, Memory 44.79 MB Beats 28.05% of users with Java
    public static int removeDuplicates(int[] nums) {
        int j=1;
        int n = nums.length;

        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]){
                nums[j]=nums[i];
                j++;
            }
        }

        return j;
    }

    //accepted Runtime 524 ms Beats 5.11% of users with Java, Memory 44.67 MB Beats 37.41% of users with Java
    public static int removeDuplicatesBad(int[] nums) {
        int duplicates = 0;
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] == nums[i]){
                duplicates++;
            }
        }

        for(int i = 1; i < nums.length; i++){
            for(int x = 1; x < nums.length; x ++){
                if(max < nums[x]){
                    max = nums[x];
                    break;
                }
            }
            if(i > 0 && nums[i-1] >= nums[i]){
                nums[i] = max;
            }
        }

        return nums.length-duplicates;
    };
}
