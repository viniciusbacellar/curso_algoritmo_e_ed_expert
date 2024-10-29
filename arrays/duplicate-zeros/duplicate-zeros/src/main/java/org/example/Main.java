package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] nums = new int[]{1,0,0,2,3,0,4,5,0};

        duplicateZeros(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static void duplicateZeros(int[] arr) {
        if(arr.length == 1) return;

        for(int i=0; i<arr.length; i++) {
            int right = arr.length-1;
            if(arr[i] == 0) {
                while (right > i) {
                    arr[right] = arr[right-1];
                    right--;
                }
                i++;
            }
        }
    }

    //best solution
    public void duplicateZeros2(int[] arr) {
        int[] tempArr = new int[arr.length];
        for (int arrIndex = 0, tempIndex = 0; tempIndex < tempArr.length; arrIndex++) {
            tempArr[tempIndex] = arr[arrIndex];

            if (tempArr[tempIndex++] == 0 && tempIndex < tempArr.length) {
                tempArr[tempIndex++] = 0;
            }
        }
        System.arraycopy(tempArr, 0, arr, 0, arr.length);
    }
}