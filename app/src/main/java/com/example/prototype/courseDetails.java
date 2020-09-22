package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class courseDetails extends AppCompatActivity {

    List<courseHelperClass> allCourse;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        allCourse=new ArrayList<>();
        allCourse.add(new courseHelperClass("Course1","Provider:Byjus","Rs 25,000",R.drawable.course1));
        allCourse.add(new courseHelperClass("Course2","Provider:Fiitjee","Rs 15,000",R.drawable.course2));
        allCourse.add(new courseHelperClass("Course3","Provider:Akash","Rs 10,000",R.drawable.course3));
        allCourse.add(new courseHelperClass("Course4","Provider:Atomos Classes","Rs 6,780",R.drawable.course4));
        allCourse.add(new courseHelperClass("Course5","Provider:All learning","Rs 18,000",R.drawable.course5));
        allCourse.add(new courseHelperClass("Course6","Provider:Allen Institue","Rs 13,000",R.drawable.course6));

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.courseRecycler);
        courseRecylerAdapter courseRecylerAdapter1=new courseRecylerAdapter(allCourse,count);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(courseRecylerAdapter1);
    }
}
