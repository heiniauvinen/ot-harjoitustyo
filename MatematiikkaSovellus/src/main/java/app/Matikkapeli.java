/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import logic.Exam;
import logic.Question;
import ui.Gui;

/**
 *
 * @author heiniauvinen
 */
public class Matikkapeli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Exam exam = new Exam();
        exam.createPlusExam();
        ArrayList<Question> questions = exam.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(questions.get(i));
        }
        Gui.launch(Gui.class);

    }

}
