package com.example.prototype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerLiveAdapter extends RecyclerView.Adapter<RecyclerLiveAdapter.myViewHolder> {

    List<liveClasses> liveclasses;

    public RecyclerLiveAdapter(List<liveClasses> liveclasses) {
        this.liveclasses = liveclasses;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        view=layoutInflater.inflate(R.layout.live_class,parent,false);
        return new RecyclerLiveAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.livethumbnail.setImageResource(liveclasses.get(position).getClassThumbnail());
        holder.linktoclass.setText(liveclasses.get(position).getClassLink());
        holder.companyName.setText(liveclasses.get(position).getCompantName());
        holder.topicname.setText(liveclasses.get(position).getTopicName());

        holder.linktoclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return liveclasses.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView topicname;
        ImageView livethumbnail;
        TextView companyName;
        TextView linktoclass;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            topicname=itemView.findViewById(R.id.name_of_the_Live_video);
            livethumbnail=itemView.findViewById(R.id.LiveThumbnail);
            companyName=itemView.findViewById(R.id.companyName);
            linktoclass=itemView.findViewById(R.id.livelink);
        }
    }

}
