package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class targetPage extends AppCompatActivity {

    List<targets> targetList;
    String[] engg={"Physics,Chemistry,Maths"};
    String[] medical={"Physics,Chemistry,Maths"};
    String[] GATE={"Physics,Chemistry,Maths"};
    String[] LAW={"Physics,Chemistry,Maths"};
    String[] ARCH={"Physics,Chemistry,Maths"};
    String[] CA_CPT={"Physics,Chemistry,Maths"};
    String[] NDA={"Physics,Chemistry,Maths"};
    String[] UPSC={"Physics,Chemistry,Maths"};
    String[] SSC={"Physics,Chemistry,Maths"};
    String[] IELTS={"Physics,Chemistry,Maths"};
    String[] GRE={"Physics,Chemistry,Maths"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_page);
        targetList=new ArrayList<>();
        targetList.add(new targets("ENGINEERING",R.drawable.engineering,engg));
        targetList.add(new targets("MEDICAL",R.drawable.medicine,medical));
        targetList.add(new targets("ARCHITECTURE",R.drawable.architecture,ARCH));
        targetList.add(new targets("GATE",R.drawable.gate, GATE));
        targetList.add(new targets("LAW",R.drawable.law,LAW));
        targetList.add(new targets("CA/CPT",R.drawable.ca_cpt,CA_CPT));
        targetList.add(new targets("NDA",R.drawable.nda,NDA ));
        targetList.add(new targets("UPSC",R.drawable.upsc,UPSC));
        targetList.add(new targets("SSC/BANK",R.drawable.ssc_bank,SSC));
        targetList.add(new targets("GRE",R.drawable.gre,GRE));
        targetList.add(new targets("IELTS/TOEFL",R.drawable.ielts,IELTS));

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(this,targetList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}
