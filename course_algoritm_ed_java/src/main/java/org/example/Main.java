package org.example;

import org.example.models.Csv;
import org.example.models.DateInfo;
import org.example.models.EmailInfo;

import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Exercicio CPF: " + removeNonDigits("874.092.172-93"));

        System.out.println("Exercicio Email: \n" + extractEmailInformation("maria123@gmail.com"));

        System.out.println("Exercicio Data: \n" + extractDateData("21/07/2010"));

        System.out.println("Exercicio Data: \n" + formatDate(21, 12, 2010));

        if(validatePassword("amrca154682")) System.out.println("Exercicio senha: VALIDA");
        else System.out.println("Exercicio senha: INVALIDA");

        System.out.println(isAnagram2("batata", "attabe"));

        System.out.println(longestCommonPrefix(new String[]{"floght","flight","flight"}));

        System.out.println(invalidTransactions2(new String[]{"alice,20,800,mtv","bob,50,1200,mtv"}));
    }

    public static String removeNonDigits(String str) {
        return str.replaceAll("\\D", "");
    }

    public static EmailInfo extractEmailInformation(String email) {
        String[] emailSplit = email.split("@");
        String isBrazilian = email.endsWith(".br") ? "Sim" : "Não";
        return new EmailInfo(emailSplit[0], emailSplit[1], isBrazilian);
    }

    public static DateInfo extractDateData(String date) {
        String[] dataSplit = date.split("/");
        return new DateInfo(dataSplit[0], dataSplit[1], dataSplit[2]);
    }

    public static String formatDate(int day, int month, int year) {
        return String.format("%02d/%02d/%d", day, month, year);
    }

    public static boolean validatePassword(String str) {
        return Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#&])[A-Za-z\\d@#&]{8,}$", str);
    }

    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;
        int size = s.length();
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        char[] result = new char[26];

        for(int i = 0; i < size; i++) {
            result[chars1[i] - 'a']++;
            result[chars2[i] - 'a']--;
        }

        for(char s1 : chars1) {
            if(result[s1 - 'a'] > 0) return false;
        }

        return true;
    }


    public static String longestCommonPrefix(String[] v) {
        Arrays.sort(v);
        char[] initialString = v[0].toCharArray();
        char[] lastString = v[v.length-1].toCharArray();

        String result = "";
        for(int i = 0; i<initialString.length; i++) {
            if(initialString[i] == lastString[i]) {
                result = result.concat(String.valueOf(initialString[i]));
                continue;
            }
            return result;
        }
        return result;
    }

    public static String longestCommonPrefix2(String[] v) {
        Arrays.sort(v);

        String first = v[0];
        String last = v[v.length - 1];

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < first.length(); i++) {
            if (i < last.length() && first.charAt(i) == last.charAt(i)) {
                result.append(first.charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }

    public static List<String> invalidTransactions(String[] transactions) {
        int length = transactions.length;
        List<String> resultList = new ArrayList<>();

        for (String transaction : transactions) {
            Csv tempCsv = new Csv(transaction);
            for (int j = 1; j < length; j++) {
                Csv tempCsv2 = new Csv(transactions[j]);

                if (validateRules(tempCsv, tempCsv2)) {
                    resultList.add(tempCsv.toString());
                    resultList.add(tempCsv2.toString());
                    continue;
                }
                if (tempCsv.getAmount() > 1000) resultList.add(tempCsv.toString());
                if (tempCsv2.getAmount() > 1000) resultList.add(tempCsv2.toString());
            }
        }
        return resultList.stream().distinct().toList();
    }

    public static List<String> invalidTransactions2(String[] transactions) {
        int length = transactions.length;
        Set<String> result = new HashSet<>();

        for (int i=0; i<length; i++) {
            Csv tempCsv = new Csv(transactions[i]);
            for (int j = i+1; j < length; j++) {
                Csv tempCsv2 = new Csv(transactions[j]);

                if (validateRules(tempCsv, tempCsv2)) {
                    result.add(tempCsv.toString());
                    result.add(tempCsv2.toString());
                    continue;
                }
                if (tempCsv.getAmount() > 1000) result.add(tempCsv.toString());
                if (tempCsv2.getAmount() > 1000) result.add(tempCsv2.toString());
            }
        }
        return result.stream().toList();
    }

    private static boolean validateRules(Csv csv1, Csv csv2) {
        return (csv1.getAmount() > 1000 && csv2.getAmount() > 1000) ||
                (subtrairMaiorPorMenor(csv1.getTime(), csv2.getTime()) < 60 &&
                        !csv1.getCity().equals(csv2.getCity()) &&
                        csv1.getName().equals(csv2.getName()));
    }

    private static int subtrairMaiorPorMenor(int time1, int time2) {
        return Math.abs(time1 - time2);
    }

}











