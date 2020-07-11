package com.example.onlineshop.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlineshop.R;
import com.example.onlineshop.adapter.InnerListAdapter;
import com.example.onlineshop.adapter.ServiceAdapter;
import com.example.onlineshop.model.InnerListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceInnerListFragment extends Fragment {



    public ServiceInnerListFragment() {
        // Required empty public constructor
    }

    private List<InnerListModel>innerListModels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_service_inner_list, container, false);


        RecyclerView service_inner_list_recycler = view.findViewById(R.id.service_inner_list_recycler);
        innerListModels = new ArrayList<>();
        innerListModels.add(new InnerListModel(R.drawable.bus,"Bus"));
        innerListModels.add(new InnerListModel(R.drawable.car,"Taxi"));
        innerListModels.add(new InnerListModel(R.drawable.car_wash,"Taxi Wash"));

        InnerListAdapter innerListAdapter = new InnerListAdapter(this,innerListModels);
        service_inner_list_recycler.setAdapter(innerListAdapter);


        return view;
    }
}
