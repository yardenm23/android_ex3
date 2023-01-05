package com.example.androidex2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidex2.databinding.FragmentStudentDetailsBinding;
import com.example.androidex2.databinding.FragmentUpdateStudentBinding;
import com.example.androidex2.model.Model;
import com.example.androidex2.model.Student;

import java.util.List;

public class UpdateStudentFragment extends Fragment {
    FragmentUpdateStudentBinding binding;
    Model model;
    List<Student> studentsList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentUpdateStudentBinding.inflate(inflater, container, false);
        int st_position= UpdateStudentFragmentArgs.fromBundle(getArguments()).getStudentPosition();


        model = Model.instance();
        studentsList = Model.instance().getAllStudent();
        EditText nameInput = binding.addstudentNameInput;
        EditText idInput = binding.addstudentIdInput;
        EditText phoneInput = binding.addstudentPhoneInput;
        EditText addressInput = binding.addstudentAddressInput;
        CheckBox checkBox = binding.addstudentCheckbox;
        TextView errorTv = binding.addstudentErrorTv;
        TextView birthdateInput = binding.dateInputEt;
        TextView birthtimeInput = binding.timeInputEt;



        Student student = studentsList.get(st_position);

        idInput.setText(student.getId());
        nameInput.setText(student.getName());
        phoneInput.setText(student.getPhone());
        addressInput.setText(student.getAddress());
        if(student.getCheckBox().equals("true")){
            checkBox.setChecked(true);
        }
        birthdateInput.setText(student.getBirthDate());
        birthtimeInput.setText(student.getBirthTime());


        Button editStudentSaveBtn = binding.addstudentSaveBtn;
        String finalStudentId = student.getId();
        editStudentSaveBtn.setOnClickListener(view -> {

            String nameInputVal = String.valueOf(nameInput.getText());
            String idInputVal = String.valueOf(idInput.getText());
            String phoneInputVal = String.valueOf(phoneInput.getText());
            String addressInputVal = String.valueOf(addressInput.getText());
            String dateInputVal = String.valueOf(birthdateInput.getText());
            String timeInputVal = String.valueOf(birthtimeInput.getText());

            Boolean checkBoxVal = checkBox.isChecked();
            int editResult = model.editStudent(finalStudentId, new Student(nameInputVal, idInputVal,"",phoneInputVal,addressInputVal, checkBoxVal, dateInputVal, timeInputVal));
            if(editResult == -1){
                errorTv.setText("Id already exist");
            }
            else if(editResult==0){
                errorTv.setText("Couldn't find the id");
            }
            else{
                new AlertDialogFragment().show(getActivity().getSupportFragmentManager(), "TAG");
                Navigation.findNavController(view).navigate(R.id.action_global_studentListFragment);

            }
        });

        Button editStudentCancelBtn = binding.cancelAddStudentButton;
        editStudentCancelBtn.setOnClickListener(view -> {
            getFragmentManager().popBackStackImmediate();
        });
        return binding.getRoot();

    }

}