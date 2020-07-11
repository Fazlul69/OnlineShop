package com.example.onlineshop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshop.R;
import com.example.onlineshop.fragment.CategoriesFragment;
import com.example.onlineshop.model.TabModel;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private List<TabModel> tabModelList;

    public CategoriesAdapter(CategoriesFragment categoriesFragment, List<TabModel> tabModelList) {
        this.tabModelList = tabModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.tab_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tab_item_image.setImageResource(tabModelList.get(position).getTab_item_image());
        holder.tab_item_name.setText(tabModelList.get(position).getTab_item_name());
    }

    @Override
    public int getItemCount() {
        return tabModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView tab_item_image;
        TextView tab_item_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tab_item_image = itemView.findViewById(R.id.tab_item_image);
            tab_item_name = itemView.findViewById(R.id.tab_item_name);
        }
    }
}
