package com.vikash.crazyeight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class CrazyEightView extends View {
    private Paint redpaint;
    private int circleX;
    private int circleY;
    private float radious;
    public CrazyEightView(Context context) {
        super(context);
        redpaint=new Paint();
        redpaint.setAntiAlias(true);
        redpaint.setColor(Color.RED);
        circleX=100;
        circleY=100;
        radious=30;
    }

    @Override
    protected void onDraw(Canvas canvas) {
       canvas.drawCircle(circleX,circleY,radious,redpaint);
    }
    public boolean onTouchEvent(MotionEvent event)
    {
        int eventAction=event.getAction();
        int x=(int)event.getX();
        int y=(int)event.getY();
        switch (eventAction)
        {
          case  MotionEvent.ACTION_DOWN:
                 break;

         case   MotionEvent.ACTION_MOVE:

              break;

          case  MotionEvent.ACTION_UP:
              circleX=x;
              circleY=y;
              break;
        }
invalidate();
        return true;
    }
}
