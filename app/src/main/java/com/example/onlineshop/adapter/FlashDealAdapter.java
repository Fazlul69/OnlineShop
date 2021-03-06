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
import com.example.onlineshop.model.FlashDealModel;

import java.util.List;

public class FlashDealAdapter extends RecyclerView.Adapter<FlashDealAdapter.ViewHolder> {

    private Context context;
    private List<FlashDealModel>flashDealModelList;

    public FlashDealAdapter(Context context , List<FlashDealModel> flashDealModelList) {
        this.flashDealModelList = flashDealModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.flash_deal_item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.flashDealProductImage.setImageResource(flashDealModelList.get(position).getFlashDealProductImage());
        holder.flashDealProductName.setText(flashDealModelList.get(position).getFlashDealProductName());
        holder.flashDealProductPrice.setText(flashDealModelList.get(position).getFlashDealProductPrice());
    }

    @Override
    public int getItemCount() {
        return flashDealModelList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView flashDealProductImage;
        TextView flashDealProductName, flashDealProductPrice;

        ViewHolder(@NonNull final View itemView) {
            super(itemView);
            flashDealProductImage = itemView.findViewById(R.id.flash_deal_item_image);
            flashDealProductName = itemView.findViewById(R.id.flash_deal_item_name);
            flashDealProductPrice = itemView.findViewById(R.id.flash_deal_item_price);

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
