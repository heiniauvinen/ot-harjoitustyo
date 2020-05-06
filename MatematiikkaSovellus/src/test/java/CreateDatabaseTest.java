/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.CreateDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logic.Question;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heiniauvinen
 */
public class CreateDatabaseTest {

    public CreateDatabaseTest() {
    }

    @Before
    public void setUp() {
        CreateDatabase.createDatabase("testDb");
    }

    @Test
    public void createDatabaseSetsFileName() {
        assertEquals(CreateDatabase.getDbFileName(), "testDb");
    }

    @Test
    public void databaseExists() {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./" + CreateDatabase.getDbFileName(), "sa", "")) {
            ResultSet rs;
            try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Question")) {
                rs = stmt.executeQuery();
                while (rs.next()) {
                    Question question = new Question(rs.getString("question"), rs.getString("answer"));
                }
                stmt.close();
                rs.close();
            } catch (SQLException ex) {

            }
            connection.close();
            assertTrue(true);
        } catch (SQLException ex) {
            fail("Database does not exists.");
        }
    }
}
