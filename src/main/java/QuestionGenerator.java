package main.java;

import java.util.Random;

public class QuestionGenerator {

    Random random=new Random();

    private int solution = 2;
    private String questionstring = "1 + 1 = ";


    public void generateNewQuestion(){
        int firstOperand = random.nextInt(9)+1;
        int secondOperand = random.nextInt(9)+1;
        int solution = firstOperand*secondOperand;
        this.solution=solution;
        String questionString=(firstOperand + " x " + secondOperand + " = ");
        this.questionstring=questionString;
    }





    public int getSolution() {
        return solution;
    }

    public String getQuestionstring() {
        return questionstring;
    }





}
