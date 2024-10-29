package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        int m = 0;
        int n = 1;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0; i<n; i++) {
            nums1[m] = nums2[i];
            m++;
        }
        Arrays.sort(nums1);
    }
}