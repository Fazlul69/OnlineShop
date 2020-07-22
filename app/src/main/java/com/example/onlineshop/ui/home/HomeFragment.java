package com.example.onlineshop.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.onlineshop.R;
import com.example.onlineshop.adapter.FlashDealAdapter;
import com.example.onlineshop.adapter.ServiceAdapter;
import com.example.onlineshop.adapter.SliderAdapter;
import com.example.onlineshop.adapter.TabViewPagerAdapter;
import com.example.onlineshop.fragment.ServiceInnerListFragment;
import com.example.onlineshop.model.FlashDealModel;
import com.example.onlineshop.model.ServiceModel;
import com.example.onlineshop.model.SliderModel;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment{

    public HomeFragment(){

    }

    private HomeViewModel homeViewModel;


    ///banner slider
    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 1;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;
    ///
    ///service
    private List<ServiceModel>serviceModelList;
    ///
    ///flash deal
    private List<FlashDealModel>flashDealModelList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);*/
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ///banner slider
        bannerSliderViewPager = root.findViewById(R.id.banner_slider_view_pager);

        sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.team2));

        sliderModelList.add(new SliderModel(R.drawable.slider));
        sliderModelList.add(new SliderModel(R.drawable.team));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher));
        sliderModelList.add(new SliderModel(R.drawable.team2));

        sliderModelList.add(new SliderModel(R.drawable.slider));


        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);

        bannerSliderViewPager.setCurrentItem(currentPage);

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
        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideShow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
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
        ////slider end

        ////service
        RecyclerView serviceList = root.findViewById(R.id.serviceList);

        serviceModelList = new ArrayList<>();
        serviceModelList.add(new ServiceModel("B2B",R.drawable.b2b));
        serviceModelList.add(new ServiceModel("Doctor",R.drawable.doctor));
        serviceModelList.add(new ServiceModel("Motor's",R.drawable.moto));
        serviceModelList.add(new ServiceModel("Online Shop",R.drawable.onlineshop));
        serviceModelList.add(new ServiceModel("Restaurant",R.drawable.restaurant));
        serviceModelList.add(new ServiceModel("B2B",R.drawable.b2b));
        serviceModelList.add(new ServiceModel("Doctor",R.drawable.doctor));
        serviceModelList.add(new ServiceModel("Motor's",R.drawable.moto));
        serviceModelList.add(new ServiceModel("Doctor",R.drawable.doctor));
        serviceModelList.add(new ServiceModel("Motor's",R.drawable.moto));
        serviceModelList.add(new ServiceModel("Online Shop",R.drawable.onlineshop));
        serviceModelList.add(new ServiceModel("Restaurant",R.drawable.restaurant));
        serviceModelList.add(new ServiceModel("Motor's",R.drawable.moto));
        serviceModelList.add(new ServiceModel("Online Shop",R.drawable.onlineshop));
        serviceModelList.add(new ServiceModel("B2B",R.drawable.b2b));
        serviceModelList.add(new ServiceModel("Doctor",R.drawable.doctor));
        serviceModelList.add(new ServiceModel("Motor's",R.drawable.moto));
        serviceModelList.add(new ServiceModel("Online Shop",R.drawable.onlineshop));
        serviceModelList.add(new ServiceModel("Restaurant",R.drawable.restaurant));
        serviceModelList.add(new ServiceModel("B2B",R.drawable.b2b));
        serviceModelList.add(new ServiceModel("Doctor",R.drawable.doctor));
        serviceModelList.add(new ServiceModel("Motor's",R.drawable.moto));
        serviceModelList.add(new ServiceModel("Doctor",R.drawable.doctor));
        serviceModelList.add(new ServiceModel("Motor's",R.drawable.moto));
        serviceModelList.add(new ServiceModel("Online Shop",R.drawable.onlineshop));
        serviceModelList.add(new ServiceModel("Restaurant",R.drawable.restaurant));
        serviceModelList.add(new ServiceModel("Motor's",R.drawable.moto));
        serviceModelList.add(new ServiceModel("Online Shop",R.drawable.onlineshop));

        ServiceAdapter serviceAdapter = new ServiceAdapter(getContext(),serviceModelList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3,GridLayoutManager.HORIZONTAL,false);
        serviceList.setLayoutManager(gridLayoutManager);
        serviceList.setAdapter(serviceAdapter);

        ///service end

        ////tabs start
        TabLayout tabLayout = root.findViewById(R.id.tab_layout);
        ////
        TabItem tabCategories = root.findViewById(R.id.categories);
        TabItem tabShops = root.findViewById(R.id.shops);
        TabItem tabBrands = root.findViewById(R.id.brands);
        final ViewPager tabViewPager = root.findViewById(R.id.tabViewPager);

        TabViewPagerAdapter tabViewPagerAdapter = new TabViewPagerAdapter(getChildFragmentManager(), tabLayout.getTabCount());
        tabViewPager.setAdapter(tabViewPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //////tabs ensd

        ///FlashDeal
        RecyclerView flashDealList = root.findViewById(R.id.flash_deal_recycler);

        flashDealModelList = new ArrayList<>();
        flashDealModelList.add(new FlashDealModel(R.drawable.shampoo,"Shampoo","৳ 255"));
        flashDealModelList.add(new FlashDealModel(R.drawable.rice,"Italian Basmati Rice","৳ 300"));
        flashDealModelList.add(new FlashDealModel(R.drawable.honey,"100% Pure Shundorban Honey","৳ 120"));
        flashDealModelList.add(new FlashDealModel(R.drawable.oil,"Sunflower Oil","৳ 550"));
        flashDealModelList.add(new FlashDealModel(R.drawable.pasta,"Italian Pasta","৳ 120"));

        FlashDealAdapter flashDealAdapter = new FlashDealAdapter(getContext(),flashDealModelList);
        GridLayoutManager flashDealGrid = new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
        flashDealList.setLayoutManager(flashDealGrid);
        flashDealList.setAdapter(flashDealAdapter);

        ////flash deal end
        return root;
    }


    //////banner

    private void pageLooper(){
        if(currentPage == sliderModelList.size()-1){
            currentPage = 1;
            bannerSliderViewPager.setCurrentItem(currentPage, false);
        }

        if(currentPage == 0){
            currentPage = sliderModelList.size() - 2;
            bannerSliderViewPager.setCurrentItem(currentPage, false);
        }
    }

    private void  startBannerSlideShow(){
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentPage >= sliderModelList.size()){
                    currentPage = 1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);
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



    /////
}
