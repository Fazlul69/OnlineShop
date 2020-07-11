package com.example.onlineshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshop.HomeActivity;
import com.example.onlineshop.R;
import com.example.onlineshop.ServiceInnerListOneActivity;
import com.example.onlineshop.fragment.ServiceInnerListFragment;
import com.example.onlineshop.model.ServiceModel;
import com.example.onlineshop.ui.home.HomeFragment;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder>{

    private Context context;
    private List<ServiceModel> serviceData;

    public ServiceAdapter(Context context, List<ServiceModel> serviceData) {
        this.serviceData = serviceData;
        this.context=context;
    }


    @NonNull
    @Override
    public ServiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.service_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ServiceAdapter.ViewHolder holder, final int position) {
    holder.service_name.setText(serviceData.get(position).getService_name());
    holder.service_image.setImageResource(serviceData.get(position).getService_image());
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, ServiceInnerListOneActivity.class);
            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return serviceData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView service_name;
        ImageView service_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            service_name = itemView.findViewById(R.id.service_name);
            service_image = itemView.findViewById(R.id.service_image);
        }

    }


}
