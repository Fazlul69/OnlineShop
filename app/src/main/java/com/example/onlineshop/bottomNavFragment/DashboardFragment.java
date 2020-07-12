package com.example.onlineshop.bottomNavFragment;

import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlineshop.HomeActivity;
import com.example.onlineshop.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.onlineshop.HomeActivity.bottomNavigationView;
import static com.example.onlineshop.HomeActivity.toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_dashboard, container, false);

        HomeActivity main = (HomeActivity) getActivity();
        main.setSupportActionBar(toolbar);
        main.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
                /*bottomNavigationView.setVisibility(View.VISIBLE);*/
            }
        });

       /* bottomNavigationView.setVisibility(View.INVISIBLE);*/
        return root;
    }
}
