package org.example;


public class Main {
    public static void main(String[] args) {
//        char ast = '*';
//        char esp = ' ';

        // Ej 1
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 4; i++) {
//            // For each line
//            String line = "";
//            for (int j = 1; j <=6; j++) {
//                // For each row
//                line = line + ast;
//                line = line + esp;
//
//            }
//            System.out.println(line);


        // Ej 2
//        for (int i = 1; i <= 4; i++) {
//            // For each line
//            String line = "";
//            for (int j = 1; j <=6; j++) {
//                // For each row
//                if (i % 2 == 1){
//                    line = line + ast;
//                    line = line + esp;
//                }else {
//                    line = line + esp;
//                    line = line + ast;
//                }
//            }
//            System.out.println(line);


////         Ej 3
//        for (int i = 1; i <= 5; i++) {
//            // For each line
//            String line = "";
//            for (int j = 1; j <=i; j++) {
//                // For each row
//                line = line + ast;
//                line = line + esp;
//
//            }
//            System.out.println(line);
//        }

        //         Ej 4
//        for (int i = 1; i <= 9; i++) {
//            int i2 = i;
//            // For each line
//            String line = "";
//            if (i >= 5) {
//                i2 = 10 - i;
//            }
//            for (int j = 1; j <= i2; j++) {
//                // For each row
//                line = line + ast;
//                line = line + esp;
//
//            }
//            System.out.println(line);
//        }
//        1-55615-507-7
//        1-55615-507-9
//        950-07-2749-8
        String input = "-450-222749-8";
        System.out.println(validISBN(input));
    }

    public static boolean validISBN(String codigo) {
        if (codigo.length() != 13){return false;}



        // Digits
        String digits = "0123456789";
        // Return boolean
        boolean isValid = true;
        // Counters
        int dashCounter = 0;
        int charsInWord = 0;
        int k = 10;
        // main Sum
        int sum = 0;


        // loop
        for (int i = 0; i < codigo.length(); i++){
            if (!isValid){
                break;
            }
            char curChar = codigo.charAt(i);

            if (curChar == '-'){
                if (charsInWord == 0) {
                    isValid = false;
                }
                charsInWord = 0;
                dashCounter += 1;
            }
            else {
                if ( ! digits.contains(String.valueOf(curChar)) ){

                    isValid = false;
                }
                charsInWord += 1;

                int numb = curChar - '0';

                sum += numb * k;
//                System.out.println(k);
                k -= 1;

            }



        }

//        System.out.println(sum);
        if (sum % 11 != 0) {

            isValid = false;
        }

        return isValid;
    }



}