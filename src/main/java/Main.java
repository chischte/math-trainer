package main.java;

import java.util.Scanner;

// TODO: Make sound when correct
// TODO: Fix bug programm aborts when text entry or no entry
// TODO: Stop time, calculate speed in calcs/minute

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
            String userInput = scanner.nextLine();
            int userAnswer = Integer.parseInt(userInput);


            // CHECK IF ANSWER IS CORRECT
            if (userAnswer == generator.getSolution()) {
                System.out.println("CORRECT!");
                generator.generateNewQuestion();
                generator.countSolvedQuestionOneUp();
                System.out.println("Number of solved questions: " +generator.getSolvedQuestions());
            }
            else{
                System.out.println("WRONG!");
            }
        }
    }
}
