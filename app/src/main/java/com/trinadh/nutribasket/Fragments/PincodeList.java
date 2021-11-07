package com.trinadh.nutribasket.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trinadh.nutribasket.Adapter.PincodeListAdapter;
import com.trinadh.nutribasket.Extras.Config;
import com.trinadh.nutribasket.Activities.MainActivity;
import com.trinadh.nutribasket.R;
import com.trinadh.nutribasket.Activities.SplashScreen;
import com.xiaofeng.flowlayoutmanager.FlowLayoutManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PincodeList extends Fragment {

    View view;
    @BindView(R.id.pincodeRecyclerView)
    RecyclerView pincodeRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pincode, container, false);
        ButterKnife.bind(this, view);
        setPicodeListData();
        return view;
    }

    public void setPicodeListData() {
        FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
        flowLayoutManager.setAutoMeasureEnabled(true);
        pincodeRecyclerView.setLayoutManager(flowLayoutManager);
        PincodeListAdapter pincodeListAdapter = new PincodeListAdapter(getActivity(), SplashScreen.restaurantDetailResponseData.getDeliverycity());
        pincodeRecyclerView.setAdapter(pincodeListAdapter);
    }
    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).lockUnlockDrawer(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        MainActivity.title.setText("Available Pincode");
        Config.getCartList(getActivity(), true);
    }
}
