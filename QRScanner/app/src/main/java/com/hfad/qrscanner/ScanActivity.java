package com.hfad.qrscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
private ZXingScannerView mScannerview;
@Override
    public void onCreate(Bundle state) {

    super.onCreate(state);
    mScannerview=new ZXingScannerView(this);
    setContentView(mScannerview);
}
@Override
    public void onResume() {

    super.onResume();
    mScannerview.setResultHandler(this);
    mScannerview.startCamera();
}
@Override
public void onPause() {

    super.onPause();
    mScannerview.stopCamera();
}

    @Override
    public void handleResult(Result rawresult) {
       MainActivity.tvresult.setText(rawresult.getText());
       onBackPressed();
    }
}
