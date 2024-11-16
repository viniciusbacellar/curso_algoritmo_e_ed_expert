package org.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[]{20,9,86,-2,16};

        System.out.println(Arrays.toString(mergeSort(array, 0, array.length - 1)));
    }

    private static int[] mergeSort(int[] nums, int left, int right) {
        if(left < right) {
            int middle = (left + right) / 2;

            mergeSort(nums, left, middle);
            mergeSort(nums, middle+1, right);
            merge(nums, left, middle, right);
        }
        return nums;
    }

    private static void merge(int[] nums, int left, int middle, int right) {
        int[] result = new int[nums.length];
        int length = right - left + 1;
        int i = left;
        int j = middle+1;
        int k = 0;

        while(i<=middle && j <= right) {
            if(nums[i] < nums[j]) {
                result[k++] = nums[i++];
            }
            else {
                result[k++] = nums[j++];
            }
        }

        while(i <= middle) {
            result[k++] = nums[i++];
        }

        while(j <= right) {
            result[k++] = nums[j++];
        }

        for(int l=0; l<length; l++) {
            nums[left+l] = result[l];
        }
    }
}