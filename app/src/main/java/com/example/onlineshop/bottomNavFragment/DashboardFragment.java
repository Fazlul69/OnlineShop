package com.example.onlineshop.bottomNavFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.onlineshop.BalanceCheckActivity;
import com.example.onlineshop.HomeActivity;
import com.example.onlineshop.R;

import static com.example.onlineshop.HomeActivity.toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    public DashboardFragment() {
        // Required empty public constructor
    }

    Button blnCheckBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View root =  inflater.inflate(R.layout.fragment_dashboard, container, false);

        HomeActivity main = (HomeActivity) getActivity();
        main.setSupportActionBar(toolbar);
        main.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        main.
        toolbar.setTitle("Dashboard");
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
                /*bottomNavigationView.setVisibility(View.VISIBLE);*/
            }
        });

        blnCheckBtn = root.findViewById(R.id.blncCheckBtn);

        blnCheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), BalanceCheckActivity.class);
                startActivity(i);
            }
        });

       /* bottomNavigationView.setVisibility(View.INVISIBLE);*/
        return root;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.dashboard_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
