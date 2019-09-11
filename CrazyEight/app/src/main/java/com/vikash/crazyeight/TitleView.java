package com.vikash.crazyeight;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class TitleView extends View {

    private boolean playbuttonPressed;
    private Bitmap titleGraphic;
    private Bitmap playButtonUp;
    private Bitmap playButtondown;
    private int screenW;
    private int screenH;
    private Context myContext;

    public TitleView(Context context) {
        super(context);
        myContext=context;
        titleGraphic= BitmapFactory.decodeResource(getResources(),R.drawable.crazy_eight1);
        playButtondown=BitmapFactory.decodeResource(getResources(),R.drawable.play_button_down);
        playButtonUp=BitmapFactory.decodeResource(getResources(),R.drawable.play_button_up);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(titleGraphic, ((screenW-titleGraphic.getWidth())/2),0,null);
        if(playbuttonPressed)
            canvas.drawBitmap(playButtondown,(screenW-playButtonUp.getWidth())/2,(int)(screenH*0.7),null);
        else
            canvas.drawBitmap(playButtonUp,(screenW - playButtonUp.getWidth()) / 2, (int) (screenH *0.7), null);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenW=w;
        screenH=h;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventAction=event.getAction();
        int x=(int)event.getX();
        int y=(int)event.getY();
        switch(eventAction)
        {
        case  MotionEvent.ACTION_DOWN:
           if (x > (screenW-playButtonUp.getWidth())/2 &&
                   x <((screenW-playButtonUp.getWidth())/2) + (playButtonUp.getWidth())&&
                   y >(int)(screenH*0.7) &&
                   y < (int)(screenH*0.7) + playButtonUp.getHeight()) {
            playbuttonPressed = true;
        }
            break;

        case   MotionEvent.ACTION_MOVE:
                break;

        case  MotionEvent.ACTION_UP:
            if(playbuttonPressed) {
                Intent GameIntent=new Intent(myContext, GameActivity.class);
                myContext.startActivity(GameIntent);
            }
            playbuttonPressed=false;
            break;
    }
       invalidate();
        return true;
    }
}
