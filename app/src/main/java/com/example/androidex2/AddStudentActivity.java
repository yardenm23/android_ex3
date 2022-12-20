package com.example.androidex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidex2.model.Model;
import com.example.androidex2.model.Student;

import java.util.List;

public class AddStudentActivity extends AppCompatActivity {
    Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        model = Model.instance();

        Button addStudentSaveBtn = findViewById(R.id.addstudent_save_btn);
        addStudentSaveBtn.setOnClickListener(view -> {

            EditText nameInput = findViewById(R.id.addstudent_name_input);
            EditText idInput = findViewById(R.id.addstudent_id_input);
            EditText phoneInput = findViewById(R.id.addstudent_phone_input);
            EditText addressInput = findViewById(R.id.addstudent_address_input);
            CheckBox checkBox = findViewById(R.id.addstudent_checkbox);
            TextView errorTv = findViewById(R.id.addstudent_error_tv);

            String nameInputVal = String.valueOf(nameInput.getText());
            String idInputVal = String.valueOf(idInput.getText());
            String phoneInputVal = String.valueOf(phoneInput.getText());
            String addressInputVal = String.valueOf(addressInput.getText());
            Boolean checkBoxVal = checkBox.isChecked();

            boolean studentAdded = false;
            studentAdded = model.addStudent(new Student(nameInputVal, idInputVal, "",phoneInputVal,addressInputVal, checkBoxVal));
            if(!studentAdded){
                errorTv.setText("Id is already exist");
            }
            else{
                finish();
            }
        });

        Button addStudentCancelBtn = findViewById(R.id.addstudent_cancel_btn);
        addStudentCancelBtn.setOnClickListener(view -> {
            finish();
        });
    }
}