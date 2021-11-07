package com.trinadh.nutribasket.Adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.trinadh.nutribasket.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by AbhiAndroid
 */

public class MyOrdersViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.orderedProductsRecyclerView)
    RecyclerView orderedProductsRecyclerView;
    @BindView(R.id.viewOrderDetails)
    TextView viewOrderDetails;
    @BindView(R.id.orderdate)
    TextView date;


    public MyOrdersViewHolder(final Context context, View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
