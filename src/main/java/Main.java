package main.java;

import java.util.Scanner;

// TODO: Make sound when correct
// TODO: Stop time, calculate speed in calcs/minute

public class Main {

    public static void main(String[] args) {
        boolean stayInLoop = true;
        Scanner scanner = new Scanner(System.in);
        CalculationGenerator generator = new CalculationGenerator();
        int noOfRemainingCalculations=generator.getNoOfRemainingCalculations();

        // GET INITIAL QUESTION
        generator.generateNewCalculation();

        while (noOfRemainingCalculations>0) {
            System.out.println(generator.getQuestionstring());

            // GET USER RESPONSE
            String userInput = scanner.nextLine();

            int userAnswer= 0;

            try {
                userAnswer = Integer.parseInt(userInput);
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid entry: " + nfe.getMessage());
            }

            // CHECK IF ANSWER IS CORRECT
            if (userAnswer == generator.getSolution()) {
                System.out.print("CORRECT! * ");
                generator.generateNewCalculation();
                generator.countRemainingCalculationsOneDown();
                noOfRemainingCalculations=generator.getNoOfRemainingCalculations();
                System.out.println(noOfRemainingCalculations + " * CALCULATIONS REMAINING");
            } else {
                System.out.println("WRONG! ...TRY AGAIN: ");
            }
        }
        System.out.println("CONGRATLATIONS! YOU DID IT!");
    }
}
