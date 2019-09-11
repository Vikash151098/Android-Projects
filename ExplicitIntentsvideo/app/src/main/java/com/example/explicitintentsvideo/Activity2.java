package com.example.explicitintentsvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tvwelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvwelcome=findViewById(R.id.tvwelcome);

        String name=getIntent().getStringExtra("name") ;

        tvwelcome.setText(name+", welcome to Activity 2");
    }
}
