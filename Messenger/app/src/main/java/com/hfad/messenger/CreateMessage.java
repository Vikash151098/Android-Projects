package com.hfad.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }
    public void onSendMessage(View view)
    {
        EditText messageView=(EditText)findViewById(R.id.message);
        String messageText=messageView.getText().toString();
        //Intent intent=new Intent(this,ReceiveMessage.class);
       // intent.putExtra(ReceiveMessage.EXTRA_MESSAGE,messageText);
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,messageText);
        startActivity(intent);

    }

}
