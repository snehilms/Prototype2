package com.example.prototype;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class materialFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.study_material_fragment,container,false);

        final TabLayout tabLayout=view.findViewById(R.id.tabLayout);
        TabItem ebooks=view.findViewById(R.id.ebooks);
        TabItem testSeries=view.findViewById(R.id.testSeries);
        TabItem previousPaper=view.findViewById(R.id.previous_year_papers);
        final ViewPager myViewPager=view.findViewById(R.id.studyViewPager);

        materialPageAdapter materialpageadapter=new materialPageAdapter(getChildFragmentManager(),tabLayout.getTabCount());

        myViewPager.setAdapter(materialpageadapter);

        ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                TabLayout.Tab tab = tabLayout.getTabAt(position);
                tab.select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

        myViewPager.addOnPageChangeListener(viewListener);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                myViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }
}
