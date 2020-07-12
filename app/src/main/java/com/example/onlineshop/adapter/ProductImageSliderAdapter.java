package com.example.onlineshop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.onlineshop.R;
import com.example.onlineshop.model.ProductImageSliderModel;
import com.example.onlineshop.model.SliderModel;

import java.util.List;

public class ProductImageSliderAdapter extends PagerAdapter {

    private List<ProductImageSliderModel>productImageSliderModelList;

    public ProductImageSliderAdapter(List<ProductImageSliderModel> productImageSliderModelList) {
        this.productImageSliderModelList = productImageSliderModelList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.image_slider_layout_item,container,false);
        ImageView banner = view.findViewById(R.id.product_image_for_slider);
        banner.setImageResource(productImageSliderModelList.get(position).getSliderImage());
        container.addView(view,0);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return productImageSliderModelList.size();
    }
}
