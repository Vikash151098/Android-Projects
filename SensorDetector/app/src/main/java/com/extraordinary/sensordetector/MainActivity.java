package com.extraordinary.sensordetector;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView t1=null;
    private SensorManager mSensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=(TextView)findViewById(R.id.textView2);
        t1.setVisibility(View.GONE);

        mSensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor> mList=mSensorManager.getSensorList((Sensor.TYPE_ALL));
        for(int i=1;i<mList.size();i++)
        {
            t1.setVisibility(View.VISIBLE);
            t1.append("\n"+mList.get(i).getName()+"\n"+mList.get(i).getVendor()+"\n"+mList.get(i).getVersion());

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

        if(id==R.string.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
