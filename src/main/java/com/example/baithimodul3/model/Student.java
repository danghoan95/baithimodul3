package com.example.baithimodul3.model;

import java.time.LocalDate;

public class Student {
    private  int id ;
    private  String name;
    private  String email;
    private LocalDate date;
    private  String address ;
    private  double phone;
    private  Classroom classroom ;

    public Student() {
    }

    public Student(String name, String email, LocalDate date, String address, double phone, Classroom classroom) {
        this.name = name;
        this.email = email;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.classroom = classroom;
    }

    public Student(int id, String name, String email, LocalDate date, String address, double phone, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
