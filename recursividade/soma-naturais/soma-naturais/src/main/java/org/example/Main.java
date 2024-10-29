package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println(sumNaturals(100));
    }

    public static int sumNaturals(int n) {
        if(n > 0) {
            return n + sumNaturals(n-1);
        }
        return 0;
    }
}