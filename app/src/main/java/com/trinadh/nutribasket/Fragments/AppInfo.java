package com.trinadh.nutribasket.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.drawerlayout.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.trinadh.nutribasket.Extras.Config;
import com.trinadh.nutribasket.Activities.MainActivity;
import com.trinadh.nutribasket.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AppInfo extends Fragment {

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_more, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.termsLayout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.termsLayout:
                ((MainActivity) getActivity()).loadFragment(new TermsAndConditions(), true);
                break;

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).lockUnlockDrawer(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        MainActivity.title.setText("App Info");
        Config.getCartList(getActivity(), true);
    }
}
