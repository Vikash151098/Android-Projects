package com.example.magicidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText etID;
    Button btnSubmit;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID=findViewById(R.id.etID);
        btnSubmit=findViewById(R.id.btnSubmit);
        tvResult=findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etID.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Plese enter the field", Toast.LENGTH_SHORT).show();
                }
                else {
                    String idnumber = etID.getText().toString().trim();
                

                String dob=idnumber.substring(0,6);

                int gender=Integer.parseInt(Character.toString(idnumber.charAt(6)));

                String sGender;
                if(gender<5)
                    sGender=getString(R.string.female);
                else
                    sGender=getString(R.string.male);

                int nationality=Integer.parseInt(Character.toString(idnumber.charAt(10)));

                String sNationality;
                if(nationality==0)
                    sNationality=getString(R.string.sacitizen);
                else
                    sNationality=getString(R.string.permanentresident);


                 String text=getString(R.string.Dob)+dob+"\n" +
                        getString(R.string.gender)+sGender+"\n" +
                        getString(R.string.nationality)+sNationality;
                tvResult.setText(text);
                tvResult.setVisibility(View.VISIBLE);

            }}
        });
    }
}
