package com.trinadh.nutribasket.Adapter;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trinadh.nutribasket.R;


/**
 * Created by AbhiAndroid
 */
public class DotsAdapter extends RecyclerView.Adapter<DotViewHolder> {

    Context context;
    int size, selectedPos;

    public DotsAdapter(Context context, int size, int selectedPos) {
        this.context = context;
        this.size = size;
        this.selectedPos = selectedPos;
    }

    @Override
    public DotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dots_list_items, null);
        DotViewHolder DotViewHolder = new DotViewHolder(context, view);
        return DotViewHolder;
    }

    @Override
    public void onBindViewHolder(DotViewHolder holder, int position) {
        if (position == selectedPos) {
            holder.dotImageView.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary));
        } else {
            holder.dotImageView.setColorFilter(ContextCompat.getColor(context, R.color.gray));
        }

    }

    @Override
    public int getItemCount() {
        return size;
    }
}
