package com.example.recyclerviewtabs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.recyclerviewtabs.views.TabThreeFragment;
import com.example.recyclerviewtabs.views.TabTwoFragment;
import com.example.recyclerviewtabs.R;
import com.example.recyclerviewtabs.views.TabOneFragment;

public class TabsAdapter extends FragmentPagerAdapter {

    Context context;

    public TabsAdapter(@NonNull FragmentManager fm, int behavior, Context context) {
        super(fm, behavior);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TabOneFragment();
        } else if (position == 1) {
            return new TabTwoFragment();
        } else return new TabThreeFragment();
    }


    @Override
    public int getCount() {
        return 3;
    }

    public View getTabView(int position) {
        String[] tabTitles = new String[]{"First", "Second", "Third"};
        int[] imageResId = {R.drawable.tab_one_og, R.drawable.tab_two_og, R.drawable.tab_three_og};

        View tabView = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        TextView tabTv = tabView.findViewById(R.id.tab_text);
        tabTv.setText(tabTitles[position]);
        tabTv.setTextColor(context.getResources().getColor(R.color.white));

        ImageView tabImg = tabView.findViewById(R.id.tab_img);
        tabImg.setImageResource(imageResId[position]);
        return tabView;
    }
}
