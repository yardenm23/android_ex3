package com.example.androidex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.androidex2.model.Model;
import com.example.androidex2.model.Student;

import java.util.List;

public class AddStudentActivity extends AppCompatActivity {
    List<Student> studentsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        studentsList = Model.instance().getAllStudent();

        Button addStudentSaveBtn = findViewById(R.id.addstudent_save_btn);
        addStudentSaveBtn.setOnClickListener(view -> {
            EditText nameInput = findViewById(R.id.addstudent_name_input);
            EditText idInput = findViewById(R.id.addstudent_id_input);
            EditText phoneInput = findViewById(R.id.addstudent_phone_input);
            EditText addressInput = findViewById(R.id.addstudent_address_input);
            CheckBox checkBox = findViewById(R.id.addstudent_checkbox);
            String idInputVal = idInput.getText().toString();
            String nameInputVal = String.valueOf(nameInput.getText());
            if( idInputVal instanceof String ) {
               Log.d("TAG", "!!!!!");
            }
            boolean idAlreadyExist = false;
            for (Student student: studentsList) {
                if (student.getId().equals(idInputVal)) {
                    idAlreadyExist = true;
                    break;
                }
            }
            Log.d("TAG", "is id already exsist? " + idAlreadyExist);
        });

        Button addStudentCancelBtn = findViewById(R.id.addstudent_cancel_btn);
        addStudentCancelBtn.setOnClickListener(view -> {
            finish();
        });
    }
}