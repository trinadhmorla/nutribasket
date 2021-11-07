package com.trinadh.nutribasket.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trinadh.nutribasket.Activities.MainActivity;
import com.trinadh.nutribasket.Adapter.MyNutriAdapter;
import com.trinadh.nutribasket.Extras.Config;
import com.trinadh.nutribasket.MVP.NutriReportResponce;
import com.trinadh.nutribasket.MVP.NutriReportResponse;
import com.trinadh.nutribasket.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyNutriDetailsPage extends Fragment {

    View view;
    @BindView(R.id.nutriReportlistRecyclerView)
    RecyclerView nutriReportlistRecyclerView;
    public static List<NutriReportResponse> nutrivalues;

    List<TextView> textViews;
    public static int pos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.nutri_report2, container, false);
        ButterKnife.bind(this, view);
        MainActivity.title.setText("");
      //  setProductsData();
        return view;
    }

/*    private void setProductsData() {
        GridLayoutManager gridLayoutManager;
        gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        nutriReportlistRecyclerView.setLayoutManager(gridLayoutManager);
        MyNutriAdapter myNutriAdapter = new MyNutriAdapter (getActivity(), myNutriResponseData);
        nutriReportlistRecyclerView.setAdapter(myNutriAdapter);

    } */
}
