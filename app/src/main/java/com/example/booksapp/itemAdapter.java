package com.example.booksapp;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder>{
    private Context context;
    private ArrayList<itemData> values;
    private LayoutInflater inflater;

    public itemAdapter(Context context,ArrayList<itemData> values){
        this.context=context;
        this.values=values;
        this.inflater=LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        itemData data=values.get(i);
        holder.titleText.setText(data.itemTitle);
        holder.authorText.setText(data.itemAuthor);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleText;
        TextView authorText;

        public ViewHolder(View view){
            super(view);
            titleText=view.findViewById(R.id.text1);
            authorText=view.findViewById(R.id.text2);
        }
    }
}
