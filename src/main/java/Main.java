package main.java;

import java.util.Scanner;

// TODO: Check if better alternative to lots of static functions!
// TODO: Make sound when correct

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static CalculationGenerator generator = new CalculationGenerator();

    public static void main(String[] args) {

        while (true) {
            userSelectOperationMode();

            userSelectNoOfCalculations();

            userStartCalculationCycle();

            generator.setNoOfErrorsZero();

            generator.generateNewCalculation();

            generator.startStopwatch();

            runCalculationLoop();

            printSummary();
        }
    }

    static void userSelectOperationMode() {

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
    }

    static void userSelectNoOfCalculations() {
        System.out.println("SELECT NUMBER OF CALCULATIONS TO BE SOLVED:");
        String noOfCalculations = scanner.nextLine();
        generator.setNoOfCalculations(noOfCalculations);
    }

    static void userStartCalculationCycle() {
        System.out.println("PRESS ENTER TO START THE COMPETITION");
        String startString = scanner.nextLine();
    }

    static int getUserAnswer() {
        String userInput = scanner.nextLine();
        int userAnswer = 0;

        try {
            userAnswer = Integer.parseInt(userInput);
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid entry: " + nfe.getMessage());
        }
        return userAnswer;
    }

    static void runCalculationLoop() {
        int noOfRemainingCalculations = generator.getNoOfRemainingCalculations();
        while (noOfRemainingCalculations > 0) {

            System.out.println(generator.getQuestionstring());

            int userAnswer = getUserAnswer();

            checkUserAnswer(userAnswer);

            noOfRemainingCalculations = generator.getNoOfRemainingCalculations();
        }
    }

     static void checkUserAnswer(int userAnswer){
        // CHECK IF ANSWER IS CORRECT

        if (userAnswer == generator.getSolution()) {
            System.out.print("CORRECT! *");
            generator.generateNewCalculation();
            generator.countRemainingCalculationsOneDown();
            int noOfRemainingCalculations = generator.getNoOfRemainingCalculations();
            System.out.println(noOfRemainingCalculations + "* TO GO");
        } else {
            System.out.println("WRONG! ...TRY AGAIN: ");
            generator.countNoOfErrorsOneUp();
        }
    }

    static void printSummary() {
        System.out.println("CONGRATULATIONS! YOU DID IT !!! :-)");
        System.out.print("YOU HAD A SOLUTION RATE OF " + generator.getSolutionRate());
        System.out.println(" CALCULATIONS PER MINUTE");
        System.out.println("YOU MADE " + generator.getNoOfErrors() + " ERRORS.");
        System.out.println("*********************************************");
    }

}
