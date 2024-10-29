package org.example;

public class Main {
    public static void main(String[] args) {

        int[] nums = new int[]{555,901,482,1771};
        System.out.println(findNumbers(nums));

    }

    public static int findNumbers(int[] nums) {
        int result = 0;
        for(int i = 0; i<nums.length; i++) {
            int temp = nums[i];
            int count = 0;
            while(temp > 0) {
                count++;
                temp /= 10;
            }
            if(count % 2 == 0) result++;
        }
        return result;
    }
}