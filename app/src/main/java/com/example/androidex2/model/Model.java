package com.example.androidex2.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    public static Model instance() {
        return _instance;
    }

    private Model() {
        addStudent(new Student("Moshe", "12340", "", "052-8459635","Hertzel 24, Tel Aviv",false));
        addStudent(new Student("Dani", "12341", "", "050-1648032","Hosen 8, Rehovot",false));
        addStudent(new Student("Yossi", "12342", "", "050-3574105","Oren 19, Haifa",false));
        addStudent(new Student("Alice", "12343", "", "052-8842367","Nov 12, Rishon LeZion",false));
        addStudent(new Student("Bob", "12344", "", "054-9032247","Hillel 22, Jerusalem",false));
        addStudent(new Student("Charlie", "12345", "", "052-7836641","Gordon 11, Netanya",false));
        addStudent(new Student("David", "12346", "", "050-1165493","Allenby 10, Tel Aviv",false));
        addStudent(new Student("Foo", "12347", "", "054-7785319","HaGefen 5, Haifa",false));
        addStudent(new Student("Bar", "12348", "", "052-7316055","Bialik 7, Holon",false));
        addStudent(new Student("Baz", "12349", "", "053-8499256","Keshet 23, Rishon LeZion",false));
        addStudent(new Student("Lidor", "12350", "", "050-3345191","Rotchild 32, Tel Aviv",false));
        addStudent(new Student("Ofir", "12351", "", "052-2625431","Sokolov 6, Holon",false));
        addStudent(new Student("Yuval", "12352", "", "054-8824040","Horesh 17, Rehovot",false));
        addStudent(new Student("Yahav", "12353", "", "050-8206459","HaGolan 3, Netanya",false));
        addStudent(new Student("Niv", "12354", "", "053-74962205","Bograshov 15, Tel Aviv",false));
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
