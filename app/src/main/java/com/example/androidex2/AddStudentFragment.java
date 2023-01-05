package com.example.androidex2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidex2.databinding.FragmentAddStudentBinding;
import com.example.androidex2.model.Model;
import com.example.androidex2.model.Student;

public class
AddStudentFragment extends Fragment {
    Model model;
    FragmentAddStudentBinding binding;

    int d = 1;
    int m = 0;
    int y = 2023;
    int ho = 0;
    int mi = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //View view1 =  inflater.inflate(R.layout.fragment_add_student, container, false);
        binding = FragmentAddStudentBinding.inflate(inflater, container, false);


        super.onCreate(savedInstanceState);

        model = Model.instance();

        Button addStudentSaveBtn = binding.addstudentSaveBtn;
        addStudentSaveBtn.setOnClickListener(view -> {
            EditText nameInput = binding.addstudentNameInput;
            EditText idInput = binding.addstudentIdInput;
            EditText phoneInput = binding.addstudentPhoneInput;
            EditText addressInput = binding.addstudentAddressInput;
            CheckBox checkBoxStatus = binding.addstudentCheckbox;
            TextView errorTv = binding.addstudentErrorTv;
            TextView yearTv = binding.dateInputEt;


            String nameInputVal = String.valueOf(nameInput.getText());
            String idInputVal = String.valueOf(idInput.getText());
            String phoneInputVal = String.valueOf(phoneInput.getText());
            String addressInputVal = String.valueOf(addressInput.getText());
            Boolean checkBoxVal = checkBoxStatus.isChecked();
            String yearVal = String.valueOf(yearTv.getText());

            boolean is_student_added = false;
            is_student_added = model.addStudent(new Student(nameInputVal, idInputVal, "",phoneInputVal,addressInputVal, checkBoxVal, yearVal));
            if(!is_student_added){
                errorTv.setText("Id is already exist");
            }
            else{
                new AlertDialogFragment().show(getActivity().getSupportFragmentManager(), "TAG");
                getFragmentManager().popBackStackImmediate();

            }
        });

        Button addStudentCancelBtn = binding.cancelAddStudentButton;
        addStudentCancelBtn.setOnClickListener(view -> {
            getFragmentManager().popBackStackImmediate();
        });
        setHasOptionsMenu(true);

        binding.dateInputEt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent1) {
                if (motionEvent1.getAction() == MotionEvent.ACTION_DOWN){
                    Dialog dialog1 = new DatePickerDialog(getContext(),(datePicker, yy, mm, dd)->{
                        y = yy;
                        m = mm;
                        d = dd;
                        setDate();
                    },y,m,d);
                    dialog1.show();
                    return true;
                }
                return false;
            }
        });

//        binding.timeInputEt.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent2) {
//                if (motionEvent2.getAction() == MotionEvent.ACTION_DOWN){
//                    Dialog dialog2 = new TimePickerDialog(getContext(),(timePicker, input_hour, input_min) ->{
//                        ho = input_hour;
//                        mi = input_min;
//                        setTime();
//                    },ho, mi);
//                    dialog2.show();
//                    return true;
//                }
//                return false;
//            }
//        });

        return binding.getRoot();
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuItem item = menu.findItem(R.id.main_menu_add);
        item.setVisible(false);

    }

    void setDate() {
        binding.dateInputEt.setText("" + d + "/" + (m) + "/" + y);
    }

    void setTime(){
        binding.timeInputEt.setText("" + ho + " : " + mi);

    }

}