package com.trinadh.nutribasket.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.drawerlayout.widget.DrawerLayout;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.trinadh.nutribasket.Extras.Config;
import com.trinadh.nutribasket.MVP.FAQResponse;
import com.trinadh.nutribasket.Activities.MainActivity;
import com.trinadh.nutribasket.MVP.NutriReportResponse;
import com.trinadh.nutribasket.R;
import com.trinadh.nutribasket.Retrofit.Api;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MyNutriReport extends Fragment {

    View view;
    @BindView(R.id.nutriReprt)
    TextView nutriReprt;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.nutri_report, container, false);
        ButterKnife.bind(this, view);
        getFAQ();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).lockUnlockDrawer(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        MainActivity.title.setText("");
        Config.getCartList(getActivity(), true);
    }

    public void getFAQ() {
        final SweetAlertDialog pDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.colorPrimary));
        pDialog.setTitleText("Loading");
        pDialog.setCancelable(false);
        pDialog.show();
        Api.getClient().getMyNutriReport(new Callback<NutriReportResponse>() {
            @Override
            public void success(NutriReportResponse nutriReportResponse, Response response) {
                pDialog.dismiss();
                try {
                    int Nutrivalues = nutriReportResponse.getProtin();
                    //displaying the string array into listview
                    listView.setAdapter(new ArrayAdapter<String>(getContext(), R.layout.nutri_report, Nutrivalues));

                } catch (Exception e) {
                }
            }

            @Override
            public void failure(RetrofitError error) {
                pDialog.dismiss();

            }
        });
    }
}
