package com.example.planeshooter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class BitmapBank {
    Bitmap background;
    public BitmapBank(Resources res) {
        background= BitmapFactory.decodeResource(res,R.drawable.backgrounds);
    }
}
