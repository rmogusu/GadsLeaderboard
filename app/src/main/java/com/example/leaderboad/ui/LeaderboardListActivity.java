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
import com.example.leaderboad.adapters.CustomPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class LeaderboardListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_list);
        ViewPager viewPager=findViewById(R.id.viewPager);
        TabLayout tabLayout=findViewById(R.id.tabLayout);
        CustomPagerAdapter customPagerAdapter=new CustomPagerAdapter(this);
        viewPager.setAdapter(customPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
//        TextView Submit=findViewById(R.id.submit);
//        Submit.setOnClickListener(
//                view->{
//                    Intent intent=new Intent(LeaderBoardActivity.this,ProjectSubmissionActivity.class);
//                    startActivity(intent);
//                }
//        );
    }

}