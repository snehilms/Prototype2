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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context myContext;
    private List<targets> myTargets;

    public RecyclerViewAdapter(Context myContext, List<targets> myTargets) {
        this.myContext = myContext;
        this.myTargets = myTargets;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater=LayoutInflater.from(myContext);
        view=layoutInflater.inflate(R.layout.cardview_target,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.targetName.setText(myTargets.get(position).getTarget_title());
        holder.targetImage.setImageResource(myTargets.get(position).getTarget_image());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(myContext,subjects.class);
                intent.putExtra("target_Name",myTargets.get(position).getTarget_title());
                intent.putExtra("Subjects",myTargets.get(position).getTarget_subjetcs());
                myContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myTargets.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView targetName;
        ImageView targetImage;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            targetName=(TextView)itemView.findViewById(R.id.target_name);
            targetImage=(ImageView)itemView.findViewById(R.id.target_id);
            cardView=(CardView)itemView.findViewById(R.id.cardView);
        }
    }


}
