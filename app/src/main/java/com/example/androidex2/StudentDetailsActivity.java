package com.example.androidex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

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
        String stdCb = intent.getStringExtra("CheckBox");

        stdName.setFocusable(false);
        stdId.setFocusable(false);
        stdPhone.setFocusable(false);
        stdAddress.setFocusable(false);
        cBox.setEnabled(false);


        stdName.setText(stdNameVal);
        stdId.setText(stdIdVal);
        stdPhone.setText(stdPhoneVal);
        stdAddress.setText(stdAddressVal);
        if(stdCb.equals("true")){
            cBox.setChecked(true);
        }


        Button studentDetailsEditBtn = findViewById(R.id.studentdetails_edit_btn);
        studentDetailsEditBtn.setOnClickListener(view -> {
            String id= String.valueOf(stdId.getText());
            String name = String.valueOf(stdName.getText());
            String phone = String.valueOf(stdPhone.getText());
            String address = String.valueOf(stdAddress.getText());
            String checkBox = "";
            if(cBox.isChecked())
                checkBox = "true";
            else
                checkBox = "false";
            Intent intentEdit = new Intent(this, UpdateStudentActivity.class);
            intentEdit.putExtra("id",id);
            intentEdit.putExtra("name", name);
            intentEdit.putExtra("phone", phone);
            intentEdit.putExtra("address", address);
            intentEdit.putExtra("checkBox", checkBox);

            startActivity(intentEdit);
        });

    }
}