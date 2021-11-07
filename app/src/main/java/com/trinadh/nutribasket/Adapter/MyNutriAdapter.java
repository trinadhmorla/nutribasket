package com.trinadh.nutribasket.Adapter;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trinadh.nutribasket.Activities.MainActivity;
import com.trinadh.nutribasket.Fragments.MyNutriDetailsPage;
import com.trinadh.nutribasket.MVP.NutriReportResponse;
import com.trinadh.nutribasket.R;

import java.util.List;

/**
 * Created by Trinadh
 */

public class MyNutriAdapter extends RecyclerView.Adapter<MyNutriReportViewHolder> {

    Context context;
    List<NutriReportResponse> nutriReportResponse;


    public MyNutriAdapter(Context context, List<NutriReportResponse> nutriReportResponce) {
        this.context = context;
        this.nutriReportResponse = nutriReportResponse;
    }

    @Override
    public MyNutriReportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.nutri_report2, null);
        MyNutriReportViewHolder MyNutriViewHolder = new MyNutriReportViewHolder(context, view);
        return MyNutriViewHolder;
    }

    @Override
    public void onBindViewHolder(MyNutriReportViewHolder holder, final int position) {
        //setProductsData(holder, position);
        // holder.date.setText("Date: " + orderes.get(position).getOrderdate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyNutriDetailsPage.pos = position;
                ((MainActivity) context).loadFragment(new MyNutriDetailsPage(), true);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
