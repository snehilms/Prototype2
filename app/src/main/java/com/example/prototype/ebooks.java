package com.example.prototype;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ebooks extends Fragment {


    List<ebookClass>myEbooks;
    public ebooks() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_ebooks, container, false);


       myEbooks=new ArrayList<>();
       myEbooks.add(new ebookClass("Random Book1",R.drawable.book1,"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
       myEbooks.add(new ebookClass("Random Book2",R.drawable.book2,"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
       myEbooks.add(new ebookClass("Random Book3",R.drawable.book3,"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
       myEbooks.add(new ebookClass("Random Book4",R.drawable.book4,"http://www.pdf995.com/samples/pdf.pdf"));
       myEbooks.add(new ebookClass("Random Book1",R.drawable.book1,"http://www.pdf995.com/samples/pdf.pdf"));
       myEbooks.add(new ebookClass("Random Book2",R.drawable.book2,"http://www.pdf995.com/samples/pdf.pdf"));
       myEbooks.add(new ebookClass("Random Book3",R.drawable.book3,"http://www.pdf995.com/samples/pdf.pdf"));
       myEbooks.add(new ebookClass("Random Book4",R.drawable.book4,"http://www.pdf995.com/samples/pdf.pdf"));

       RecyclerView bookrecyclerView=view.findViewById(R.id.ebooksRecycler);
       bookRecyclerView bookrecyclerView1=new bookRecyclerView(myEbooks);
       bookrecyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),2));
       bookrecyclerView.setAdapter(bookrecyclerView1);

       return view;
    }


}
