package com.example.onlineshop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshop.R;
import com.example.onlineshop.fragment.ServiceInnerListFragment;
import com.example.onlineshop.model.InnerListModel;

import java.util.List;

public class InnerListAdapter extends RecyclerView.Adapter<InnerListAdapter.ViewHolder> {

    private List<InnerListModel>innerListModels;

    public InnerListAdapter(ServiceInnerListFragment serviceInnerListFragment, List<InnerListModel> innerListModels) {
        this.innerListModels = innerListModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.service_item_look,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.service_inner_item_image.setImageResource(innerListModels.get(position).getInnerCategoryImage());
        holder.service_inner_item_name.setText(innerListModels.get(position).getInnerCategoryname());
    }

    @Override
    public int getItemCount() {
        return innerListModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView service_inner_item_image;
        TextView service_inner_item_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            service_inner_item_image = itemView.findViewById(R.id.service_inner_item_image);
            service_inner_item_name = itemView.findViewById(R.id.service_inner_item_name);
        }
    }
}
