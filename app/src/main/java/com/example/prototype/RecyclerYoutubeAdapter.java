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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerYoutubeAdapter extends RecyclerView.Adapter<RecyclerYoutubeAdapter.MyViewHolder> {

    private List<youtubeVideos>myvideos;
    Context context;

    public RecyclerYoutubeAdapter( List<youtubeVideos> myvideos) {
        this.myvideos = myvideos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        context=parent.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        view=layoutInflater.inflate(R.layout.youtube_video,parent,false);
        return new RecyclerYoutubeAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
       // holder.thumbnail.setImageResource(myvideos.get(position).getThumbnail());
        Picasso.get().load(myvideos.get(position).getThumbnail()).into(holder.thumbnail);
        holder.videoName.setText(myvideos.get(position).getVideoname());
        holder.channelName.setText(myvideos.get(position).getChannelTitle());
        holder.type.setText("Type:"+myvideos.get(position).getType());
        holder.cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,DescriptionPage.class);

                intent.putExtra("youtubeId",myvideos.get(position).getVideoplaylistid());
                intent.putExtra("type",myvideos.get(position).getType());
                intent.putExtra("title",myvideos.get(position).getVideoname());
                intent.putExtra("channel",myvideos.get(position).getChannelTitle());
                intent.putExtra("Description",myvideos.get(position).getDescriptionDetail());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myvideos.size();
    }


    public class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView videoName,channelName,type;
        ImageView thumbnail;
        CardView cardView1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            channelName=(TextView) itemView.findViewById(R.id.channel_name);
            videoName = (TextView) itemView.findViewById(R.id.name_of_the_video);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            cardView1 = (CardView) itemView.findViewById(R.id.cardView1);
            type=itemView.findViewById(R.id.type);
        }
    }
}
