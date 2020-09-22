package com.example.prototype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class paperRecyclerAdapter extends RecyclerView.Adapter<paperRecyclerAdapter.paperViewHolder> {
    List<previousYearPaper>myPrevious;

    public paperRecyclerAdapter(List<previousYearPaper> myPrevious) {
        this.myPrevious = myPrevious;
    }

    @NonNull
    @Override
    public paperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        view=layoutInflater.inflate(R.layout.previous_year_questions_layout,parent,false);
        return new paperRecyclerAdapter.paperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull paperViewHolder holder, int position) {
        holder.yearnNum.setText(myPrevious.get(position).getYearName());
        holder.paperThumbNail.setImageResource(myPrevious.get(position).getPaperThumbail());
    }

    @Override
    public int getItemCount() {
        return myPrevious.size();
    }

    public  class paperViewHolder extends RecyclerView.ViewHolder
    {
        ImageView paperThumbNail;
        TextView yearnNum;
        public paperViewHolder(@NonNull View itemView) {
            super(itemView);
            paperThumbNail=itemView.findViewById(R.id.previous_year_papers_Thumbnail);
            yearnNum=itemView.findViewById(R.id.yearNum);
        }
    }
}
