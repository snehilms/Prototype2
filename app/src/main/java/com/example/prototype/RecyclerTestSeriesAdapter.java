package com.example.prototype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerTestSeriesAdapter extends RecyclerView.Adapter<RecyclerTestSeriesAdapter.SeriesViewHolder> {
    List<TestSeries>myTestSeries;

    public RecyclerTestSeriesAdapter(List<TestSeries> myTestSeries) {
        this.myTestSeries = myTestSeries;
    }

    @NonNull
    @Override
    public SeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        view=layoutInflater.inflate(R.layout.test_series_layout,parent,false);
        return  new RecyclerTestSeriesAdapter.SeriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder holder, int position) {
        holder.seriesThumbnail.setImageResource(myTestSeries.get(position).getSeriesThumbnail());
        holder.seriesTopic.setText(myTestSeries.get(position).getSeriesName());
        holder.seriesCompany.setText(myTestSeries.get(position).getSeriesCompany());
        holder.price.setText("Rs"+myTestSeries.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return myTestSeries.size();
    }


    public class SeriesViewHolder extends RecyclerView.ViewHolder
    {
        ImageView seriesThumbnail;
        TextView seriesTopic;
        TextView seriesCompany;
        TextView price;
        public SeriesViewHolder(@NonNull View itemView) {
            super(itemView);
            seriesThumbnail=itemView.findViewById(R.id.testSeriesThumbnail);
            seriesTopic=itemView.findViewById(R.id.testSeriestitle);
            seriesCompany=itemView.findViewById(R.id.testSeriesCompany);
            price=itemView.findViewById(R.id.testSeriesPrice);
        }
    }

}
