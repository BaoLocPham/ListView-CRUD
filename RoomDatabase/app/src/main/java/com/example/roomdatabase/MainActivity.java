package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText typeOfAnimal;
    EditText nameOfAnimal;
    Button addBtn;
    Button showBtn;
    RecyclerView recyclerView;
    RecylerAdapter recylerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();

        AppDatabase appDatabase = AppDatabase.getDBInstance(getApplicationContext());
        recylerAdapter = new RecylerAdapter(appDatabase.animalDAO().getAll());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recylerAdapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = typeOfAnimal.getText().toString();
                String name = nameOfAnimal.getText().toString();

                appDatabase.animalDAO().insertAll(new Animal(type, name));

                recylerAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this,
                        "Total Animals: " + appDatabase.animalDAO().getAll().size(),
                        Toast.LENGTH_LONG).show();
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }

    private void initializeView(){
        typeOfAnimal = findViewById(R.id.editTextType);
        nameOfAnimal = findViewById(R.id.editTextName);

        addBtn = findViewById(R.id.btnAddAnimal);
        showBtn = findViewById(R.id.btnShowAnimal);
        recyclerView = findViewById(R.id.recyle_view);
    }
}