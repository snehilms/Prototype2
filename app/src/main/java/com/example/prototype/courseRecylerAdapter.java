package com.example.prototype;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class courseRecylerAdapter extends RecyclerView.Adapter<courseRecylerAdapter.courseViewHolder> {

    List<courseHelperClass> myCourses;
    public static List<compareModel> UpdateCompareList =new ArrayList<>();


    Context context;
    int count;

    public courseRecylerAdapter(List<courseHelperClass> myCourses, int count) {
        this.myCourses = myCourses;
        this.count = count;
    }
    public courseRecylerAdapter()
    {
        this.myCourses =myCourses;
        this.count = count;
    }

    @NonNull
    @Override
    public courseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        context = parent.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        view=layoutInflater.inflate(R.layout.course_detail_layout,parent,false);
        return new courseRecylerAdapter.courseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull courseViewHolder holder, final int position) {
     holder.courseImage.setImageResource(myCourses.get(position).getCourseImage());
     holder.courseName.setText(myCourses.get(position).getCourseTitle());
     holder.price.setText(myCourses.get(position).getPrice());
     holder.courseProvider.setText(myCourses.get(position).getProvider());
     holder.addBt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
                Toast.makeText(view.getContext(),"courseAdded",Toast.LENGTH_SHORT).show();
             UpdateCompareList.add(new compareModel(myCourses.get(position).getCourseTitle(),myCourses.get(position).getProvider(),
                     myCourses.get(position).getPrice(),myCourses.get(position).getCourseImage()));


         }
     });

     holder.courseDetsBt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent=new Intent(context,viewCourseDetails.class);
             context.startActivity(intent);
         }
     });
    }

    @Override
    public int getItemCount() {
        return myCourses.size();
    }


    public class courseViewHolder extends  RecyclerView.ViewHolder
    {
        ImageView courseImage;
        TextView price;
        TextView courseName;
        TextView courseProvider;
        Button addBt;
        Button courseDetsBt;
        public courseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseImage=itemView.findViewById(R.id.courseImage);
            price=itemView.findViewById(R.id.coursePrice);
            courseName=itemView.findViewById(R.id.courseTitle);
            courseProvider=itemView.findViewById(R.id.courseProvider);
            addBt=itemView.findViewById(R.id.addToCompareBt);
            courseDetsBt=itemView.findViewById(R.id.courseDetailBt);
        }

    }
}
