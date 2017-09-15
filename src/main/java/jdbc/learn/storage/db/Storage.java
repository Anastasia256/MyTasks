package jdbc.learn.storage.db;

import jdbc.learn.entity.Elephant;

import java.sql.SQLException;
import java.util.List;

public interface Storage {
    List<Elephant> getAllElephants() throws SQLException;
    Elephant getElephantById(Integer id) throws SQLException;
    Elephant getElephantByName(String name) throws SQLException;
    int updateElephant(Elephant elephant) throws SQLException;
    int deleteElephant(Integer id) throws SQLException;
    int insertElephant(Elephant elephant) throws SQLException;
}
