package com.example.prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class subject_page extends AppCompatActivity {

    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_page);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new materialFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment SelectedFragment=null;

                    switch (item.getItemId()){

                        case R.id.study_material:
                            SelectedFragment=new materialFragment();
                            break;
                        case  R.id.recorded:
                            SelectedFragment=new recorderFragment();
                            break;
                        case R.id.live_classes:
                            SelectedFragment=new LiveClassFragment();
                            break;
                        case R.id.YouTube:
                            SelectedFragment=new youTubeFragment();
                            break;
                        case R.id.moreMaterial:
                            SelectedFragment=new moreMaterial();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,SelectedFragment).commit();
                    return true;
                }
            } ;


}
