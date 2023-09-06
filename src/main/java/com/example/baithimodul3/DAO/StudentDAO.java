package com.example.baithimodul3.DAO;

import com.example.baithimodul3.Connection.MyConnection;
import com.example.baithimodul3.model.Classroom;
import com.example.baithimodul3.model.Student;
import com.example.baithimodul3.service.ClassRoomservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private final Connection connection;
    private MyConnection myConnection = new MyConnection();
     ClassRoomservice classRoomservice;
    private final String SELECT_ALL = "select* from student1;";
    private final String SELECT_BY_ID = "select*from student1 where id=?;";
    private final String INSERT_INTO = "insert into student1 (name,email,date, address,phone,class_id) value (?,?,?,?,?,?);";
    private final String UPDATE_SET = "update student1 set name =? , email =?, date =?,address =?,phone =?, class_id =? where id=?; ";
    private  final  String DELETE = "delete from student1 where id=?;";
    private  final  String SEARCH_NAME = "select *from student1 where name LIKE ?;";
    public StudentDAO() {
        this.connection = myConnection.getConnection();
        classRoomservice =new ClassRoomservice();
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                LocalDate date = resultSet.getObject("date", LocalDate.class);
                String address = resultSet.getString("address");
                double phone = resultSet.getDouble("phone");
                int class_id =resultSet.getInt("class_id");
                students.add(new Student(id, name, email, date, address,phone,classRoomservice.findOne(class_id)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student findone(int id) {
        Student student = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDB = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                LocalDate date = resultSet.getObject("date", LocalDate.class);
                String address = resultSet.getString("address");
                double phone = resultSet.getDouble("phone");
                int class_id=resultSet.getInt("class_id");
                student = new Student(idDB, name, email, date, address,phone,classRoomservice.findOne(class_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void create(Student student) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getDate().toString());
            preparedStatement.setString(4,student.getAddress());
            preparedStatement.setDouble(5,student.getPhone());
            preparedStatement.setInt(6,student.getClassroom().getClass_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        try(PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_SET)){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setString(3,student.getDate().toString());
            preparedStatement.setString(4,student.getAddress());
            preparedStatement.setDouble(5,student.getPhone());
            preparedStatement.setInt(6,student.getClassroom().getClass_id());
            preparedStatement.setInt(7,student.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public  void  delete(int id){
        try (PreparedStatement preparedStatement =connection.prepareStatement(DELETE)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public  List <Student>search( String name){
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME)) {
            preparedStatement.setString(1,"%" + name +"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String email = resultSet.getString("email");
                LocalDate date = resultSet.getObject("date", LocalDate.class);
                String address = resultSet.getString("address");
                double phone = resultSet.getDouble("phone");
                int class_id=resultSet.getInt("class_id");
                students.add(new Student(id, name1, email, date, address,phone,classRoomservice.findOne(class_id)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
