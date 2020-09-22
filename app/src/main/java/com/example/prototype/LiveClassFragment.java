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

public class LiveClassFragment extends Fragment {

    List<liveClasses> myLiveClass;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myLiveClass=new ArrayList<>();
        View view=inflater.inflate(R.layout.live_class_fragment,container,false);
        myLiveClass.add(new liveClasses("Waves","fiitjee",R.drawable.engineering,"www.xyz.com"));
        myLiveClass.add(new liveClasses("Laws of motion","akaash",R.drawable.engineering,"www.xyz.com"));
        myLiveClass.add(new liveClasses("Gravitaion","Vidyamandir",R.drawable.engineering,"www.xyz.com"));
        myLiveClass.add(new liveClasses("Inertia","fiitjee",R.drawable.engineering,"www.xyz.com"));
        myLiveClass.add(new liveClasses("Thermodynamics","akaash",R.drawable.engineering,"www.xyz.com"));
        myLiveClass.add(new liveClasses("Surface Tension","fiitjee",R.drawable.engineering,"www.xyz.com"));
        myLiveClass.add(new liveClasses("Rotation","akaash",R.drawable.engineering,"www.xyz.com"));
        myLiveClass.add(new liveClasses("Solids","fiitjee",R.drawable.engineering,"www.xyz.com"));

        RecyclerView liveRecyclerView=view.findViewById(R.id.LiveClassRecycler);
        RecyclerLiveAdapter recyclerLiveAdapter=new RecyclerLiveAdapter(myLiveClass);
        liveRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        liveRecyclerView.setAdapter(recyclerLiveAdapter);
        return view;

    }
}
