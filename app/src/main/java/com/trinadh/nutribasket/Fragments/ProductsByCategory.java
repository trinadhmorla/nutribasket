package com.trinadh.nutribasket.Fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.trinadh.nutribasket.Adapter.ProductsByCategoryAdapter;
import com.trinadh.nutribasket.R;
import com.trinadh.nutribasket.Activities.SplashScreen;


import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsByCategory extends Fragment {

    View view;
    RecyclerView recommendedItemsRecyclerView;
    int pos;
    public static ProductsByCategoryAdapter productsByCategoryAdapter;
    @BindView(R.id.noItemLayout)
    LinearLayout noItemLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pbyc, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        try {
            Bundle b = getArguments();
            pos = b.getInt("pos", 0);
            if (SplashScreen.categoryListResponseData.get(pos).getProducts().size() > 0)
                setRecommendedItemsData();
            else {
                MainFragment.instances.add(null);

                noItemLayout.setVisibility(View.VISIBLE);
            }
            Log.d("products data", b.getInt("pos", 0) + "");
        } catch (Exception e) {
            Log.d("produscts data", e.toString());
        }
    }

    public void setRecommendedItemsData() {

        recommendedItemsRecyclerView = (RecyclerView) view.findViewById(R.id.recommendedItemsRecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recommendedItemsRecyclerView.setLayoutManager(gridLayoutManager);
        recommendedItemsRecyclerView.setNestedScrollingEnabled(true);

        productsByCategoryAdapter = new ProductsByCategoryAdapter(getActivity(), SplashScreen.categoryListResponseData.get(pos).getProducts(),
                SplashScreen.categoryListResponseData.get(pos).getProducts().size());
        MainFragment.instances.add(productsByCategoryAdapter);
        recommendedItemsRecyclerView.setAdapter(productsByCategoryAdapter);
    }

}
