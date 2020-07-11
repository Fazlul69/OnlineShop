package com.example.onlineshop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshop.R;
import com.example.onlineshop.model.FlashDealModel;
import com.example.onlineshop.ui.home.HomeFragment;

import java.util.List;

public class FlashDealAdapter extends RecyclerView.Adapter<FlashDealAdapter.ViewHolder> {

    private List<FlashDealModel>flashDealModelList;

    public FlashDealAdapter(FragmentActivity homeFragment, List<FlashDealModel> flashDealModelList) {
        this.flashDealModelList = flashDealModelList;
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

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            flashDealProductImage = itemView.findViewById(R.id.flash_deal_item_image);
            flashDealProductName = itemView.findViewById(R.id.flash_deal_item_name);
            flashDealProductPrice = itemView.findViewById(R.id.flash_deal_item_price);
        }
    }
}
