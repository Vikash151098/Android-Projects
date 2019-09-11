package com.example.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
public static final String EXTRA_MESSAGE="com.example.myfirstapp.MESSAGE";
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.btnsend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Receiver_Activity.class);
                editText=findViewById(R.id.etname);
                String message=editText.getText().toString();
                intent.putExtra(EXTRA_MESSAGE,message);
                //button.setOnClickListener(this);
                startActivity(intent);
            }
        });
    }

}
