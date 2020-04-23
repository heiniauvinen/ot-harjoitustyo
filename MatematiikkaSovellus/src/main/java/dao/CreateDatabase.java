package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Luo uuden tietokannan.
 *
 * @author heiniauvinen
 */
public class CreateDatabase {
    
    /**
     * Luodaan uusi tietokanta.
     */
    public static void createDatabase() {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./questions", "sa", "")) {
            conn.prepareStatement("DROP TABLE Question IF EXISTS;").executeUpdate();
            conn.prepareStatement("CREATE TABLE Question (\n"
                    + "    id INTEGER AUTO_INCREMENT PRIMARY KEY,\n"
                    + "    question VARCHAR(200),\n"
                    + "    answer VARCHAR(200),\n"
                    + ");").executeUpdate();
        } catch (SQLException ex) {

        }
    }

}
