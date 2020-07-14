package com.example.onlineshop.bottomNavFragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toolbar;

import com.example.onlineshop.HomeActivity;
import com.example.onlineshop.R;
import com.example.onlineshop.ui.home.HomeFragment;

import static com.example.onlineshop.HomeActivity.bottomNavigationView;
import static com.example.onlineshop.HomeActivity.toolbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    public CartFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cart, container, false);

        HomeActivity main = (HomeActivity) getActivity();
        main.setSupportActionBar(toolbar);
        main.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
                }
        });

       /* bottomNavigationView.setVisibility(View.INVISIBLE);*/
        return view;
    }

}
