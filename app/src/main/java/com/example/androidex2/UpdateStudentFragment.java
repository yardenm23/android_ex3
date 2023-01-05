package com.example.androidex2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.androidex2.model.Model;

public class UpdateStudentFragment extends Fragment {
    Model model;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_student_details, container, false);

        String stdNameVal= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentName();
        String stdIdVal= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentId();
        String stdPhoneVal= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentPhone();
        String stdAddressVal= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentAddress();
        String stdCb= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentId();


        //super.onCreate(savedInstanceState);
        //view1.setContentView(R.layout.fragment_student_details);
        //studentsList = Model.instance().getAllStudent();
        model = Model.instance();


        EditText stdName = view1.findViewById(R.id.studentdetails_std_name);
        EditText stdId = view1.findViewById(R.id.studentdetails_std_id);
        EditText stdPhone = view1.findViewById(R.id.studentdetails_std_phone);
        EditText stdAddress = view1.findViewById(R.id.studentdetails_std_address);
        CheckBox cBox = view1.findViewById(R.id.studentdetails_cb);



        //stdName.setFocusable(true);
//        stdId.setFocusable(false);
//        stdPhone.setFocusable(false);
//        stdAddress.setFocusable(false);
//        cBox.setEnabled(false);


        stdName.setText(stdNameVal);
        stdId.setText(stdIdVal);
        stdPhone.setText(stdPhoneVal);
        stdAddress.setText(stdAddressVal);
        if(stdCb.equals("true")){
            cBox.setChecked(true);
//        }


//        Button studentDetailsEditBtn = view1.findViewById(R.id.studentdetails_edit_btn);
            //studentDetailsEditBtn.setOnClickListener(view -> {
//            String id= String.valueOf(stdId.getText());
            //String name = String.valueOf(stdName.getText());
//            String phone = String.valueOf(stdPhone.getText());
//            String address = String.valueOf(stdAddress.getText());
            //String checkBox = "";
//            if(cBox.isChecked())
//                checkBox = "true";
//            else
//                checkBox = "false";
//            Intent intentEdit = new Intent(this, StudentListFragment.class);
//            intentEdit.putExtra("id",id);
//            intentEdit.putExtra("name", name);
//            intentEdit.putExtra("phone", phone);
//            intentEdit.putExtra("address", address);
//            intentEdit.putExtra("checkBox", checkBox);

            //}
            //);
            //return view1;
        }return view1;
    }
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        MenuItem item = menu.findItem(R.id.update_student);
//        item.setVisible(true);
//
//    }

}