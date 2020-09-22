package com.example.prototype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class promoSliderAdapter extends RecyclerView.Adapter<promoSliderAdapter.SliderViewHolder> {
    private List<promoItems> myPromotions;
    private ViewPager2 viewPager2;

    public promoSliderAdapter(List<promoItems> myPromotions, ViewPager2 viewPager2) {
        this.myPromotions = myPromotions;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.promotion_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImageResource(myPromotions.get(position));
        if(position==myPromotions.size()-2)
        {
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return myPromotions.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder{
        public RoundedImageView roundedImageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            roundedImageView=itemView.findViewById(R.id.promotions);
        }

        public void setImageResource(promoItems promoitems)
        {
            roundedImageView.setImageResource(promoitems.getPromoImage());
        }
    }

    public Runnable runnable=new Runnable() {
        @Override
        public void run() {
            myPromotions.addAll(myPromotions);
            notifyDataSetChanged();
        }
    };
}
