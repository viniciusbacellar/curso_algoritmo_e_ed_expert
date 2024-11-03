package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println(fib(7));
    }

    public static int fib(int n) {
        return fibAux(0, 1, n);
    }

    public static int fibAux(int left, int right, int n) {
        if(n==0) return left;
        if(n==1) return right;
        return fibAux(right, left + right, n-1);
    }
}