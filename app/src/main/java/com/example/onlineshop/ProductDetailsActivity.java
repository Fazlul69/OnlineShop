package com.example.onlineshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.onlineshop.adapter.ProductImageSliderAdapter;
import com.example.onlineshop.model.ProductImageSliderModel;
import com.example.onlineshop.model.SliderModel;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ProductDetailsActivity extends AppCompatActivity {

    ///banner slider
    private ViewPager productImageViewpager;
    private List<ProductImageSliderModel> productImageSliderModelList;
    private int currentPage = 1;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        productImageViewpager = findViewById(R.id.product_image_viewpager);

        productImageSliderModelList = new ArrayList<ProductImageSliderModel>();

        productImageSliderModelList.add(new ProductImageSliderModel(R.drawable.shirt, "shirt"));
        productImageSliderModelList.add(new ProductImageSliderModel(R.drawable.shirtblue, "shirt"));

        ProductImageSliderAdapter productImageSliderAdapter = new ProductImageSliderAdapter(productImageSliderModelList);
        productImageViewpager.setAdapter(productImageSliderAdapter);
        productImageViewpager.setClipToPadding(false);
        productImageViewpager.setPageMargin(20);

 /*       productImageViewpager.setSliderAdapter(productImageSliderAdapter);
        productImageViewpager.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        productImageViewpager.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        productImageViewpager.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        productImageViewpager.setIndicatorSelectedColor(Color.WHITE);
        productImageViewpager.setIndicatorUnselectedColor(Color.GRAY);
        productImageViewpager.setScrollTimeInSec(3);
        productImageViewpager.setAutoCycle(true);
        productImageViewpager.startAutoCycle();*/
        /*
        productImageSliderModelList= new ArrayList<>();
        productImageSliderModelList.add(new ProductImageSliderModel(R.drawable.shirt));
        productImageSliderModelList.add(new ProductImageSliderModel(R.drawable.shirtblue));*/
        productImageViewpager.setCurrentItem(currentPage);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state == ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };
        productImageViewpager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideShow();

        productImageViewpager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                pageLooper();
                stopBannerSlideShow();
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });



    /*    productImageViewpager.setOnIndicatorClickListener(new DrawController.ClickListener() {

            @Override

            public void onIndicatorClicked(int position) {

                Log.i("GGG", "onIndicatorClicked: " + productImageViewpager.getCurrentPagePosition());

            }

        });*/
    }

    private void pageLooper(){
        if(currentPage == productImageSliderModelList.size()-1){
            currentPage = 1;
            productImageViewpager.setCurrentItem(currentPage, false);
        }

        if(currentPage == 0){
            currentPage = productImageSliderModelList.size() - 2;
            productImageViewpager.setCurrentItem(currentPage, false);
        }
    }

    private void  startBannerSlideShow(){
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentPage >= productImageSliderModelList.size()){
                    currentPage = 1;
                }
                productImageViewpager.setCurrentItem(currentPage++,true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        } ,DELAY_TIME,PERIOD_TIME);
    }

    private void stopBannerSlideShow(){
        timer.cancel();
    }

}


