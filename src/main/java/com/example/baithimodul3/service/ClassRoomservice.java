package com.example.baithimodul3.service;

import com.example.baithimodul3.DAO.ClassroomDAO;
import com.example.baithimodul3.model.Classroom;

import java.util.List;

public class ClassRoomservice {
    private ClassroomDAO classroomDAO;
    Classroom classroom;


    public ClassRoomservice() {
        classroomDAO = new ClassroomDAO();
        classroom =new Classroom();
    }


    public List<Classroom> findAll() {
        return classroomDAO.findAll();
    }


    public Classroom findOne(int id) {
        return classroomDAO.findone(id);
    }

    public void create(Classroom classroom) {
        classroomDAO.create(classroom);
    }


    public void update(Classroom classroom) {
        Classroom classroom1= findOne(classroom.getClass_id());
        if(classroom1 !=null){
            classroomDAO.update(classroom);
        }
    }


    public void delete(int id) {
        Classroom classroom1 =findOne(id);
        if(classroom1 != null){
            classroomDAO.delete(id);
        }
    }
}
