package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println(factorial2(5, 1));
    }

    public static int factorial(int n) {
        if(n == 0) return 1;
        return n * factorial(n-1);
    }

    public static int factorial2(int n, int aux) {
        if(n == 0) return aux;
        return factorial2(n-1, aux * n);
    }
}