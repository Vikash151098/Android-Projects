package com.vikash.whack_a_mole;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.logging.Handler;

public class WhackAMoleView extends SurfaceView implements SurfaceHolder.Callback {
    private Context myContext;
    private SurfaceHolder mySurfaceHolder;
    private Bitmap backgroundImg;
    private int screenW = 1;
    private int screenH = 1;
    private boolean running = false;
    private boolean onTitle = true;
    private WhackAMoleThread thread;
    public WhackAMoleView(Context context, AttributeSet attrs) {
        super(context);
        SurfaceHolder holder=getHolder();
        holder.addCallback(this);
        thread = new WhackAMoleThread(holder, context,new Handler(){

        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
