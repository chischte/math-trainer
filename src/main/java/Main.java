package main.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean stayInLoop = true;
        Scanner scanner = new Scanner(System.in);

        // GET INITIAL QUESTION
        System.out.println("1+1=");

        while (true) {

            // GET USER RESPONSE
            String name = scanner.nextLine();
            int userAnswer = Integer.parseInt(name);

            // CHECK IF ANSWER IS CORRECT
            if (userAnswer == 2) {
                System.out.println("CORRECT!");
                //GET NEW QUESTION
            }
            else{
                System.out.println("WRONG!");
            }
        }
    }
}
