package com.example.androidex2.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    public static Model instance() {
        return _instance;
    }

    private Model() {
        addStudent(new Student("Moshe", "12340", "", "","",false));
        addStudent(new Student("Dani", "12341", "", "","",false));
        addStudent(new Student("Yossi", "12342", "", "","",false));
        addStudent(new Student("Alice", "12343", "", "","",false));
        addStudent(new Student("Bob", "12344", "", "","",false));
        addStudent(new Student("Charlie", "12345", "", "","",false));
        addStudent(new Student("David", "12346", "", "","",false));
        addStudent(new Student("Foo", "12347", "", "","",false));
        addStudent(new Student("Bar", "12348", "", "","",false));
        addStudent(new Student("Baz", "12349", "", "","",false));
        addStudent(new Student("Lidor", "12350", "", "","",false));
        addStudent(new Student("Ofir", "12351", "", "","",false));
        addStudent(new Student("Yuval", "12352", "", "","",false));
        addStudent(new Student("Yahav", "12353", "", "","",false));
        addStudent(new Student("Niv", "12354", "", "","",false));
    }

    List<Student> data = new LinkedList<>();

    public List<Student> getAllStudent() {
        return data;
    }

    public boolean addStudent(Student std) {
        boolean isIdAlreadyExist = false;
        for (Student student : data) {
            if (student.getId().equals(std.getId())) {
                isIdAlreadyExist = true;
                break;
            }
        }
        if(!isIdAlreadyExist) {
            data.add(std);
            return true;
        }
        return false;
    }
}
