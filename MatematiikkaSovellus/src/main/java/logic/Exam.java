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
    Random random;

    public Exam() {
        this.upperLimit = 50;
        this.lowerLimit = 0;
        this.numberOfQuestions = 10;
        this.random = new Random();
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

    public void plusQuestion() {

    }

    public void minusQuestion() {

    }

    public int giveRandomNumber() {
        int a = random.nextInt(upperLimit);

        return a;
    }

    public String setLimits(int upper, int lower) {
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
