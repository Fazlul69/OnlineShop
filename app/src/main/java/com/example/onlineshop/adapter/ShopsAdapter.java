package com.example.onlineshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshop.R;
import com.example.onlineshop.model.ShopsModal;
import com.example.onlineshop.tab.ShopActivity;

import java.util.List;

public class ShopsAdapter extends RecyclerView.Adapter<ShopsAdapter.ViewHolder> {

    private List<ShopsModal>shopsModalList;
    private Context context;

    public ShopsAdapter(Context context , List<ShopsModal> shopsModalList) {
        this.shopsModalList = shopsModalList;
        this.context = context;
    }

    @NonNull
    @Override
    public ShopsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.tab_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopsAdapter.ViewHolder holder, int position) {
        holder.tab_item_image.setImageResource(shopsModalList.get(position).getTab_item_image());
        holder.tab_item_name.setText(shopsModalList.get(position).getTab_item_name());
    }

    @Override
    public int getItemCount() {
        return shopsModalList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView tab_item_image;
        TextView tab_item_name;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            tab_item_image = itemView.findViewById(R.id.tab_item_image);
            tab_item_name = itemView.findViewById(R.id.tab_item_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent shopIntent = new Intent(itemView.getContext(), ShopActivity.class);
                    itemView.getContext().startActivity(shopIntent);
                }
            });
        }
    }
}
