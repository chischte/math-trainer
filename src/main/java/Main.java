package main.java;

import java.util.Scanner;

// TODO: Make sound when correct
// TODO: Permanently inform of the current solution rate

public class Main {

    public static void main(String[] args) {
        boolean stayInLoop = true;
        Scanner scanner = new Scanner(System.in);
        CalculationGenerator generator = new CalculationGenerator();
        int noOfRemainingCalculations = generator.getNoOfRemainingCalculations();
        while (true) {
            System.out.println("SELECT OPERATION MODE:");
            System.out.println("1=random 2=addition 3=substraction 4=multiplication 5=division");
            String operationMode = scanner.nextLine();
            if (operationMode.equals("1")) {
                generator.setOperationModeRandom();
            }
            if (operationMode.equals("2")) {
                generator.setOperationModeAddition();
            }
            if (operationMode.equals("3")) {
                generator.setOperationModeSubstraction();
            }
            if (operationMode.equals("4")) {
                generator.setOperationModeMultiplication();
            }
            if (operationMode.equals("5")) {
                generator.setOperationModeDivision();
            }
            System.out.println("SELECT NUMBER OF CALCULATIONS TO BE SOLVED:");
            String noOfCalculations = scanner.nextLine();
            generator.setNoOfCalculations(noOfCalculations);


            System.out.println("PRESS ENTER TO START THE COMPETITION");
            String startString = scanner.nextLine();
            generator.startStopwatch();

            // GET INITIAL QUESTION
            generator.generateNewCalculation();


            while (noOfRemainingCalculations > 0) {
                System.out.println(generator.getQuestionstring());

                // GET USER RESPONSE
                String userInput = scanner.nextLine();

                int userAnswer = 0;

                try {
                    userAnswer = Integer.parseInt(userInput);
                } catch (NumberFormatException nfe) {
                    System.out.println("Invalid entry: " + nfe.getMessage());
                }

                // CHECK IF ANSWER IS CORRECT

                if (userAnswer == generator.getSolution()) {
                    System.out.print("CORRECT! *");
                    generator.generateNewCalculation();
                    generator.countRemainingCalculationsOneDown();
                    noOfRemainingCalculations = generator.getNoOfRemainingCalculations();
                    System.out.println(noOfRemainingCalculations + "* TO GO");
                } else {
                    System.out.println("WRONG! ...TRY AGAIN: ");
                    generator.countNoOfErrorsOneUp();
                }
            }
            System.out.println("CONGRATULATIONS! YOU DID IT !!! :-)");
            System.out.print("YOU HAD A SOLUTION RATE OF " + generator.getSolutionRate());
            System.out.println(" CALCULATIONS PER MINUTE");
            System.out.println("YOU MADE " + generator.getNoOfErrors() + " ERRORS.");
            System.out.println("*********************************************");
        }
    }
}
