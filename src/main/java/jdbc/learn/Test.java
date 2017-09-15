package jdbc.learn;

import jdbc.learn.connect.db.ConnectorDB;
import jdbc.learn.storage.db.ElephantStorage;
import jdbc.learn.storage.db.Storage;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        Storage storage = new ElephantStorage(ConnectorDB.getConnection());
        storage.getAllElephants().forEach(System.out::println);
    }
}
