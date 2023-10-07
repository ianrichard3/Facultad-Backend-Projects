package org.example;

import java.util.Scanner;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class Tests2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Ingresa tus cojones: ");
//        String name = scanner.nextLine();
//        System.out.printf("Como andas %s? Cuantos anios tenes: ", name);
//        int age = scanner.nextInt();
//        System.out.printf("Estas en tu prime amiguito %s, %d anios tenes!", name, age);


        String myArray[] = {"flaquito dominguez", "poronga", "abecedar", "falopa"};


        int startingIndex = 1;
        int endingIndex = 3;
        Arrays.sort(myArray);
        int found = Arrays.binarySearch(myArray, "poronga");

        System.out.println(Arrays.toString(myArray));
        System.out.println(found);

        scanner.close();
    }

}
