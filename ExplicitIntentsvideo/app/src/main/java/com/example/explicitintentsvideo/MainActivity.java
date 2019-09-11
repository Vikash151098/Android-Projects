package com.example.explicitintentsvideo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnact2,btnact3;
    TextView tvresult;
    final int ACTIVITY3=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.etName);
        btnact2=findViewById(R.id.btnact2);
        btnact3=findViewById(R.id.btnact3);
        tvresult=findViewById(R.id.tvresult);

        btnact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etName.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"please enter all the fields",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String name=etName.getText().toString().trim();

                    Intent intent=new Intent(MainActivity.this,com.example.explicitintentsvideo.Activity2.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
                }
            }
        });

        btnact3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,
                        com.example.explicitintentsvideo.Activity3.class);
                startActivityForResult(intent,ACTIVITY3);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==ACTIVITY3)
        {

            if(resultCode==RESULT_OK)
            {
             tvresult.setText(data.getStringExtra("surname"));
            }
            if(resultCode==RESULT_CANCELED)
            {
                tvresult.setText("No data received");
            }
        }
    }
}
