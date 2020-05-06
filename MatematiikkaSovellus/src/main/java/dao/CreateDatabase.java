package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Avaa tietokannan, tai luo uuden jos tietokantaa ei ole olemassa.
 *
 * @author heiniauvinen
 */
public class CreateDatabase {

    private static String dbFileName;
    private static final String CREATETABLESQL = "CREATE TABLE IF NOT EXISTS Question (\n"
            + "    id INTEGER AUTO_INCREMENT PRIMARY KEY,\n"
            + "    question VARCHAR(200),\n"
            + "    answer VARCHAR(200)\n"
            + ");";

    /**
     * Avataan aiemmin luotu tietokanta tai luodaan uusi, jos sellaista ei ole.
     */
    public static void createDatabase(String dbFileName) {
        CreateDatabase.dbFileName = dbFileName;
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./" + dbFileName, "sa", "")) {
            conn.prepareStatement(CREATETABLESQL).executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public static void dropTableAndCreateDatabase(String dbFileName) {
        CreateDatabase.dbFileName = dbFileName;
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./" + dbFileName, "sa", "")) {
            conn.prepareStatement("DROP TABLE Question IF EXISTS;").executeUpdate();
            conn.prepareStatement(CREATETABLESQL).executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public static String getDbFileName() {
        return CreateDatabase.dbFileName;
    }

}
