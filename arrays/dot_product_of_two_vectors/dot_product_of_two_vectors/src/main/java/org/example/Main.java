package org.example;

public class Main {


    public static void main(String[] args) {
        int[] nums1 = new int[]{0,1,0,0,2,0,0};
        int[] nums2 = new int[]{1,0,0,0,3,0,4};

        System.out.println(dotProductOfTwoVectors(nums1, nums2));
    }

    public static int dotProductOfTwoVectors(int[] nums1, int[] nums2) {
        int result = 0;
        for(int i = 0; i<nums1.length; i++) {
            result += nums1[i] * nums2[i];
        }
        return result;
    }
}