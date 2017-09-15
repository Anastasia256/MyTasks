package jdbc.learn.storage.db;

import jdbc.learn.entity.Elephant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ElephantStorage implements Storage {

    private Connection connection;

    public ElephantStorage(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Elephant> getAllElephants() throws SQLException {
        String query = "SELECT * FROM animals.elephant";

        List<Elephant> elephants = new ArrayList<>();

        try (PreparedStatement st = connection.prepareStatement(query)) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Elephant elephant = new Elephant();
                elephant.setId(rs.getInt("id"));
                elephant.setAge(rs.getInt("age"));
                elephant.setName(rs.getString("name"));
                elephant.setWeight(rs.getDouble("weight"));
                elephants.add(elephant);
            }
        }
        return elephants;
    }

    @Override
    public Elephant getElephantById(Integer id) throws SQLException {
        List<Elephant> elephants = getAllElephants();
        Elephant elephant = null;
        for (Elephant e : elephants) {
            if (e.getId().equals(id)){
                elephant = e;
            }
        }
        return elephant;
    }

    @Override
    public Elephant getElephantByName(String name) throws SQLException {
        List<Elephant> elephants = getAllElephants();
        Elephant elephant = null;
        for (Elephant e : elephants) {
            if (e.getName().equalsIgnoreCase(name)) {
                elephant = e;
            }
        }
        return elephant;
    }

    @Override
    public int updateElephant(Elephant elephant) throws SQLException {
        String updateQuery = "UPDATE elephant SET age = ?, weight = ? WHERE id = ?";

        int result = -1;

        if (getElephantById(elephant.getId()) != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, elephant.getAge());
                preparedStatement.setDouble(2, elephant.getWeight());
                preparedStatement.setInt(3, elephant.getId());
                preparedStatement.executeUpdate();
            }
            result = 1;
        }
        return result;
    }

    @Override
    public int deleteElephant(Integer id) throws SQLException {
        String deleteQuery = "DELETE elephant FROM animals.elephant WHERE id = ?";

        int result = -1;

        if (getElephantById(id) != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
            result = 1;
        }
        return result;
    }

    @Override
    public int insertElephant(Elephant elephant) throws SQLException {
        String insertQuery = "INSERT INTO animals.elephant(id, age, name, weight) VALUE (?,?,?,?)";

        int result = -1;

        if (getElephantById(elephant.getId()) == null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, elephant.getId());
                preparedStatement.setInt(2,elephant.getAge());
                preparedStatement.setString(3,elephant.getName());
                preparedStatement.setDouble(4, elephant.getWeight());
                preparedStatement.executeUpdate();
            }
            result = 1;
        }
        return result;
    }
}
