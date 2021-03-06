package com.example.schoolbell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> implements OnCardItemClickListener{

    ArrayList<CardActivity> items = new ArrayList<>();

    OnCardItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView =inflater.inflate(R.layout.activity_card_item,parent,false);

        return new ViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardActivity item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;

        public ViewHolder (View view, final OnCardItemClickListener listener) {
            super (view);

            textView1=itemView.findViewById(R.id.title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener!=null) {
                        listener.onItemClick(ViewHolder.this,view,position);
                    }
                }
            });
        }

        public void setItem (CardActivity item) {
            textView1.setText(item.getTitle());
        }
    }
    public void addItem(CardActivity item) {items.add(item);}
    public void setItem(ArrayList<CardActivity> items) {this.items=items;}
    public CardActivity getItem(int position) {return items.get(position);}
    public void setItem (int position, CardActivity item) {items.set(position,item);}

    public void setOnItemClickListener (OnCardItemClickListener listener) {
        this.listener=listener;
    }

    public void onItemClick (ViewHolder holder, View view, int position) {
        if(listener!=null) {
            listener.onItemClick(holder,view,position);
        }
    }
}
