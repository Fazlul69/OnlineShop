package com.example.onlineshop.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlineshop.R;
import com.example.onlineshop.adapter.CategoriesAdapter;
import com.example.onlineshop.adapter.ShopsAdapter;
import com.example.onlineshop.model.ShopsModal;
import com.example.onlineshop.model.TabModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopsFragment extends Fragment {

    public ShopsFragment() {
        // Required empty public constructor
    }

    private List<ShopsModal> shopsModalList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shops, container, false);

        RecyclerView tab_category_recycle = view.findViewById(R.id.tab_category_recycle);
        shopsModalList = new ArrayList<>();
        shopsModalList.add(new ShopsModal(R.drawable.techshop,"Tech"));
        shopsModalList.add(new ShopsModal(R.drawable.tvsshop,"TVS"));
        shopsModalList.add(new ShopsModal(R.drawable.zaysshop,"Zays"));
        shopsModalList.add(new ShopsModal(R.drawable.gadgetshop,"Gadget"));
        shopsModalList.add(new ShopsModal(R.drawable.evalyshop,"Evaly"));
        shopsModalList.add(new ShopsModal(R.drawable.tongshop,"Tong Bazar"));

        ShopsAdapter shopsAdapter = new ShopsAdapter(getContext(),shopsModalList);

        GridLayoutManager shopGrid = new GridLayoutManager(getActivity(),3,GridLayoutManager.VERTICAL,false);
        tab_category_recycle.setLayoutManager(shopGrid);
        tab_category_recycle.setAdapter(shopsAdapter);

        return view;
    }
}
