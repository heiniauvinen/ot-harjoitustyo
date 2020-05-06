
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import logic.Exam;
import logic.Question;
import org.junit.Before;
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
        exam.setToPlusMode();
        exam.setLimits("20", "1");
        ArrayList<Question> questions = exam.createAndGetQuestions();
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            assertEquals(question.getLeft() + question.getRight(), question.getResult());
        }
    }

    @Test
    public void creatingMinusQuestionGivesQuestions() {
        exam.setToMinusMode();
        ArrayList<Question> questions = exam.createAndGetQuestions();
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            assertEquals(question.getLeft() - question.getRight(), question.getResult());
        }
    }

    @Test
    public void setToPlusModeWorksCorrectly() {
        exam.setToPlusMode();
        assertEquals(exam.getMode(), "plus");
    }

    @Test
    public void setToMinusModeWorksCorrectly() {
        exam.setToMinusMode();
        assertEquals(exam.getMode(), "minus");
    }
    
    @Test
    public void questionToString() {
        Question question = new Question(2,3,5,"+");
        assertEquals(question.toString(), "2 + 3 = 5");
    }
    
    @Test
    public void setAndgetNumberOfQuestonsWorks() {
        exam.setNumberOfQuestions("3");
        assertEquals(exam.getNumberOfQuestions(), 3);
    }


}
