package com.example.androidex2.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    public static Model instance() {
        return _instance;
    }

    private Model() {
        addStudent(new Student("Paul", "111111111", "", "0511111","Hakishon 12",false, "2025", "10:23"));
        addStudent(new Student("Taylor", "222222222", "", "05022222","Arlozorov 39",false, "2020", "11:43"));
        addStudent(new Student("Dolly", "333333333", "", "05033333","Mikve israel 4",false, "2021", "03:12"));
        addStudent(new Student("Justin", "444444444", "", "05044444","Maze 10 ",false, "2014", "08:46"));
        addStudent(new Student("Katy", "555555555", "", "05055555","Bilu 3",false, "2019", "02:14"));
        addStudent(new Student("Shown", "666666666", "", "05066666","Geva 9",false, "2019", "06:32"));
        addStudent(new Student("Harry", "777777777", "", "05077777","Mandeli 54",false, "2018", "01:45"));
        addStudent(new Student("Arthur", "88888888", "", "05088888","Kalisher 89",false, "2017", "4:37"));
        addStudent(new Student("Bob", "999999999", "", "05099999","Yehuda Halevi 72",false, "2015", "05:01"));
        addStudent(new Student("Janis", "121212121", "", "05012121","Bnei Dan 36",false, "2021", "10:44"));
        addStudent(new Student("Amy", "131313131", "", "05013131","Raynes 14",false, "2020", "07:56"));
        addStudent(new Student("Kurt", "141414141", "", "05014141","wolfson 54",false, "2019", "03:18"));
        addStudent(new Student("Jeff", "151515151", "", "05015151","Levontin 19",false, "2015", "07:40"));
        addStudent(new Student("Eric", "161616161", "", "050161616","King Geroge 119",false, "2018", "09:48"));
        addStudent(new Student("Freddie", "171717171", "", "050171717","Amos 22",false, "2017", "08:29"));


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
        if (!isIdAlreadyExist) {
            data.add(std);
            return true;
        }
        return false;
    }

    public int fidStudentIndex(Student std) {
        for (int i = 0; i < data.size(); i++) {
            Student currentStd = data.get(i);
            if (currentStd.getId().equals(std.getId())
                    && currentStd.getName().equals(std.getName())
                    && currentStd.getPhone().equals(std.getPhone())
                    && currentStd.getAddress().equals(std.getAddress())
                    && currentStd.getCheckBox() == std.getCheckBox()) {
                return i;

            }
        }
        return -1;
    }

    public boolean deleteStudent(Student std) {
       int studentIndex = fidStudentIndex(std);
       if(studentIndex==-1)
           return false;
       else{
           data.remove(studentIndex);
           return true;
       }
    }
    public int editStudent(String oldId, Student std){
        // if id is different from old id and already exist
        if(!std.getId().equals(oldId)) {
            for (Student student : data) {
                if (student.getId().equals(std.getId()))
                    return -1;
            }
        }
        int studentIndex = -1;
        for (int i=0;i<data.size();i++ ) {
            if(data.get(i).getId().equals(oldId)){
                studentIndex = i;
                break;
            }
        }
        if(studentIndex==-1)
            return 0;
        else{
            data.set(studentIndex, std);
            return 1;
        }
    }
}
