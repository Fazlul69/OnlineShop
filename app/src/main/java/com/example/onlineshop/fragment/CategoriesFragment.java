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
import com.example.onlineshop.model.TabModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment {

    public CategoriesFragment() {
        // Required empty public constructor
    }

  private List<TabModel>tabModelList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        RecyclerView tab_category_recycle = view.findViewById(R.id.tab_category_recycle);
        tabModelList = new ArrayList<>();
        tabModelList.add(new TabModel(R.drawable.b2b,"B2B"));
        tabModelList.add(new TabModel(R.drawable.doctor,"Doctor"));
        tabModelList.add(new TabModel(R.drawable.moto,"Motor's"));
        tabModelList.add(new TabModel(R.drawable.onlineshop,"Online Shop"));
        tabModelList.add(new TabModel(R.drawable.restaurant,"Restaurant"));

        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(this,tabModelList);

        GridLayoutManager categoryGrid = new GridLayoutManager(getActivity(),3,GridLayoutManager.VERTICAL,false);
        tab_category_recycle.setLayoutManager(categoryGrid);
        tab_category_recycle.setAdapter(categoriesAdapter);



        return view;
    }
}
