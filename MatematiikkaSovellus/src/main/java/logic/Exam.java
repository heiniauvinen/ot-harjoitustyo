/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author heiniauvinen
 */
public class Exam {

    int upperLimit;
    int lowerLimit;
    int numberOfQuestions;
    ArrayList<Question> questions;
//    ArrayList<Integer> answers;
    Random random;
    String mode;

    public Exam() {
        this.upperLimit = 50;
        this.lowerLimit = 0;
        this.numberOfQuestions = 10;
        this.random = new Random();
        this.mode = "plus";
    }

    public void createPlusExam() {
        this.questions = new ArrayList<>();
        for (int i = 0; i < numberOfQuestions; i++) {
            int left = giveRandomNumber();
            int right = giveRandomNumber();
            int result = left + right;
            Question question = new Question(left, right, result, "+");
            questions.add(question);
        }
    }

    public void createMinusExam() {
        this.questions = new ArrayList<>();
        for (int i = 0; i < numberOfQuestions; i++) {
            int left = giveRandomNumber();
            int right = giveRandomNumber();
            int result = left - right;
            Question question = new Question(left, right, result, "-");
            questions.add(question);
        }
    }

    public ArrayList<Question> createAndGetQuestions() {
        if (mode.equals("plus")) {
            createPlusExam();
        }
        if (mode.equals("minus")) {
            createMinusExam();
        }
        return questions;
    }

    public void setToPlusMode() {
        this.mode = "plus";
    }

    public void setToMinusMode() {
        this.mode = "minus";
    }

    public String getMode() {
        return mode;
    }

    public int giveRandomNumber() {
        int a = random.nextInt(upperLimit - lowerLimit) + lowerLimit + 1;
        return a;
    }

    public String setLimits(String upperText, String lowerText) {
        int upper = 0;
        int lower = 0;
        try {
            upper = Integer.parseInt(upperText);
            lower = Integer.parseInt(lowerText);
        } catch (NumberFormatException e) {
            return "Virheellinen syöte!";
        }
        if (upper < lower) {
            return "Ylärajan tulee olla suurempi kuin alarajan!";
        } else {
            this.upperLimit = upper;
            this.lowerLimit = lower;
            return "OK";
        }
    }
    
    public ArrayList<Question> getQuestions() {
        return questions;
    }

}
