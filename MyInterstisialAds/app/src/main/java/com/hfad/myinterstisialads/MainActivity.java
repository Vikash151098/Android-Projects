package com.hfad.myinterstisialads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
private InterstitialAd minterstitialad;
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        minterstitialad=new InterstitialAd(this);
        minterstitialad.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        minterstitialad.loadAd(new AdRequest.Builder().build());
        minterstitialad.setAdListener(new AdListener());
        button=findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(minterstitialad.isLoaded())
                {
                    minterstitialad.show();
                }
                else
                {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });
        minterstitialad.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                minterstitialad.loadAd(new AdRequest.Builder().build());
            }

        });
    }
}
