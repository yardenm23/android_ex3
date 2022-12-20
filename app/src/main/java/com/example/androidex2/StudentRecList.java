package com.example.androidex2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.androidex2.model.Model;
import com.example.androidex2.model.Student;

import java.util.List;

public class StudentRecList extends AppCompatActivity {
    List<Student> studentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_rec_list); //load the activity

        Button addStudentBtn = findViewById(R.id.studentreclist_add_student_btn);
        addStudentBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddStudentActivity.class);
            startActivity(intent);
        });


        studentsList = Model.instance().getAllStudent();
        RecyclerView recyclerList = findViewById(R.id.studentrec_list);
        recyclerList.setHasFixedSize(true);

        recyclerList.setLayoutManager(new LinearLayoutManager(this));
        StudentRecAdapter adapter = new StudentRecAdapter();
        recyclerList.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) { // what happend in click on row ( in click move to details page)

            }
        });
    }

    class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;
        TextView idTextView;
        CheckBox checkBox;
        public StudentViewHolder(@NonNull View itemView, OnItemClickListener listener) {
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
    class StudentRecAdapter extends RecyclerView.Adapter<StudentViewHolder>{
        OnItemClickListener listener;
        void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }
        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // create view of row
            View view = getLayoutInflater().inflate(R.layout.student_list_row,parent,false);
            return  new StudentViewHolder(view,listener);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) { // connect between data and row
            Student student = studentsList.get(position);
            holder.bind(student,position);
        }

        @Override
        public int getItemCount() { // how many rows in list
            return studentsList.size();
        }
    }
}