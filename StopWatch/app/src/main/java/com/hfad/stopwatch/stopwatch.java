package com.hfad.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class stopwatch extends AppCompatActivity {
private int second=0;
  private  int milisecond=0;
private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        if(savedInstanceState!=null)
        {
            milisecond=savedInstanceState.getInt("milisecond");
            second=savedInstanceState.getInt("second");
            running=savedInstanceState.getBoolean("running");
        }
        runTimer();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("milisecond", milisecond);
        savedInstanceState.putInt("second", second);
        savedInstanceState.putBoolean("running", running);

    }
public void onClickStart(View view)
{
    running=true;
}
public void onClickStop(View view)
{
    running=false;
}
public void onClickReset(View view)
{
    milisecond=0;
    second=0;
    running=false;
}
private void runTimer()
{
    final TextView timeview=(TextView)findViewById(R.id.time_view);
    final TextView Milisec=(TextView)findViewById(R.id.milisec_view);
    final Handler handler=new Handler();
    handler.post(new Runnable() {
    public void run()
    {

    int hours=second/3600;
    int minutes=(second%3600)/60;
    int sec=second%60;

    String time=String.format("%d:%02d:%02d",hours,minutes,sec);
    String milisec=String.format("%02d",(milisecond*10)%100);
    timeview.setText(time);
    Milisec.setText("."+milisec);
    if(running)
    {
        milisecond++;
        if(milisecond%10==0)
        {
            second++;
        }
    }
    handler.postDelayed(this,100);
    }});

}
}
