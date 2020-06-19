package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        // Added "androidx.appcompat.widget.Toolbar" instead of "Toolbar" in "activities_categories.xml"
        // The video had "Toolbar" in "activities_categories.xml" but it was causing an issue due to the different types
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        List<CategoryModel> list = new ArrayList<>();
        list.add(new CategoryModel("", "Category1"));
        list.add(new CategoryModel("", "Category1"));
        list.add(new CategoryModel("", "Category1"));
        list.add(new CategoryModel("", "Category1"));
        list.add(new CategoryModel("", "Category1"));
        list.add(new CategoryModel("", "Category1"));
        list.add(new CategoryModel("", "Category1"));
        list.add(new CategoryModel("", "Category1"));
        list.add(new CategoryModel("", "Category1"));
        list.add(new CategoryModel("", "Category1"));
        list.add(new CategoryModel("", "Category1"));
        list.add(new CategoryModel("", "Category1"));
        list.add(new CategoryModel("", "Category1"));
        list.add(new CategoryModel("", "Category1"));
        list.add(new CategoryModel("", "Category1"));


        CategoryAdapter adapter = new CategoryAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
