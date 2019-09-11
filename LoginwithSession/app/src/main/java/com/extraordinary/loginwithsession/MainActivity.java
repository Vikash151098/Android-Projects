package com.extraordinary.loginwithsession;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    Button b1;
    Intent in;
    public static final String MyPREFERENCES="MyPrefs";
    public static final String Name="nameKey";
    public static final String Phone ="phoneKey";
    public static final String Email="emailKey";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.edittext2);
        ed3=(EditText)findViewById(R.id.editTex3);

        b1=(Button)findViewById(R.id.button);
        sharedPreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String n=ed1.getText().toString();
                String ph=ed2.getText().toString();
                String e=ed3.getText().toString();
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(Name,n);
                editor.putString(Phone,ph);
                editor.putString(Email,e);
                editor.commit();
                in=new Intent(MainActivity.this,second_main.class);
                startActivity(in);
            }
        });
    }
}
