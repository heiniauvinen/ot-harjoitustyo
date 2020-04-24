package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logic.Question;

/**
 * Dao luokka kysymyksiä varten.
 *
 * @author heiniauvinen
 */
public class QuestionDao implements Dao<Question, Integer> {

    String dbPath;

    public void setDbFileName(String fileName) {
        this.dbPath = "jdbc:h2:./" + fileName;
    }

    @Override
    public void create(Question question) throws SQLException {
        Connection connection = DriverManager.getConnection(dbPath, "sa", "");
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Question" + " (question, answer)" + " VALUES (?, ?)");
        stmt.setString(1, question.questionString());
        stmt.setString(2, question.getAnswerText());

        stmt.executeUpdate();
        stmt.close();
        connection.close();

    }

    @Override
    public ArrayList<Question> list() throws SQLException {
        ArrayList<Question> questions = new ArrayList();
        try (Connection connection = DriverManager.getConnection(dbPath, "sa", "")) {
            ResultSet rs;
            try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Question")) {
                rs = stmt.executeQuery();
                while (rs.next()) {
                    Question question = new Question(rs.getString("question"), rs.getString("answer"));
                    questions.add(question);
                }
                stmt.close();
            }
            rs.close();
            connection.close();
        }
        return questions;
    }

}
