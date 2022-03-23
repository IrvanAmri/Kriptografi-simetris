package com.tugas2kriptografi;

import java.util.Scanner;

public class App 
{
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
    private static void option1(Scanner scan) {
        System.out.println("masukkan plaintext anda! ...");
        String plainText = scan.nextLine();
        String cipherText = Services.enkripsi(plainText);
        System.out.println("hasil enkripsi: ");
        System.out.println(cipherText);
    }
    private static void option2(Scanner scan) {
        System.out.println("masukkan ciphertext anda! ...");
        String cipherText = scan.nextLine();
        String plainText = Services.deskripsi(cipherText);
        System.out.println("hasil deskripsi: ");
        System.out.println(plainText);
    }
    private static void option3() {
        System.out.println("Sampai jumpa");
    }
    public static void main( String[] args )
    {
        String[] options = {"1- Enkripsi",
                            "2- Deskripsi",
                            "3- Exit",
        };
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int option = 1;
        while (option!=3){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1: option1(scanner2); break;
                    case 2: option2(scanner2); break;
                    case 3: option3(); break;
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    }
}
