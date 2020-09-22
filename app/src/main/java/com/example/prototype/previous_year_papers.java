package com.example.prototype;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class previous_year_papers extends Fragment {


    public previous_year_papers() {
        // Required empty public constructor
    }


    List<previousYearPaper>mypapers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mypapers=new ArrayList<>();
        View view=inflater.inflate(R.layout.fragment_previous_year_papers, container, false);;
        mypapers.add(new previousYearPaper(R.drawable.book1,"2019"));
        mypapers.add(new previousYearPaper(R.drawable.book2,"2018"));
        mypapers.add(new previousYearPaper(R.drawable.book3,"2017"));
        mypapers.add(new previousYearPaper(R.drawable.book4,"2016"));
        mypapers.add(new previousYearPaper(R.drawable.book1,"2015"));
        mypapers.add(new previousYearPaper(R.drawable.book2,"2014"));
        mypapers.add(new previousYearPaper(R.drawable.book3,"2013"));
        mypapers.add(new previousYearPaper(R.drawable.book4,"2012"));

        RecyclerView paperReccylerView=view.findViewById(R.id.previous_year_papersRecycler);
        paperReccylerView.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        paperRecyclerAdapter paperRecyclerAdapter1=new paperRecyclerAdapter(mypapers);
        paperReccylerView.setAdapter(paperRecyclerAdapter1);

        return view;
    }


}
