package com.example.androidex2;

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

        View view1 =  inflater.inflate(R.layout.fragment_add_student, container, false);

        super.onCreate(savedInstanceState);

        model = Model.instance();

        Button addStudentSaveBtn = view1.findViewById(R.id.addstudent_save_btn);
        addStudentSaveBtn.setOnClickListener(view -> {
            EditText nameInput = view1.findViewById(R.id.addstudent_name_input);
            EditText idInput = view1.findViewById(R.id.addstudent_id_input);
            EditText phoneInput = view1.findViewById(R.id.addstudent_phone_input);
            EditText addressInput = view1.findViewById(R.id.addstudent_address_input);
            CheckBox checkBoxStatus = view1.findViewById(R.id.addstudent_checkbox);
            TextView errorTv = view1.findViewById(R.id.addstudent_error_tv);

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
                getFragmentManager().popBackStackImmediate();



            }
        });

        Button addStudentCancelBtn = view1.findViewById(R.id.cancel_add_student_button);
        addStudentCancelBtn.setOnClickListener(view -> {
            getFragmentManager().popBackStackImmediate();
        });
        setHasOptionsMenu(true);
        return view1;
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuItem item = menu.findItem(R.id.main_menu_add);
        item.setVisible(false);

    }

}