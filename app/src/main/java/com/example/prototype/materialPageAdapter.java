package com.example.prototype;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class materialPageAdapter extends FragmentPagerAdapter {

    private  int numTabs;

    public materialPageAdapter(@NonNull FragmentManager fm, int numTabs) {
        super(fm,numTabs);
        this.numTabs = numTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new ebooks();
            case 1: return new test_Series();
            case 2: return new previous_year_papers();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
