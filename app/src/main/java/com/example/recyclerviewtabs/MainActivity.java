package com.example.recyclerviewtabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewtabs.adapters.TabsAdapter;
import com.example.recyclerviewtabs.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewpager);
        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, this);
        viewPager.setAdapter(tabsAdapter);

        final TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            assert tab != null;
            tab.setCustomView(tabsAdapter.getTabView(i));
        }

        final int[] tabImgResOnClick = {R.drawable.tab_one, R.drawable.tab_two, R.drawable.tab_three};
        final int[] imageResId = {R.drawable.tab_one_og, R.drawable.tab_two_og, R.drawable.tab_three_og};

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View tabView = tab.getCustomView();
                assert tabView != null;
                TextView tv = tabView.findViewById(R.id.tab_text);
                tv.setTextColor(getResources().getColor(R.color.change_red));
                ImageView img = tabView.findViewById(R.id.tab_img);
                img.setImageResource(tabImgResOnClick[tab.getPosition()]);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View tabView = tab.getCustomView();
                assert tabView != null;
                TextView tv = tabView.findViewById(R.id.tab_text);
                tv.setTextColor(getResources().getColor(R.color.white));

                ImageView img = tabView.findViewById(R.id.tab_img);
                img.setImageResource(imageResId[tab.getPosition()]);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}