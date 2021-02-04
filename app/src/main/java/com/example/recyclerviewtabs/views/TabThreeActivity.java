package com.example.recyclerviewtabs.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.recyclerviewtabs.R;

public class TabThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs_container);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new TabThreeFragment()).commit();
        }
    }
}