package com.example.leaderboad.ui;


import androidx.appcompat.app.AppCompatActivity;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.content.Context;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.TextView;


import com.example.leaderboad.R;
import com.google.android.material.tabs.TabLayout;

public class LeaderboardListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_list);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), LeaderboardListActivity.this);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));

        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    class PagerAdapter extends FragmentPagerAdapter {
        String tabTitles[] = new String[]{"Learning Leaders", "Skill IQ Leaders"};
        Context context;


        public PagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new LeaderboardFragment();
                case 1:
                    return new SkilliqFragment();
                case 2:
                    return new SkilliqFragment();
            }
            return null;
        }

        @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }


        public View getTabView(int position) {
            View tab = LayoutInflater.from(LeaderboardListActivity.this).inflate(R.layout.custom_tab, null);
            TextView tv = (TextView) tab.findViewById(R.id.custom_text);
            tv.setText(tabTitles[position]);
            return tab;

        }

    }
}