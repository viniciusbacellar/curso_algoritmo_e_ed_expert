package org.example;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,1,0,1};
        System.out.println(maxOnes(nums));
    }

    public static int maxOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                temp++;
            }
            else {
                max=Math.max(max,temp);
                temp=0;
            }
        }
        return Math.max(max,temp);
    }
}