package com.example.androidex2.model;
import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    public static Model instance(){
        return _instance;
    }
    private Model(){
        for(int i=0;i<20;i++){
            addStudent(new Student("name" + i," " + i,"",false));
        }
    }
    List<Student> data = new LinkedList<>();
    public List<Student> getAllStudent(){
        return data;
    }
    public void addStudent(Student std){
        data.add(std);
    }
}
