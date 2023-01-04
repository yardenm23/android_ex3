package com.example.androidex2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidex2.model.Model;
import com.example.androidex2.model.Student;

public class
AddStudentFragment extends Fragment {
    Model model;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view1 =  inflater.inflate(R.layout.fragment_add_student, container, false);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_add_student);

        model = Model.instance();

        Button addStudentSaveBtn = view1.findViewById(R.id.addstudent_save_btn);
        addStudentSaveBtn.setOnClickListener(view -> {

            EditText nameInput = view.findViewById(R.id.addstudent_name_input);
            EditText idInput = view.findViewById(R.id.addstudent_id_input);
            EditText phoneInput = view.findViewById(R.id.addstudent_phone_input);
            EditText addressInput = view.findViewById(R.id.addstudent_address_input);
            CheckBox checkBoxStatus = view.findViewById(R.id.addstudent_checkbox);
            TextView errorTv = view.findViewById(R.id.addstudent_error_tv);

            String nameInputVal = String.valueOf(nameInput.getText());
            String idInputVal = String.valueOf(idInput.getText());
            String phoneInputVal = String.valueOf(phoneInput.getText());
            String addressInputVal = String.valueOf(addressInput.getText());
            Boolean checkBoxVal = checkBoxStatus.isChecked();

            boolean is_student_added = false;
            is_student_added = model.addStudent(new Student(nameInputVal, idInputVal, "",phoneInputVal,addressInputVal, checkBoxVal));
            if(!is_student_added){
                errorTv.setText("Id is already exist");
            }
            else{
//                Intent intentRecList = new Intent(this, StudentRecList.class);
//                intentRecList.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intentRecList);

            }
        });

//        Button addStudentCancelBtn = view1.findViewById(R.id.cancel_add_student_button);
//        addStudentCancelBtn.setOnClickListener(view -> {
//            finish();
//        });

        return view1;
    }
}