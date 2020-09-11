package com.example.leaderboad.ui;


import androidx.appcompat.app.AppCompatActivity;



import androidx.viewpager.widget.ViewPager;




import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.ProgressBar;


import com.example.leaderboad.R;
import com.example.leaderboad.adapters.CustomPagerAdapter;
import com.google.android.material.tabs.TabLayout;



public class LeaderboardListActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mSubmit;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_list);

        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        CustomPagerAdapter customPagerAdapter = new CustomPagerAdapter(this);
        viewPager.setAdapter(customPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        mSubmit = (Button) findViewById(R.id.button);
        mSubmit.setOnClickListener(this);

    }

        @Override
        public void onClick(View view) {
            if (view == mSubmit) {
                Intent intent = new Intent(LeaderboardListActivity.this, ProjectSubmissionActivity.class);
                startActivity(intent);
            }
        }


}