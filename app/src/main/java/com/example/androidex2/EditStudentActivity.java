package com.example.androidex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.androidex2.model.Model;
import com.example.androidex2.model.Student;

import java.util.List;

public class EditStudentActivity extends AppCompatActivity {
    List<Student> studentsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        studentsList = Model.instance().getAllStudent();

        Button editStudentSaveBtn = findViewById(R.id.editstudent_save_btn);
        editStudentSaveBtn.setOnClickListener(view -> {

        });

        Button editStudentCancelBtn = findViewById(R.id.editstudent_cancel_btn);
        editStudentCancelBtn.setOnClickListener(view -> {
            finish();
        });
    }
}