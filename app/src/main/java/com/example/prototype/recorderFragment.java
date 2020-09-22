package com.example.prototype;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class recorderFragment extends Fragment {

    List<recorded>myrecordedVideos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.recorded_fragment,container,false);
        myrecordedVideos=new ArrayList<>();
        myrecordedVideos.add(new recorded("Waves","fiitjee","www.xyz.com","2 hrs",R.drawable.engineering));
        myrecordedVideos.add(new recorded("ThermoDynamics","Akash","www.xyz.com","3 hrs",R.drawable.engineering));
        myrecordedVideos.add(new recorded("Laws of motion","Atomos","www.xyz.com","1 hrs",R.drawable.engineering));
        myrecordedVideos.add(new recorded("Rotation","Akash","www.xyz.com","2.5 hrs",R.drawable.engineering));
        myrecordedVideos.add(new recorded("Modern Physics","fiitjee","www.xyz.com","3 hrs",R.drawable.engineering));
        myrecordedVideos.add(new recorded("Graviation","Atomos","www.xyz.com","1 hrs",R.drawable.engineering));
        myrecordedVideos.add(new recorded("Inertia","fiitjee","www.xyz.com","3 hrs",R.drawable.engineering));
        myrecordedVideos.add(new recorded("Solids","VidyaMandir","www.xyz.com","2 hrs",R.drawable.engineering));

        RecyclerView recorderrecyclerView= view.findViewById(R.id.RecordedRecycler);
        RecyclerRecordedAdapter recyclerRecordedAdapter=new RecyclerRecordedAdapter(myrecordedVideos);
        recorderrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recorderrecyclerView.setAdapter(recyclerRecordedAdapter);
        return  view;
    }
}
