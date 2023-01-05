package com.example.androidex2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

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

import com.example.androidex2.databinding.FragmentStudentDetailsBinding;
import com.example.androidex2.model.Model;
import com.example.androidex2.model.Student;

public class StudentDetailsFragment extends Fragment {
    Model model;
    FragmentStudentDetailsBinding binding;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentStudentDetailsBinding.inflate(inflater, container, false);

        String stdNameVal= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentName();
        String stdIdVal= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentId();
        String stdPhoneVal= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentPhone();
        String stdAddressVal= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentAddress();
        String stdCb= StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentId();
        String stdBirthdateVal = StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentBirthdate();
        String stdBirthtimeVal = StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentBirthtime();

        model = Model.instance();

        EditText stdName = binding.studentdetailsStdName;
        EditText stdId = binding.studentdetailsStdId;
        EditText stdPhone =binding.studentdetailsStdPhone;
        EditText stdAddress = binding.studentdetailsStdAddress;
        CheckBox cBox = binding.studentdetailsCb;
        EditText stdBirthdate = binding.studentBirthdate;
        EditText stdBirthtime = binding.studentBirthtime;


        stdName.setText(stdNameVal);
        stdId.setText(stdIdVal);
        stdPhone.setText(stdPhoneVal);
        stdAddress.setText(stdAddressVal);
        stdBirthdate.setText(stdBirthdateVal);
        stdBirthtime.setText(stdBirthtimeVal);
        if(stdCb.equals("true")) {
            cBox.setChecked(true);
        }


        Button studentDetailsEditBtn = binding.studentdetailsEditBtn;
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

            Bundle bundle = new Bundle();
            bundle.putString("student_id", "123");
            Navigation.findNavController(view).navigate(R.id.action_global_studentListFragment, bundle);

//            Intent intentEdit = new Intent(this, EditStudentActivity.class);
//            intentEdit.putExtra("id",id);
//            intentEdit.putExtra("name", name);
//            intentEdit.putExtra("phone", phone);
//            intentEdit.putExtra("address", address);
//            intentEdit.putExtra("checkBox", checkBox);
//
//            startActivity(intentEdit);
        });


    return binding.getRoot();
}
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuItem item = menu.findItem(R.id.update_student);
        item.setVisible(true);

    }


}