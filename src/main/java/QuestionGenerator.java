package main.java;

import java.util.Random;

public class QuestionGenerator {

    Random random = new Random();

    private int solution = 2;
    private String questionstring = "1 + 1 = ";


    public void generateNewQuestion() {
        int operation = random.nextInt(3);

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
        int firstOperand = random.nextInt(20) + 1;
        int secondOperand = random.nextInt(20) + 1;
        int solution = firstOperand + secondOperand;
        this.solution = solution;
        String questionString = (firstOperand + " + " + secondOperand + " = ");
        this.questionstring = questionString;
    }

    private void generateSubstraction() {
        int firstOperand = random.nextInt(20) + 1;
        int secondOperand = random.nextInt(firstOperand) + 1;
        int solution = firstOperand - secondOperand;
        this.solution = solution;
        String questionString = (firstOperand + " - " + secondOperand + " = ");
        this.questionstring = questionString;
    }

    private void generateMultiplication() {
        int firstOperand = random.nextInt(9) + 1;
        int secondOperand = random.nextInt(9) + 1;
        int solution = firstOperand * secondOperand;
        this.solution = solution;
        String questionString = (firstOperand + " x " + secondOperand + " = ");
        this.questionstring = questionString;
    }

    private void generateDivision() {
        int firstOperand = random.nextInt(9) + 1;
        int secondOperand = random.nextInt(9) + 1;
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


}
