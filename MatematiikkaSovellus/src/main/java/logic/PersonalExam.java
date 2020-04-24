package logic;

import dao.QuestionDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Tämä luokka on itse laadittuja kysymyksiä varten.
 *
 * @author heiniauvinen
 */
public class PersonalExam {

    ArrayList<Question> questions;
    int numberOfQuestions;
    QuestionDao questionDao;
    ArrayList<Question> examQuestions;

    public PersonalExam() {
        this.questions = new ArrayList();
        this.questionDao = new QuestionDao();
        this.questionDao.setDbFileName("questions");
        this.numberOfQuestions = 10;

        try {
            this.questions = questionDao.list();
        } catch (SQLException ex) {
            Logger.getLogger(PersonalExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String saveToDatabase(String questionText, String answerText) {
        if (questionText.trim().equals("")) {
            return "Kysymyskentässä pitää olla testiä!";
        }
        if (answerText.trim().equals("")) {
            return "Vastauskentässä pitää olla testiä!";
        }
        Question question = new Question(questionText, answerText);
        try {
            questionDao.create(question);
            questions.add(question);
            return "Tietokantaan tallennus onnistui.";
        } catch (SQLException ex) {
            return "Tietokantaan tallentaminen epäonnistui.";
        }
    }
    /**
     * Valitsee ja palauttaa uudet kysymykset.
     * @return Palauttaa uudet kysymykset listana.
     */
    public ArrayList<Question> getNewQuestions() {
        int amount = numberOfQuestions <= questions.size() ? numberOfQuestions : questions.size();

        Collections.shuffle(questions);
        examQuestions = new ArrayList();

        for (int i = 0; i < amount; i++) {
            examQuestions.add(questions.get(i));
        }

        return examQuestions;
    }
    /**
     * Palauttaa tämän hetkisen kokeen kysymykset.
     * @return Tämän hetkisen kokeen kysymykset listana.
     */
    public ArrayList<Question> getCurrentExamQuestions() {
        return examQuestions;
    }
    public int getNumberOfCurrentExamQuestions() {
        return examQuestions.size();
    }

}
