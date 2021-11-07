package com.trinadh.nutribasket.Adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.trinadh.nutribasket.Fragments.SearchProducts;
import com.trinadh.nutribasket.MVP.Variants;
import com.trinadh.nutribasket.R;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by AbhiAndroid
 */

public class SearchProductVariantsAdapter extends RecyclerView.Adapter<SearchProductVariantsAdapter.VariantsViewHolder> {

    Context context;
    List<Variants> variants;
    int parentPosition;

    public SearchProductVariantsAdapter(Context context, List<Variants> variants, int parentPosition) {
        this.context = context;
        this.variants = variants;
        this.parentPosition=parentPosition;

    }

    @Override
    public VariantsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.variants_list_items, null);
        VariantsViewHolder variantsViewHolder = new VariantsViewHolder(view);
        return variantsViewHolder;
    }

    @Override
    public void onBindViewHolder(VariantsViewHolder holder, int position) {
        holder.textViewList.get(0).setText(variants.get(position).getVariantname());
        holder.textViewList.get(1).setText(variants.get(position).getVarprice());
        Log.d("indexIS",SearchProductListAdapter.index+"");

        if (SearchProductListAdapter.index == position) {
            holder.relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
            holder.textViewList.get(0).setTextColor(context.getResources().getColor(R.color.white));
            holder.textViewList.get(1).setTextColor(context.getResources().getColor(R.color.white));
        } else {
            holder.relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.white));
            holder.textViewList.get(0).setTextColor(context.getResources().getColor(R.color.light_black));
            holder.textViewList.get(1).setTextColor(context.getResources().getColor(R.color.black));
        }
    }

    @Override
    public int getItemCount() {
        return variants.size();
    }

    public class VariantsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.relativeLayout)
        RelativeLayout relativeLayout;
        @BindViews({R.id.size, R.id.price})
        List<TextView> textViewList;

        public VariantsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SearchProductListAdapter.selectedList.set(parentPosition,getAdapterPosition());
                    SearchProductListAdapter.popupwindow_obj.dismiss();
                    SearchProducts.productListAdapter.notifyDataSetChanged();
              }
            });
        }
    }
}
