package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> tList = new ArrayList<>(List.of());
        System.out.println(reverse(tList));
    }


    public static <T> List<T> reverse(List<T> list) {
        return reverseTailRecursive(list, 0, list.size()-1);
    }

    private static <T> List<T> reverseTailRecursive(List<T> list, int left, int right) {
        if(left>right) return list;
        T aux = list.get(right);
        list.set(right--, list.get(left));
        list.set(left++, aux);
        return reverseTailRecursive(list, left, right);
    }

    private static <T> List<T> reverse1(List<T> list) {
        if(list.size() <= 1) return list;
        List<T> tList = new ArrayList<>();
        for(int i = list.size()-1; i>=0; i--) {
            tList.add(list.get(i));
        }
        return tList;
    }

    private static <T> List<T> reverse2(List<T> list) {
        if(list.size() <= 1) return list;

        int left = 0, right = list.size()-1;

        for(int i = 0; left<right; i++) {
            T aux = list.get(right);
            list.set(right--, list.get(left));
            list.set(left++, aux);
        }
        return list;
    }
}