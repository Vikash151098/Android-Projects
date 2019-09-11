package com.hfad.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessage extends AppCompatActivity {
  public static String EXTRA_String="message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        Bundle extras=getIntent().getExtras();
        if(extras==null)
        {
            return;
        }
       String MessageText=extras.getString(Intent.EXTRA_TEXT);
        TextView messageView=(TextView)findViewById(R.id.message);
        messageView.setText(MessageText);
    }
}
