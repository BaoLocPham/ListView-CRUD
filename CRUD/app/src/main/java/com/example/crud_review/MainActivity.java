package com.example.crud_review;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editTeacherName;
    EditText editTeacherEmail;
    Button   btnAddTeacher;
    Button   btnShowTeacher;
    ListView listViewTeacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewTeacher = findViewById(R.id.listViewTeacher);
        editTeacherName  = findViewById(R.id.editTextName);
        editTeacherEmail = findViewById(R.id.editTextEmail);
        btnAddTeacher = findViewById(R.id.btnAddTeacher);

        btnAddTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teacherName = editTeacherName.getText().toString();
                String teacherEmail = editTeacherEmail.getText().toString();

                Teacher teacher = new Teacher(teacherName, teacherEmail);

                TeacherDatabase teacherDatabase = new TeacherDatabase(MainActivity.this,
                                                                "teacherDB",null,1);
                teacherDatabase.addTeacher(teacher);
            }
        });

        btnShowTeacher = findViewById(R.id.btnShowTeacher);
        btnShowTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TeacherDatabase teacherDatabase = new TeacherDatabase(MainActivity.this,
                        "teacherDB",null,1);
                List<Teacher> teacherList = teacherDatabase.findAll();

                ArrayAdapter<Teacher> teacherArrayAdapter = new ArrayAdapter<Teacher>(MainActivity.this,
                        R.layout.support_simple_spinner_dropdown_item, teacherList);

                listViewTeacher.setAdapter(teacherArrayAdapter);
            }
        });

    }
}