/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.CreateDatabase;
import dao.QuestionDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.PersonalExam;
import logic.PersonalExaminer;
import logic.Question;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heiniauvinen
 */
public class PersonalExamTest {

    PersonalExam personalExam;
    static ArrayList<String> questionTexts;
    static ArrayList<String> answerTexts;
    static ArrayList<String> studentAnswerTexts;
    static HashMap<String, String> giveStudentAnswer;

    public PersonalExamTest() {
        questionTexts = new ArrayList();
        answerTexts = new ArrayList();
        studentAnswerTexts = new ArrayList();
        giveStudentAnswer = new HashMap();
        String[] questionsArray = {"yksi","kaksi "," kolme"," neljä "};
        String[] answerArray = {"1"," 2"," 3 ","4 "};
        String[] studentAnswerArray = {" 1", "2", " 3", " neljä "};
        Collections.addAll(answerTexts, answerArray);
        Collections.addAll(questionTexts, questionsArray);
        Collections.addAll(studentAnswerTexts, studentAnswerArray);
        
        for (int i = 0; i < questionTexts.size(); i++) {
            giveStudentAnswer.put(questionTexts.get(i).trim(), studentAnswerTexts.get(i));
        }
    }

    @Before
    public void setUp() {
        CreateDatabase.createDatabase();
        personalExam = new PersonalExam();
    }

    @Test
    public void testDatabaseCreation() {
        assertEquals(personalExam.questions.size(), 0);

    }
    @Test
    public void testPersonalExaminer() {
        for (int i = 0; i < questionTexts.size(); i++) {
            personalExam.saveToDatabase(questionTexts.get(i), answerTexts.get(i));
        }
        ArrayList<Question> examQuestions = personalExam.getNewQuestions();
        ArrayList<Question> currentQuestions = personalExam.getCurrentExamQuestions();
        ArrayList<String> studentAnswers = new ArrayList();
        
        for (int i = 0; i < currentQuestions.size(); i++) {
            studentAnswers.add(giveStudentAnswer.get(currentQuestions.get(i).getQuestionText()));
        }
        assertEquals(PersonalExaminer.checkExam(personalExam, studentAnswers), 3);
    }

    @Test
    public void saveToDatabaseReturnsAlertIfQuestionTextAreaIsEmpty() {
        String questionText = "";
        String answerText = "1";

        assertEquals(personalExam.saveToDatabase(questionText, answerText), "Kysymyskentässä pitää olla tekstiä!");

    }

    @Test
    public void saveToDatabaseReturnsAlertIfAnswerTextAreaIsEmpty() {
        String questionText = "Paljonko on 0010 kymmenjärjestelmässä?";
        String answerText = "";

        assertEquals(personalExam.saveToDatabase(questionText, answerText), "Vastauskentässä pitää olla tekstiä!");

    }

}
