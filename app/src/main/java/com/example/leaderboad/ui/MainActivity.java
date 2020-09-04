package com.example.leaderboad.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.leaderboad.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        background = (ImageView) findViewById(R.id.imageView);
        background.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == background) {
            Intent intent = new Intent(MainActivity.this, LeaderboardListActivity.class);
            startActivity(intent);
        }
    }
}