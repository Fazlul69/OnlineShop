package com.example.onlineshop.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.onlineshop.fragment.BrandsFragment;
import com.example.onlineshop.fragment.CategoriesFragment;
import com.example.onlineshop.fragment.ShopsFragment;

public class TabViewPagerAdapter extends FragmentPagerAdapter {


    private int numOfTabs;

    public TabViewPagerAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CategoriesFragment();
            case 1:
                return new BrandsFragment();
            case 2:
                return new ShopsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
