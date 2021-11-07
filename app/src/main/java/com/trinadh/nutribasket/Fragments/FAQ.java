package com.trinadh.nutribasket.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.drawerlayout.widget.DrawerLayout;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.trinadh.nutribasket.Extras.Config;
import com.trinadh.nutribasket.MVP.FAQResponse;
import com.trinadh.nutribasket.Activities.MainActivity;
import com.trinadh.nutribasket.R;
import com.trinadh.nutribasket.Retrofit.Api;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class FAQ extends Fragment {

    View view;
    @BindView(R.id.faqText)
    TextView faqText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_faq, container, false);
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
        Api.getClient().getFAQ(new Callback<FAQResponse>() {
            @Override
            public void success(FAQResponse faqResponse, Response response) {
                pDialog.dismiss();
                try {
                    MainActivity.title.setText(faqResponse.getTitle());
                    faqText.setText(Html.fromHtml(faqResponse.getDescription()));
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
