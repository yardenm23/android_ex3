package com.example.androidex2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.androidex2.databinding.FragmentStudentDetailsBinding;
import com.example.androidex2.model.Model;

public class StudentDetailsFragment extends Fragment {
    Model model;
    FragmentStudentDetailsBinding binding;

//    int d = 1;
//    int m = 0;
//    int y = 2023;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View view1 = inflater.inflate(R.layout.fragment_student_details, container, false);
        binding = FragmentStudentDetailsBinding.inflate(inflater, container, false);

        String stdNameVal= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentName();
        String stdIdVal= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentId();
        String stdPhoneVal= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentPhone();
        String stdAddressVal= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentAddress();
        String stdCb= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentId();
        String stdBirthdateVal = StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentBirthdate();

        model = Model.instance();

        EditText stdName = binding.studentdetailsStdName;
        EditText stdId = binding.studentdetailsStdId;
        EditText stdPhone =binding.studentdetailsStdPhone;
        EditText stdAddress = binding.studentdetailsStdAddress;
        CheckBox cBox = binding.studentdetailsCb;
        EditText stdBirthdate = binding.studentBirthdate;

        stdName.setText(stdNameVal);
        stdId.setText(stdIdVal);
        stdPhone.setText(stdPhoneVal);
        stdAddress.setText(stdAddressVal);
        stdBirthdate.setText(stdBirthdateVal);
        if(stdCb.equals("true")) {
            cBox.setChecked(true);
        }


    return binding.getRoot();
}
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuItem item = menu.findItem(R.id.update_student);
        item.setVisible(true);

    }


}