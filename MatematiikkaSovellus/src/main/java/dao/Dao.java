package dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Data Access Object rajapinta.
 * @author heiniauvinen
 * @param <T> Geneerinen tyyppiparametri.
 * @param <K> Geneerinen tyyppiparametri.
 */
public interface Dao<T, K> {
    void create(T object) throws SQLException;
    List<T> list() throws SQLException;
}
