/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;

/**
 *
 * @author heiniauvinen
 */
public class Examiner {

    ArrayList<Integer> answers;

    public Examiner() {
        this.answers = new ArrayList<>();
    }

    public int checkExam(ArrayList<String> studentAnswers, Exam exam) {
        int numberOfRightAnswers = 0;
        convertAnswersToInt(studentAnswers);
        ArrayList<Question> questions = exam.getQuestions();
        for (int i = 0; i < exam.numberOfQuestions; i++) {
            Integer answer = answers.get(i);
            if (answer != null && answer == questions.get(i).getResult()) {
                numberOfRightAnswers++;
            }
        }
        return numberOfRightAnswers;
    }

    public Integer convertToInteger(ArrayList<String> studentAnswers, int index) {
        try {
            Integer number = Integer.parseInt(studentAnswers.get(index));
            return number;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void convertAnswersToInt(ArrayList<String> studentAnswers) {
        this.answers = new ArrayList<>();
        for (int i = 0; i < studentAnswers.size(); i++) {
            Integer number = convertToInteger(studentAnswers, i);
            answers.add(number);
        }
    }

}
