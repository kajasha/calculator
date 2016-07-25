package it.morfoza;

import java.util.Scanner;

// comment :)
public class Main {
    public static void main(String[] args) {


        System.out.println("Hola!!!!");
        System.out.println("add, substract or multiplication?");

        Scanner input = new Scanner(System.in);
        String name = input.nextLine();


        int x;
        x = input.nextInt();
        int y;
        y = input.nextInt();

        int result = 0;

        if (name.equals("add")) {
            result = x + y;
        }

        if (name.equals("substract")) {
            result = x - y;

        }

        if (name.equals("multiplication")) {
            result = x * y;
        }

        System.out.println(name + ", Your result is : " + result);


    }
}
