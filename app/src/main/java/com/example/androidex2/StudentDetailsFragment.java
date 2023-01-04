package com.example.androidex2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.androidex2.model.Model;

public class StudentDetailsFragment extends Fragment {
    Model model;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1 = inflater.inflate(R.layout.fragment_student_details, container, false);
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.fragment_student_details);
        //studentsList = Model.instance().getAllStudent();
        model = Model.instance();


        EditText stdName = view1.findViewById(R.id.studentdetails_std_name);
        EditText stdId = view1.findViewById(R.id.studentdetails_std_id);
        EditText stdPhone = view1.findViewById(R.id.studentdetails_std_phone);
        EditText stdAddress = view1.findViewById(R.id.studentdetails_std_address);
        CheckBox cBox = view1.findViewById(R.id.studentdetails_cb);

//        Intent intent = getIntent();
//        String stdNameVal = intent.getStringExtra("Name");
//        String stdIdVal = intent.getStringExtra("ID");
//        String stdPhoneVal = intent.getStringExtra("Phone");
//        String stdAddressVal = intent.getStringExtra("Address");
//        String stdCb = intent.getStringExtra("CheckBox");

        stdName.setFocusable(false);
        stdId.setFocusable(false);
        stdPhone.setFocusable(false);
        stdAddress.setFocusable(false);
        cBox.setEnabled(false);


//        stdName.setText(stdNameVal);
//        stdId.setText(stdIdVal);
//        stdPhone.setText(stdPhoneVal);
//        stdAddress.setText(stdAddressVal);
//        if(stdCb.equals("true")){
//            cBox.setChecked(true);
//        }


        Button studentDetailsEditBtn = view1.findViewById(R.id.studentdetails_edit_btn);
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
//            Intent intentEdit = new Intent(this, StudentListFragment.class);
//            intentEdit.putExtra("id",id);
//            intentEdit.putExtra("name", name);
//            intentEdit.putExtra("phone", phone);
//            intentEdit.putExtra("address", address);
//            intentEdit.putExtra("checkBox", checkBox);

//            startActivity(intentEdit);
        });
        return view1;
    }
}