package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] nums = new int[]{-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquare(nums)));

    }

    public static int[] sortedSquare(int[] nums) {
        for(int i=0; i< nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}