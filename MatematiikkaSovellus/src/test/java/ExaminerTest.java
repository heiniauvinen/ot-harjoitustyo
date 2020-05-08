
import java.util.ArrayList;
import logic.Exam;
import logic.Examiner;
import logic.Question;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heiniauvinen
 */
public class ExaminerTest {

    Examiner examiner;
    ArrayList<Integer> answers;
    Exam exam;

    public ExaminerTest() {

    }

    @Before
    public void setUp() {
        examiner = new Examiner();
        exam = new Exam();
        answers = new ArrayList();
    }

    @Test
    public void checkExamWorksIfAnswersAreNull() {
        ArrayList<String> studentAnswers = new ArrayList();
        ArrayList<Question> questions = exam.createAndGetQuestions();
        for (int i = 0; i < questions.size(); i++) {
            studentAnswers.add("harri");
        }
        int result = 0;
        assertEquals(examiner.checkExam(studentAnswers, exam), result);
    }

    @Test
    public void checkExamWorks() {
        ArrayList<String> studentAnswers = new ArrayList();
        exam.setToPlusMode();
        exam.setLimits("30", "1");
        ArrayList<Question> questions = exam.createAndGetQuestions();
        studentAnswers.add("-1");
        for (int i = 1; i < questions.size(); i++) {
            studentAnswers.add(String.valueOf(questions.get(i).getResult()));
        }

        assertEquals(exam.getNumberOfQuestions() - 1, examiner.checkExam(studentAnswers, exam));
    }

    @Test
    public void convertToIntegerWorks() {
        ArrayList<String> studentAnswers = new ArrayList();
        studentAnswers.add("1");
        Integer result = 1;
        assertEquals(examiner.convertToInteger(studentAnswers, 0), result);
        studentAnswers.add("2");
        Integer result2 = 2;
        assertEquals(examiner.convertToInteger(studentAnswers, 1), result2);
        studentAnswers.add("3");
        Integer result3 = 3;
        assertEquals(examiner.convertToInteger(studentAnswers, 2), result3);
    }

}
