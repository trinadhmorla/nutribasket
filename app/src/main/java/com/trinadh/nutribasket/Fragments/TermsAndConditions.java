package com.trinadh.nutribasket.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.drawerlayout.widget.DrawerLayout;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trinadh.nutribasket.Activities.MainActivity;
import com.trinadh.nutribasket.Extras.Config;
import com.trinadh.nutribasket.MVP.TermsResponse;
import com.trinadh.nutribasket.R;
import com.trinadh.nutribasket.Retrofit.Api;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class TermsAndConditions extends Fragment {

    View view;
    @BindView(R.id.faqText)
    TextView faqText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_faq, container, false);
        ButterKnife.bind(this, view);
        getTerms();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).lockUnlockDrawer(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        MainActivity.title.setText("Terms & Conditions");
        Config.getCartList(getActivity(), true);
    }

    public void getTerms() {
        final SweetAlertDialog pDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.colorPrimary));
        pDialog.setTitleText("Loading");
        pDialog.setCancelable(false);
        pDialog.show();
        Api.getClient().getTerms(new Callback<TermsResponse>() {
            @Override
            public void success(TermsResponse termsResponse, Response response) {
                pDialog.dismiss();
                faqText.setText(Html.fromHtml(termsResponse.getTerms()));

            }

            @Override
            public void failure(RetrofitError error) {
                pDialog.dismiss();

            }
        });
    }
}
