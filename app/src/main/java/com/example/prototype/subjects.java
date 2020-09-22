package com.example.prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class subjects extends AppCompatActivity {

   private ViewPager2 viewPager2;
   List<promoItems> myItems;
   public Handler slideHandler=new Handler();
   List<subjectsHelperClass> myTargetSubjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        viewPager2=findViewById(R.id.viewPager2);
        myItems=new ArrayList<>();
        myTargetSubjects=new ArrayList<>();

        myItems.add(new promoItems(R.drawable.promo1));
        myItems.add(new promoItems(R.drawable.promo2));
        myItems.add(new promoItems(R.drawable.promo3));
        myItems.add(new promoItems(R.drawable.promo4));

        myTargetSubjects.add(new subjectsHelperClass("Complete Course",R.drawable.complete));
        myTargetSubjects.add(new subjectsHelperClass("Physics",R.drawable.physicsimage));
        myTargetSubjects.add(new subjectsHelperClass("Chemistry",R.drawable.chemistryimage));
        myTargetSubjects.add(new subjectsHelperClass("Maths",R.drawable.mathsimage));

        viewPager2.setAdapter(new promoSliderAdapter(myItems,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_ALWAYS);

        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r=1-Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(sliderRunnable);
                slideHandler.postDelayed(sliderRunnable,3000);
            }
        });


        RecyclerView subjectRecycler=findViewById(R.id.subjectsRecyclerView);
        subjectRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        SubjectsRecyclerAdapter subjectsRecyclerAdapter=new SubjectsRecyclerAdapter(myTargetSubjects);
        subjectRecycler.setAdapter(subjectsRecyclerAdapter);


    }
    private Runnable sliderRunnable=new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };




}
