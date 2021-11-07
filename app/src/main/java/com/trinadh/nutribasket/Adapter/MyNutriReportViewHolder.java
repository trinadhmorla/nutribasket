package com.trinadh.nutribasket.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.trinadh.nutribasket.R;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by AbhiAndroid
 */

public class MyNutriReportViewHolder extends RecyclerView.ViewHolder {

//    @BindView(R.id.myNutriRecyclerView)
//    RecyclerView myNutriRecyclerView;
    @BindView(R.id.nutriReprt)
    TextView nurireport;

    public MyNutriReportViewHolder(final Context context, View Nutriview) {
        super(Nutriview);
        ButterKnife.bind(this,Nutriview);
    }
}
