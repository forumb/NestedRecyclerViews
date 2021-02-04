package com.example.recyclerviewtabs.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.recyclerviewtabs.R;

public class OnClickActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click);
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String json = bundle.getString("JSON");
        TextView textView;

        textView = findViewById(R.id.jsonTV);
        if (json != null) {
            textView.setText(json);
        }
    }
}