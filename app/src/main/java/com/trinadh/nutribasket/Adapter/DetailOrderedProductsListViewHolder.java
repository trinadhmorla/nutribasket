package com.trinadh.nutribasket.Adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.trinadh.nutribasket.MVP.OrderVariants;
import com.trinadh.nutribasket.R;

import java.util.List;

import butterknife.ButterKnife;

public class DetailOrderedProductsListViewHolder extends RecyclerView.ViewHolder {

    ImageView image1;
    TextView productName1,txtExtras,qty,price;

    public DetailOrderedProductsListViewHolder(final Context context, View itemView, List<OrderVariants> newsListResponse) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        image1 = (ImageView) itemView.findViewById(R.id.productImage1);
        productName1 = (TextView) itemView.findViewById(R.id.productName1);
        txtExtras = (TextView) itemView.findViewById(R.id.txtExtras);
        qty = (TextView) itemView.findViewById(R.id.quantity);
        price = (TextView) itemView.findViewById(R.id.price);



    }
}
