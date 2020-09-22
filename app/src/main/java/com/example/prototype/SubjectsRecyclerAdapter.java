package com.example.prototype;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubjectsRecyclerAdapter extends RecyclerView.Adapter<SubjectsRecyclerAdapter.subjectsViewHolder> {
    List<subjectsHelperClass> allSubjects;
    Context context;

    public SubjectsRecyclerAdapter(List<subjectsHelperClass> allSubjects) {
        this.allSubjects = allSubjects;
    }

    @NonNull
    @Override
    public subjectsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        context=parent.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        view= layoutInflater.inflate(R.layout.subjects_card_view,parent,false);
        return new SubjectsRecyclerAdapter.subjectsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final subjectsViewHolder holder, final int position) {
        holder.subjectImage.setImageResource(allSubjects.get(position).getSubjectImage());
        holder.subjectText.setText(allSubjects.get(position).getSubjectName());
        if(!allSubjects.get(position).getSubjectName().equals("Complete Course")) {
            holder.subjectView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, subject_page.class);
                    intent.putExtra("Subject", allSubjects.get(position).getSubjectName());
                    context.startActivity(intent);
                }
            });
        }
        else
        {
            holder.subjectView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,courseDetails.class);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return allSubjects.size();
    }

    public class subjectsViewHolder extends RecyclerView.ViewHolder
    {
        ImageView subjectImage;
        TextView subjectText;
        CardView subjectView;
        public subjectsViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectText=itemView.findViewById(R.id.subjectTitle);
            subjectImage=itemView.findViewById(R.id.subjectImage);
            subjectView=itemView.findViewById(R.id.subjectsCardView);
        }
    }
}
