package com.example.prototype;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class bookRecyclerView extends RecyclerView.Adapter<bookRecyclerView.bookviewHolder>{

    List<ebookClass>myBooks;
    Context context;
    public bookRecyclerView(List<ebookClass> myBooks) {
        this.myBooks = myBooks;
    }


    @NonNull
    @Override
    public bookviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        context=parent.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        view=layoutInflater.inflate(R.layout.studymaterial,parent,false);
        return  new bookRecyclerView.bookviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bookviewHolder holder, final int position) {
        holder.bookTitle.setText(myBooks.get(position).getBooktitle());
        holder.bookthumbnail.setImageResource(myBooks.get(position).getBookthumbnail());
        holder.bookscardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=myBooks.get(position).getBookUrl();
                Intent intent=new Intent(context,ViewBookpdf.class);
                intent.putExtra("bookUrl",url);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myBooks.size();
    }

    public class bookviewHolder extends RecyclerView.ViewHolder
    {
        ImageView bookthumbnail;
        TextView bookTitle;
        CardView bookscardview;

        public bookviewHolder(@NonNull View itemView) {
            super(itemView);
            bookthumbnail=itemView.findViewById(R.id.ebookThumbnail);
            bookTitle=itemView.findViewById(R.id.booktitle);
            bookscardview=itemView.findViewById(R.id.BooksCardView);
        }
    }


}
