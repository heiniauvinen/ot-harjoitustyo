package logic;

import java.util.ArrayList;

/**
 * Luokka on itse laadittujen kokeiden tarkistusta varten.
 *
 * @author heiniauvinen
 */
public class PersonalExaminer {

    public static int checkExam(PersonalExam personalExam, ArrayList<String> studentAnswers) {
        int numberOfRightAnswers = 0;
        ArrayList<Question> currentExam = personalExam.getCurrentExamQuestions();
        for (int i = 0; i < currentExam.size(); i++) {
            if (currentExam.get(i).getAnswerText().equals(studentAnswers.get(i).trim())) {
                numberOfRightAnswers++;
            }
        }
        return numberOfRightAnswers;
    }

}
