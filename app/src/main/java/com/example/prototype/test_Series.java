package com.example.prototype;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class test_Series extends Fragment {


    public test_Series() {
        // Required empty public constructor
    }
    List<TestSeries>mytestseries;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mytestseries=new ArrayList<>();

        View view= inflater.inflate(R.layout.fragment_test__series, container, false);
        mytestseries.add(new TestSeries("AIITS","Fiijte",20000,R.drawable.book1));
        mytestseries.add(new TestSeries("AICTE","Akash",20000,R.drawable.book2));
        mytestseries.add(new TestSeries("All india Test","VidyaMandir",20000,R.drawable.book3));
        mytestseries.add(new TestSeries("Great test","Atomos",20000,R.drawable.book4));
        mytestseries.add(new TestSeries("AIITS","Fiijte",20000,R.drawable.book1));
        mytestseries.add(new TestSeries("AICTE","Akash",20000,R.drawable.book2));
        mytestseries.add(new TestSeries("All india Test","VidyaMandir",20000,R.drawable.book3));
        mytestseries.add(new TestSeries("Great test","Atomos",20000,R.drawable.book4));

        RecyclerView testRecyclerView=view.findViewById(R.id.testSeriesRecycler);
        RecyclerTestSeriesAdapter recyclerTestSeriesAdapter=new RecyclerTestSeriesAdapter(mytestseries);
        testRecyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        testRecyclerView.setAdapter(recyclerTestSeriesAdapter);

        return view;
    }

}
