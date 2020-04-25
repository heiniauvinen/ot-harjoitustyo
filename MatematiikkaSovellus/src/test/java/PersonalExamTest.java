/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.CreateDatabase;
import dao.QuestionDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.PersonalExam;
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
    QuestionDao questionDao;

    public PersonalExamTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testDatabaseCreation() {
        CreateDatabase.createDatabase();
        this.personalExam = new PersonalExam();

        assertEquals(personalExam.questions.size(), 0);

    }

    @Test
    public void saveToDatabaseReturnsAlertIfQuestionTextAreaIsEmpty() {
        String questionText = "";
        String answerText = "1";

        assertEquals(personalExam.saveToDatabase(questionText, answerText), "Kysymyskentässä pitää olla testiä!");

    }

    @Test
    public void saveToDatabaseReturnsAlertIfAnswerTextAreaIsEmpty() {
        String questionText = "Paljonko on 0010 kymmenjärjestelmässä?";
        String answerText = "";

        assertEquals(personalExam.saveToDatabase(questionText, answerText), "Vastauskentässä pitää olla testiä!");

    }

//    @Test
//    public void getNewQuestionsReturnsQuestions() {
//        this.questionDao = new QuestionDao();
//        ArrayList<Question> questions = new ArrayList();
//
//        try {
//            questions = questionDao.list();
//        } catch (SQLException ex) {
//            Logger.getLogger(PersonalExam.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        assertEquals(personalExam.getNewQuestions(), questions);
//    }

}
