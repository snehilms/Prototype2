package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.prototype.courseRecylerAdapter.UpdateCompareList;

public class comparecourse extends AppCompatActivity {
        RecyclerView comparerecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparecourse);
        comparerecyclerview= findViewById(R.id.comparerecycler);
        compareAdapter compareAdapterList = new compareAdapter(UpdateCompareList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        comparerecyclerview.setLayoutManager(linearLayoutManager);
        comparerecyclerview.setAdapter(compareAdapterList);
        ImageButton addMore = findViewById(R.id.addMore);
        addMore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), courseDetails.class);
                startActivity(intent);

            }
        });



    }
}