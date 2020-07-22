package com.example.onlineshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.example.onlineshop.adapter.ProductImageSliderAdapter;
import com.example.onlineshop.adapter.ProductSliderAdapter;
import com.example.onlineshop.model.ProductImageSliderModel;
import com.example.onlineshop.model.SliderModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class ProductDetailsActivity extends AppCompatActivity {

    /*    Dialog copyDialog;*/
/*    Toolbar product_toolbar;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        /*product_toolbar = findViewById(R.id.product_toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

       /* copyDialog = new Dialog(this);*/

        ViewPager productImagesViewpager = findViewById(R.id.product_image_viewpager);
        TabLayout viewpagerIndicator = findViewById(R.id.viewpager_indicator);

        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.shirt);
        productImages.add(R.drawable.shirtblue);
        productImages.add(R.drawable.shirt);

        ProductSliderAdapter productSliderAdapter = new ProductSliderAdapter(productImages);
        productImagesViewpager.setAdapter(productSliderAdapter);
        viewpagerIndicator.setupWithViewPager(productImagesViewpager,true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.product_details_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.share){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

   /* public void CopyPopup(){
        copyDialog.setContentView(R.layout.product_sku_copy_layout);
     *//*   copyDialog.setCanceledOnTouchOutside(true);*//*
        copyDialog.show();
    }*/
}


