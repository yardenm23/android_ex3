package com.example.androidex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidex2.model.Model;
import com.example.androidex2.model.Student;

import java.util.List;

public class UpdateStudentActivity extends AppCompatActivity {
    List<Student> studentsList;
    Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);
        Bundle extras = getIntent().getExtras();
        String studentId="", studentName="", studentPhone="", studentAddress="", studentCheckBox="";
        if (extras != null) {
            studentId = extras.getString("id");
            studentName = extras.getString("name");
            studentPhone = extras.getString("phone");
            studentAddress = extras.getString("address");
            studentCheckBox = extras.getString("checkBox");
            Log.d("TAG", "id: "+studentId +" name: "+studentName+" studentPhone " + studentPhone+" studentAddress "+studentAddress+" studentCheckBox "+studentCheckBox);
        }
        model = Model.instance();
        studentsList = Model.instance().getAllStudent();
        EditText nameInput = findViewById(R.id.editstudent_name_input);
        EditText idInput = findViewById(R.id.editstudent_id_input);
        EditText phoneInput = findViewById(R.id.editstudent_phone_input);
        EditText addressInput = findViewById(R.id.editstudent_address_input);
        CheckBox checkBox = findViewById(R.id.editstudent_checkbox);
        TextView errorTv = findViewById(R.id.editstudent_error_tv);

        idInput.setText(studentId);
        nameInput.setText(studentName);
        phoneInput.setText(studentPhone);
        addressInput.setText(studentAddress);
        if(studentCheckBox.equals("true")){
            checkBox.setChecked(true);
        }

        Button editStudentSaveBtn = findViewById(R.id.editstudent_save_btn);
        String finalStudentId = studentId;
        editStudentSaveBtn.setOnClickListener(view -> {

            String nameInputVal = String.valueOf(nameInput.getText());
            String idInputVal = String.valueOf(idInput.getText());
            String phoneInputVal = String.valueOf(phoneInput.getText());
            String addressInputVal = String.valueOf(addressInput.getText());
            Boolean checkBoxVal = checkBox.isChecked();
            int editResult = model.editStudent(finalStudentId, new Student(nameInputVal, idInputVal,"",phoneInputVal,addressInputVal, checkBoxVal, "2021"));
            if(editResult == -1){
                errorTv.setText("Id already exist");
            }
            else if(editResult==0){
                errorTv.setText("Couldn't find the id");
            }
//            else{
//                Intent intentRecList = new Intent(this, StudentRecList.class);
//                intentRecList.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intentRecList);
//            }
        });
        Button editStudentDeleteBtn = findViewById(R.id.editstudent_delete_btn);
        editStudentDeleteBtn.setOnClickListener(view->{
            String nameInputVal = String.valueOf(nameInput.getText());
            String idInputVal = String.valueOf(idInput.getText());
            String phoneInputVal = String.valueOf(phoneInput.getText());
            String addressInputVal = String.valueOf(addressInput.getText());
            Boolean checkBoxVal = checkBox.isChecked();
            boolean isDeleted = model.deleteStudent(new Student(nameInputVal, idInputVal,"", phoneInputVal, addressInputVal, checkBoxVal, "2022"));
            if(!isDeleted)
                errorTv.setText("Student not found");
//            else{
//                Intent intentRecList = new Intent(this, StudentRecList.class);
//                intentRecList.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intentRecList);
//            }

        });
        Button editStudentCancelBtn = findViewById(R.id.editstudent_cancel_btn);
        editStudentCancelBtn.setOnClickListener(view -> {
            finish();
        });
    }
}