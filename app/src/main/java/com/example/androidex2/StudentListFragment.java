package com.example.androidex2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.androidex2.model.Model;
import com.example.androidex2.model.Student;

import java.util.List;


public class StudentListFragment extends Fragment {
    List<Student> studentsList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_student_list, container, false);

        studentsList = Model.instance().getAllStudent();
        RecyclerView recyclerList = view.findViewById(R.id.fragment_student_list);
        recyclerList.setHasFixedSize(true);

        recyclerList.setLayoutManager(new LinearLayoutManager(getContext()));
        StudentListFragmentAdapter adapter = new StudentListFragmentAdapter();
        recyclerList.setAdapter(adapter);

        adapter.setOnItemClickListener(new StudentListFragment.OnItemClickListener(){
            @Override
            public void onItemClick(int position) {
                Student st = studentsList.get(position);
                StudentListFragmentDirections.ActionStudentListFragmentToStudentDetailsFragment action = StudentListFragmentDirections.actionStudentListFragmentToStudentDetailsFragment(st.getName(), st.getId(), st.getPhone(), st.getAddress());

               Navigation.findNavController(view).navigate(action);
            }
        });

        return view;
    }


    class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;
        TextView idTextView;
        CheckBox checkBox;
        public



        StudentViewHolder(@NonNull View itemView, StudentListFragment.OnItemClickListener listener) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.studentlistrow_name_tv);
            idTextView = itemView.findViewById(R.id.studentlistrow_id_tv);
            checkBox = itemView.findViewById(R.id.studentlistrow_cb);
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = (int) checkBox.getTag();
                    Student student = studentsList.get(position);
                    student.setCheckBox(checkBox.isChecked());
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    listener.onItemClick(position);
                }
            });
        }

        public void bind(Student std,int position) {
            nameTextView.setText(std.getName());
            idTextView.setText(std.getId());
            checkBox.setChecked(std.getCheckBox());
            checkBox.setTag(position);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    class StudentListFragmentAdapter extends RecyclerView.Adapter<StudentListFragment.StudentViewHolder>{
        StudentListFragment.OnItemClickListener listener;
        void setOnItemClickListener(StudentListFragment.OnItemClickListener listener){
            this.listener = listener;
        }
        @NonNull
        @Override
        public StudentListFragment.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row,parent,false);
            return new StudentListFragment.StudentViewHolder(view,listener);
        }



        @Override
        public void onBindViewHolder(@NonNull StudentListFragment.StudentViewHolder holder, int position) {             Student student = studentsList.get(position);
            holder.bind(student,position);
        }

        @Override
        public int getItemCount() { // how many rows in list
            return studentsList.size();
        }
    }
}