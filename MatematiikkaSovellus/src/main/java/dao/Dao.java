package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Data Access Object rajapinta.
 *
 * @author heiniauvinen
 * @param <T> Geneerinen tyyppiparametri.
 * @param <K> Geneerinen tyyppiparametri.
 */
public interface Dao<T, K> {

    void create(T object) throws SQLException;

    ArrayList<T> list() throws SQLException;
}
