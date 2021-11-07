package com.trinadh.nutribasket.Adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.trinadh.nutribasket.R;


/**
 * Created by AbhiAndroid
 */
public class DotViewHolder extends RecyclerView.ViewHolder {

    ImageView dotImageView;

    public DotViewHolder(final Context context, View itemView) {
        super(itemView);
        dotImageView = (ImageView) itemView.findViewById(R.id.dotImageView);

    }
}
