package com.example.prototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context)
    {
        this.context=context;
    }

    public int[] slide_images={

            R.drawable.slide1,
            R.drawable.slide2,
            R.drawable.slide3
    };

    public String[] slide_headings={
        "Random Text1",
            "Random text 2",
            "Random Text3"
    };

    public String[] slide_subheadings={
            "Sub heading 1",
            "Sub heading 2",
            "Sub heading 3"
    };

    public int[] dot_images={

            R.drawable.dots1,
            R.drawable.dots2,
            R.drawable.dots3
    };



    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== (RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView picture=(ImageView)view.findViewById(R.id.picture);
        ImageView dots=(ImageView)view.findViewById(R.id.dots);
        TextView heading=(TextView)view.findViewById(R.id.heading);
        TextView subheading=(TextView)view.findViewById(R.id.subheading);

        picture.setImageResource(slide_images[position]);
        dots.setImageResource(dot_images[position]);
        heading.setText(slide_headings[position]);
        subheading.setText(slide_subheadings[position]);

        container.addView(view);
        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
