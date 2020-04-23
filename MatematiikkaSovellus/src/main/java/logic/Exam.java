/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * Tämä luokka on kokeiden luomista ja hallinnointia varten.
 * @author heiniauvinen
 */
public class Exam {

    int upperLimit;
    int lowerLimit;
    int numberOfQuestions;
    ArrayList<Question> questions;
    Random random;
    String mode;

    public Exam() {
        this.upperLimit = 50;
        this.lowerLimit = 0;
        this.numberOfQuestions = 10;
        this.random = new Random();
        this.mode = "plus";
    }
    /**
     * Luo yhteenlaskukokeen.
     */
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
    
    /**
     * Luo vähennyslaskukokeen.
     */
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
    /**
     * Luo kokeen perustuen koetyypin valintaan.
     * Koetyyppi täytyy asettaa ensin setToPlusMode tai setToMinusMode metodeilla.
     * @return Lista kysymysolioita.
     */
    public ArrayList<Question> createAndGetQuestions() {
        if (mode.equals("plus")) {
            createPlusExam();
        }
        if (mode.equals("minus")) {
            createMinusExam();
        }
        return questions;
    }

    /**
     * Asettaa kokeen tyypin yhteenlaskuksi.
     */
    public void setToPlusMode() {
        this.mode = "plus";
    }
    
    /**
     * Asettaa kokeen tyypin vähennyslaskuksi.
     */
    public void setToMinusMode() {
        this.mode = "minus";
    }
    
    /**
     * Kertoo kokeen tyypin merkkijonomuodossa.
     * @return Kokeen tyyppi.
     */
    public String getMode() {
        return mode;
    }

    /**
     * Arpoo numerot väliltä yläraja-alaraja.
     * @return Arvotun luvun kokonaislukuna (int).
     */
    public int giveRandomNumber() {
        int a = random.nextInt(upperLimit - lowerLimit) + lowerLimit + 1;
        return a;
    }
    
    /**
     * Asettaa ala- ja ylärajan kokeen luvuille.
     * @param upperText Merkkijono ylärajaa varten.
     * @param lowerText Merkkijono alarajaa varten.
     * @return Merkkijono, joka kertoo virheestä tai onnistumisesta.
     */
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

    /**
     * Antaa kysymysten lukumäärän.
     * @return Kysymysten määrä kokonaislukuna (int).
     */
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }
    
    /**
     * Antaa listan kysymysolioita.
     * @return Listan kysymysolioita.
     */
    public ArrayList<Question> getQuestions() {
        return questions;
    }
    
}
