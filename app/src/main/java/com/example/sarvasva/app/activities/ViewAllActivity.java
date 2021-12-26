package com.example.sarvasva.app.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sarvasva.R;
import com.example.sarvasva.app.Classes.ViewAllAdaptor;
import com.example.sarvasva.app.Classes.ViewAllModel;

import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    public  static List<ViewAllModel> viewAllActivityList;
    private RecyclerView recyclerView;
    private  String layoutTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        recyclerView = findViewById(R.id.viewAllRv);

        layoutTitle =getIntent().getStringExtra("layout_title");



        getSupportActionBar().setTitle(layoutTitle);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);


        ViewAllAdaptor adaptor = new ViewAllAdaptor(viewAllActivityList);
        recyclerView.setAdapter(adaptor);
        adaptor.notifyDataSetChanged();




    }
}