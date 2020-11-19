package com.example.prototype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class compareAdapter extends RecyclerView.Adapter<compareAdapter.ViewHolder> {

    List<compareModel> compareList;

    public compareAdapter(List<compareModel> compareList) {
        this.compareList = compareList;
    }

    @NonNull
    @Override
    public compareAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.compare_course_det, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull compareAdapter.ViewHolder holder, final int position) {
            int resource = compareList.get(position).getCourseImage();
            String title = compareList.get(position).getCourseTitle();
            String provider = compareList.get(position).getProvider();
            String price = compareList.get(position).getPrice();
            holder.setCoursePic(resource);
            holder.setCoursePrice(price);
            holder.setCourseProvider(provider);
            holder.setCourseTitle(title);
            holder.removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    compareList.remove(position);
                        notifyDataSetChanged();
                }
            });


    }

    @Override
    public int getItemCount() {
        return compareList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView coursePic;
        TextView courseTitle;
        TextView courseProvider;
        TextView courseDuration;
        TextView coursePrice;
        Button removeButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coursePic = itemView.findViewById(R.id.courseimg);
            courseTitle = itemView.findViewById(R.id.coursename);
            courseProvider= itemView.findViewById(R.id.courseprovider);
            coursePrice = itemView.findViewById(R.id.courseprice);
            courseDuration = itemView.findViewById(R.id.courseduration);
            removeButton= itemView.findViewById(R.id.remove);
        }

        public void setCoursePic(int resource) {
           coursePic.setImageResource(resource);
        }

        public void setCourseTitle(String Title) {
            courseTitle.setText(Title);
        }

        public void setCourseProvider(String provider) {
            courseProvider.setText(provider);
        }

        public void setCourseDuration(String duration) {
            courseDuration.setText(duration);
        }

        public void setCoursePrice(String price) {
            coursePrice.setText(price);
        }
    }
}
