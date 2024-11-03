package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> sales = new ArrayList<>(List.of(
                "8349,14/09/2024,899.9,ESPORTE",
                "4837,17/09/2024,530.0,VESTUARIO",
                "15281,21/09/2024,1253.99,ESPORTE",
                "15344,27/09/2024,1000.9,VESTUARIO",
                "18317,04/10/2024,250.4,VESTUARIO",
                "18972,11/10/2024,385.5,JARDINAGEM"));

        double[] result = totalSales(sales, "VESTUARIO");
        System.out.println(String.format("%.0f VENDAS \nTOTAL = $ %.2f", result[0], result[1]));
    }

    public static double[] totalSales(List<String> sales, String department) {
        double[] result = new double[2];
        return totalSalesAux(sales, sales.size()-1, result, department);
    }

    private static double[] totalSalesAux(List<String> sales, int right, double[] result, String department) {
        if(sales.get(right).contains(department)) {
            result[0]++;
            result[1] += Double.parseDouble(sales.get(right).split(",")[2]);
        }
        if(right>0) {
            return totalSalesAux(sales, right-1, result, department);
        }
        return result;
    }
}