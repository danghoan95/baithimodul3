package com.example.baithimodul3.service;

import com.example.baithimodul3.DAO.StudentDAO;
import com.example.baithimodul3.model.Student;

import java.util.List;

public class StudentService {
    private  final StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }


    public List<Student> findAll() {
        return studentDAO.findAll();
    }


    public Student findOne(int id) {
        return studentDAO.findone(id);
    }


    public void create(Student student) {
        studentDAO.create(student);
    }


    public void update(Student student) {
        Student student1 = findOne(student.getId());
        if(student1 !=null){
            studentDAO.update(student);
        }
    }


    public void delete(int id) {
        Student student =findOne(id);
        if(student != null){
            studentDAO.delete(id);

        }

    }
    public  List<Student> searchName(String name){
        return studentDAO.search(name);
    }

}
