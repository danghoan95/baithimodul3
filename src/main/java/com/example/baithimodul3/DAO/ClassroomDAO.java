package com.example.baithimodul3.DAO;

import com.example.baithimodul3.Connection.MyConnection;
import com.example.baithimodul3.model.Classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDAO {
    private final Connection connection;
    private MyConnection myConnection = new MyConnection();
    private final String SELECT_ALL = "select* from class1;";
    private final String SELECT_BY_ID = "select*from class1 where class_id=?;";
    private final String INSERT_INTO = "insert into class1 (name) value (?);";
    private final String UPDATE_SET = "update class1 set name =?  where class_id=?; ";
    private final String DELETE = "delete from class1 where class_id=?;";
    public ClassroomDAO() {
        connection = myConnection.getConnection();
    }
    public List<Classroom> findAll() {
        List<Classroom> classrooms = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int class_id = resultSet.getInt("class_id");
                String name = resultSet.getString("name");
                classrooms.add(new Classroom(class_id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classrooms;
    }

    public Classroom findone(int id) {
        Classroom classroom = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int class_id = resultSet.getInt("class_id");
                String name = resultSet.getString("name");
                classroom = new Classroom(class_id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classroom;
    }

    public void create(Classroom classroom) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setString(1, classroom.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Classroom classroom) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SET)) {
            preparedStatement.setString(1, classroom.getName());
            preparedStatement.setInt(2, classroom.getClass_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
