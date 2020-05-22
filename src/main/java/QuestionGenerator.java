package main.java;

import java.util.Random;

public class QuestionGenerator {

    Random random = new Random();

    private int solvedQuestions = 0;
    private int solution = 2;
    private String questionstring = "1 + 1 = ";

    private int maxAddend = 100;
    private int maxSum = maxAddend;
    private int maxMinuendSubstrahend = 20;
    private int maxFactor = 10;
    private int maxDividendMaxQuotient = 10;
    public void generateNewQuestion() {
        int noOfOperations = 4;
        int operation = random.nextInt(noOfOperations);

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

    private void generateAddition() {
        int firstOperand = random.nextInt(maxAddend + 1);
        int maxSecondOperand = maxSum - firstOperand;
        int secondOperand = random.nextInt(maxSecondOperand + 1);
        int solution = firstOperand + secondOperand;
        this.solution = solution;
        String questionString = (firstOperand + " + " + secondOperand + " = ");
        this.questionstring = questionString;
    }

    private void generateSubstraction() {
        int firstOperand = random.nextInt(maxMinuendSubstrahend + 1);
        int secondOperand = random.nextInt(firstOperand+1);
        int solution = firstOperand - secondOperand;
        this.solution = solution;
        String questionString = (firstOperand + " - " + secondOperand + " = ");
        this.questionstring = questionString;
    }

    private void generateMultiplication() {
        int firstOperand = random.nextInt(maxFactor + 1);
        int secondOperand = random.nextInt(maxFactor + 1);
        int solution = firstOperand * secondOperand;
        this.solution = solution;
        String questionString = (firstOperand + " x " + secondOperand + " = ");
        this.questionstring = questionString;
    }

    private void generateDivision() {
        int firstOperand = random.nextInt(maxDividendMaxQuotient + 1);
        int secondOperand = random.nextInt(maxDividendMaxQuotient) + 1; // to avoid division by zero
        int solution = firstOperand * secondOperand;
        this.solution = firstOperand;
        String questionString = (solution + " : " + secondOperand + " = ");
        this.questionstring = questionString;
    }

    public int getSolution() {
        return solution;
    }

    public String getQuestionstring() {
        return questionstring;
    }

    public int getSolvedQuestions() {
        return solvedQuestions;
    }

    public void countSolvedQuestionOneUp() {
        solvedQuestions++;
    }


}
