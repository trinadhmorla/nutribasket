package com.trinadh.nutribasket.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.trinadh.nutribasket.Fragments.PageFragment;
import com.trinadh.nutribasket.MVP.CategoryListResponse;

import java.util.List;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private List<CategoryListResponse> categoryListResponses;

    public static int LOOPS_COUNT = 1000;

    public MyPagerAdapter(FragmentManager manager, List<CategoryListResponse> categoryListResponses) {
        super(manager);
        this.categoryListResponses = categoryListResponses;
    }


    @Override
    public Fragment getItem(int position) {
        if (categoryListResponses != null && categoryListResponses.size() > 0) {
            position = position % categoryListResponses.size(); // use modulo for infinite cycling

                return PageFragment.newInstance(position);
        } else {
            return PageFragment.newInstance(0);
        }
    }


    @Override
    public int getCount() {
        if (categoryListResponses != null && categoryListResponses.size() > 0) {
            return categoryListResponses.size(); // simulate infinite by big number of products
        } else {
            return 1;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
            return categoryListResponses.get(position).getCategory_name();
    }
}