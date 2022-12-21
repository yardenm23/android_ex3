package com.example.androidex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidex2.model.Model;
import com.example.androidex2.model.Student;

import java.util.List;

public class StudentDetailsActivity extends AppCompatActivity {
    List<Student> studentsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        studentsList = Model.instance().getAllStudent();

        Button studentDetailsEditBtn = findViewById(R.id.studentdetails_edit_btn);
        studentDetailsEditBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, EditStudentActivity.class);
            startActivity(intent);
        });

        EditText stdName = findViewById(R.id.studentdetails_std_name);
        EditText stdId = findViewById(R.id.studentdetails_std_id);
        EditText stdPhone = findViewById(R.id.studentdetails_std_phone);
        EditText stdAddress = findViewById(R.id.studentdetails_std_address);
        CheckBox cBox = findViewById(R.id.studentdetails_cb);


        Intent intent = getIntent();
        String stdNameVal = intent.getStringExtra("Name");
        String stdIdVal = intent.getStringExtra("ID");
        String stdPhoneVal = intent.getStringExtra("Phone");
        String stdAddressVal = intent.getStringExtra("Address");

        stdName.setText(stdNameVal);
        stdId.setText(stdIdVal);
        stdPhone.setText(stdPhoneVal);
        stdAddress.setText(stdAddressVal);

    }
}