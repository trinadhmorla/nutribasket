package com.trinadh.nutribasket.Fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.trinadh.nutribasket.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailPageFragment extends Fragment {
    public static DetailPageFragment newInstance(int position, ArrayList<String> imagesList) {
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putStringArrayList("imageList", imagesList);
        DetailPageFragment fragment = new DetailPageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final int position = getArguments().getInt("position");
        final List<String> imagesList = getArguments().getStringArrayList("imageList");
        int layout = R.layout.fragment_page_one;
        View root = inflater.inflate(layout, container, false);
        root.setTag(position);
        ImageView image_one = (ImageView) root.findViewById(R.id.image_one);
        Picasso.with(getActivity())
                .load(imagesList.get(position))
                .placeholder(R.drawable.defaultimage)
                .error(R.drawable.defaultimage)
                .into(image_one);

        return root;
    }
}
