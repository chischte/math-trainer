package main.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean stayInLoop = true;
        Scanner scanner = new Scanner(System.in);
        QuestionGenerator generator=new QuestionGenerator();

        // GET INITIAL QUESTION
        generator.generateNewQuestion();


        while (true) {
            System.out.println(generator.getQuestionstring());
            // GET USER RESPONSE
            String name = scanner.nextLine();
            int userAnswer = Integer.parseInt(name);

            // CHECK IF ANSWER IS CORRECT
            if (userAnswer == generator.getSolution()) {
                System.out.println("CORRECT!");
                generator.generateNewQuestion();
            }
            else{
                System.out.println("WRONG!");
            }
        }
    }
}
