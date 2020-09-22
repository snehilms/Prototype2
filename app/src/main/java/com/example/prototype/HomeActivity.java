package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SliderAdapter sliderAdapter;
    public Button next,skip,test;
    int currentPage;
    int len=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager=findViewById(R.id.viewPager);
        next=(Button)findViewById(R.id.nextBt);
        skip=(Button)findViewById(R.id.skipBT);

        sliderAdapter=new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        viewPager.addOnPageChangeListener(viewListener);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPage+1);
            }
        });


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,login.class));
            }
        });

    }

    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
        currentPage=position;

        Log.i("this is the current page",Integer.toString(currentPage));
        if(currentPage==len-1)
        {
            skip .setVisibility(View.INVISIBLE);
            skip.setEnabled(false);
            next.setBackgroundResource(R.drawable.custom_button2);
            next.setText("Get started");
            next.setTextSize(23);

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(HomeActivity.this,login.class));
                }
            });

        }

       else
        {
            next.setVisibility(View.VISIBLE);
            next.setEnabled(true);
            next.setBackgroundResource(R.drawable.custom_button1);
            next.setText("Next");
            next.setTextSize(23);
            skip.setVisibility(View.VISIBLE);
            skip.setEnabled(true);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewPager.setCurrentItem(currentPage+1);
                }
            });

        }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
