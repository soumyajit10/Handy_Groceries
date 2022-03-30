package com.example.handygrocery.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.handygrocery.Model.RecentlyViewed;
import com.example.handygrocery.ProductDetailsActivity;
import com.example.handygrocery.R;

import java.util.List;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedAdapter.RecyclerViewedViewHolder> {
    Context context;
    List<RecentlyViewed> recentlyViewedList;

    public RecentlyViewedAdapter(Context context, List<RecentlyViewed> recentlyViewedList) {
        this.context = context;
        this.recentlyViewedList = recentlyViewedList;
    }

    @NonNull
    @Override
    public RecyclerViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recently_viewwd_items,parent,false);
        return new RecyclerViewedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewedAdapter.RecyclerViewedViewHolder holder, int position) {
        holder.name.setText(recentlyViewedList.get(position).getName());
        holder.description.setText(recentlyViewedList.get(position).getDescription());
        holder.price.setText(recentlyViewedList.get(position).getPrice());
        holder.qty.setText(recentlyViewedList.get(position).getQuantity());
        holder.unit.setText(recentlyViewedList.get(position).getUnit());
        holder.bg.setBackgroundResource(recentlyViewedList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("name",recentlyViewedList.get(position).getName());
                intent.putExtra("image",recentlyViewedList.get(position).getBigImageUrl());
                intent.putExtra("price",recentlyViewedList.get(position).getPrice());
                intent.putExtra("desc",recentlyViewedList.get(position).getDescription());
                intent.putExtra("qty",recentlyViewedList.get(position).getQuantity());
                intent.putExtra("unit",recentlyViewedList.get(position).getUnit());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recentlyViewedList.size();
    }

    public static class RecyclerViewedViewHolder extends RecyclerView.ViewHolder{
        TextView name,description,price,qty,unit;
        ConstraintLayout bg;
        public RecyclerViewedViewHolder(@NonNull  View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.product_name);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            qty = itemView.findViewById(R.id.qty);
            unit = itemView.findViewById(R.id.unit);
            bg = itemView.findViewById(R.id.recently_layout);
        }
    }
}
