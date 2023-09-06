package com.example.baithimodul3.model;

public class Classroom {
    private int class_id;
    private  String name;

    public Classroom() {
    }

    public Classroom(String name) {
        this.name = name;
    }

    public Classroom(int class_id, String name) {
        this.class_id = class_id;
        this.name = name;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
