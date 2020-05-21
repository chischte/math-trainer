package main.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean stayInLoop = true;
        Scanner scanner = new Scanner(System.in);
        QuestionGenerator generator=new QuestionGenerator();

        // GET INITIAL QUESTION
        System.out.println(generator.getQuestionstring());

        while (true) {

            // GET USER RESPONSE
            String name = scanner.nextLine();
            int userAnswer = Integer.parseInt(name);

            // CHECK IF ANSWER IS CORRECT
            if (userAnswer == generator.getSolution()) {
                System.out.println("CORRECT!");
                //GET NEW QUESTION
            }
            else{
                System.out.println("WRONG!");
            }
        }
    }
}
