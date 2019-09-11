package com.extraordinary.loginwithsession;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class second_main extends AppCompatActivity {

    Button b1=null,b2=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button3);
    }

    public void logout(View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public void close(View view)
    {
        finish();
    }
}
