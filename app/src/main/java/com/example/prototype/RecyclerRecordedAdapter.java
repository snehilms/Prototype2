package com.example.prototype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerRecordedAdapter extends RecyclerView.Adapter<RecyclerRecordedAdapter.myrecordedView> {

    List<recorded>myrecorded;

    public RecyclerRecordedAdapter(List<recorded> myrecorded) {
        this.myrecorded = myrecorded;
    }

    @NonNull
    @Override
    public myrecordedView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        view=layoutInflater.inflate(R.layout.recorded_class,parent,false);
        return new RecyclerRecordedAdapter.myrecordedView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myrecordedView holder, int position) {
        holder.topicName.setText(myrecorded.get(position).getTopicName());
        holder.companyname.setText(myrecorded.get(position).getCompanyName());
        holder.duration.setText(myrecorded.get(position).getDuration());
        holder.link.setText(myrecorded.get(position).getLink());
        holder.recordedThumbnail.setImageResource(myrecorded.get(position).getRecordedThumbnail());
        holder.link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return myrecorded.size();
    }

    public class myrecordedView extends RecyclerView.ViewHolder
    {
        TextView topicName;
        TextView companyname;
        TextView duration;
        TextView link;
        ImageView recordedThumbnail;
        public myrecordedView(@NonNull View itemView) {
            super(itemView);
            topicName=itemView.findViewById(R.id.name_of_the_Recorded_video);
            companyname=itemView.findViewById(R.id.companyNameRecorded);
            duration=itemView.findViewById(R.id.duration);
            link=itemView.findViewById(R.id.Recordedlink);
            recordedThumbnail=itemView.findViewById(R.id.RecordedThumbnail);
        }
    }
}
