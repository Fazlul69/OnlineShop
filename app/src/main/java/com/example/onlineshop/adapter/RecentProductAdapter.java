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

import com.example.onlineshop.ProductDetailsActivity;
import com.example.onlineshop.R;
import com.example.onlineshop.model.RecentProductModel;

import java.util.List;

public class RecentProductAdapter extends RecyclerView.Adapter<RecentProductAdapter.ViewHolder> {

    private Context context;
    private List<RecentProductModel> recentProductModelList;

    public RecentProductAdapter(Context context, List<RecentProductModel> recentProductModelList) {
        this.context = context;
        this.recentProductModelList = recentProductModelList;
    }

    @NonNull
    @Override
    public RecentProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.products_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentProductAdapter.ViewHolder holder, int position) {

        holder.productImage.setImageResource(recentProductModelList.get(position).getProductItem());
        holder.productName.setText(recentProductModelList.get(position).getProductName());
        holder.productPrice.setText(recentProductModelList.get(position).getProductPrice());
    }

    @Override
    public int getItemCount() {
        return recentProductModelList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView productImage;
        TextView productName, productPrice;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.productItem);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent productDetailsIntent = new Intent(itemView.getContext(), ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);
                }
            });
        }
    }
}
