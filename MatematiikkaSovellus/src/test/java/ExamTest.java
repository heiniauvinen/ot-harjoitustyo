
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import logic.Exam;
import logic.Question;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heiniauvinen
 */
public class ExamTest {

    Exam exam;

    public ExamTest() {
    }

    @Before
    public void setUp() {
        exam = new Exam();
    }

    @Test
    public void creatingPlusQuestionsGivesQuestions() {
        exam.createPlusExam();
        ArrayList<Question> questions = exam.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            assertEquals(question.getLeft() + question.getRight(), question.getResult());
        }
    }
    
}