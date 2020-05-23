package main.java;

import java.util.Random;

public class CalculationGenerator {

    Random random = new Random();

    private int noOfErrors = 0;
    private int solution = 0;
    private long startTime = 0;
    private boolean stopwatchStarted = false;
    private String questionString = "";
    private String operationMode="Random";

    // CONFIGURE THE TASK: ---------------------------
    private int noOfCalculations = 10; // default: 20
    private int maxAddendMaxSum = 100; // default: 100
    private int maxMinuendMaxSubstrahend = 100; // default: 100
    private int maxFactor = 10; // default: 10
    private int maxDividendMaxQuotient = 10; // default: 10
    //--------------------------------------------------------------------------
    private int remainingCalculations = noOfCalculations;



    public void generateNewCalculation() {

        if(operationMode.equals("Random")){
            generateCalculationByRandom();
        }
        if(operationMode.equals("Addition")){
            generateAddition();
        }
        if(operationMode.equals("Substraction")){
            generateSubstraction();
        }
        if(operationMode.equals("Multiplication")){
            generateMultiplication();
        }
        if(operationMode.equals("Division")){
            generateDivision();
        }

    }

    private void generateCalculationByRandom(){
        int noOfOperations = 4;
        int operation = random.nextInt(noOfOperations);
        operation = 2;

        if (operation == 0) {
            generateAddition();
        }
        if (operation == 1) {
            generateSubstraction();
        }
        if (operation == 2) {
            generateMultiplication();
        }
        if (operation == 3) {
            generateDivision();
        }
    }

    public void setNoOfCalculations(String noOfCalculations){
        this.noOfCalculations=Integer.parseInt(noOfCalculations);
        this.remainingCalculations=this.noOfCalculations;
    }

    private void generateAddition() {
        int firstOperand = random.nextInt(maxAddendMaxSum + 1);
        int maxSecondOperand = maxAddendMaxSum - firstOperand;
        int secondOperand = random.nextInt(maxSecondOperand + 1);
        int solution = firstOperand + secondOperand;
        this.solution = solution;
        String questionString = (firstOperand + " + " + secondOperand + " = ");
        this.questionString = questionString;
    }

    private void generateSubstraction() {
        int firstOperand = random.nextInt(maxMinuendMaxSubstrahend + 1);
        int secondOperand = random.nextInt(firstOperand + 1);
        int solution = firstOperand - secondOperand;
        this.solution = solution;
        String questionString = (firstOperand + " - " + secondOperand + " = ");
        this.questionString = questionString;
    }

    private void generateMultiplication() {
        int firstOperand = random.nextInt(maxFactor + 1);
        int secondOperand = random.nextInt(maxFactor + 1);
        int solution = firstOperand * secondOperand;
        this.solution = solution;
        String questionString = (firstOperand + " x " + secondOperand + " = ");
        this.questionString = questionString;
    }

    private void generateDivision() {
        // divisor : dividend = quotient
        int quotient = random.nextInt(maxDividendMaxQuotient + 1);
        int dividend = random.nextInt(maxDividendMaxQuotient) + 1; // to avoid division by zero
        int divisor = quotient * dividend;
        this.solution = quotient;
        String questionString = (divisor + " : " + dividend + " = ");
        this.questionString = questionString;
    }

    public int getSolution() {
        return solution;
    }

    public String getQuestionstring() {
        return questionString;
    }

    public int getNoOfRemainingCalculations() {
        return remainingCalculations;
    }

    public void countRemainingCalculationsOneDown() {
        remainingCalculations--;
    }

    public int getNoOfErrors() {
        return noOfErrors;
    }

    public void countNoOfErrorsOneUp() {
        noOfErrors++;
    }

    public void startStopwatch() {
        if (!stopwatchStarted) {
            startTime = System.currentTimeMillis();
            stopwatchStarted = true;
        }
    }

    public int getSolutionRate() {
        //[cpm] [calculations per minute]
        long timeElapsed = System.currentTimeMillis() - startTime;
        int solutionRate = (int) (long) (60000 / (timeElapsed / noOfCalculations));
        return solutionRate;
    }

    public void setOperationModeRandom(){
        operationMode="Random";
    }
    public void setOperationModeAddition(){
        operationMode="Addition";
    }
    public void setOperationModeSubstraction(){
        operationMode="Substraction";
    }
    public void setOperationModeMultiplication(){
        operationMode="Multiplication";
    }

    public void setOperationModeDivision(){
        operationMode="Division";
    }
}
