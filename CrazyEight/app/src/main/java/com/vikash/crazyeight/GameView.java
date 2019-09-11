package com.vikash.crazyeight;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameView extends View {

    private int screenW;
    private int screenH;
    private Context mycontext;
    private List<Card> deck = new ArrayList<Card>();
    private int scaleCardW;
    private int scaleCardH;
    private List<Card> myHand = new ArrayList<Card>();
    private List<Card> oppHand = new ArrayList<Card>();
    private List<Card> discardPile = new ArrayList<Card>();
    private float scale;
    private Paint whitePaint;
    private int oppScore;
    private int myScore;
    private Bitmap cardBack;
    private boolean myTurn;
    private int movingCardIdx = -1;
    private int movingX;
    private int movingY;

    public GameView(Context context) {
        super(context);
        mycontext = context;
        scale = mycontext.getResources().getDisplayMetrics().density;
        whitePaint = new Paint();
        whitePaint.setAntiAlias(true);
        whitePaint.setColor(Color.WHITE);
        whitePaint.setStyle(Paint.Style.STROKE);
        whitePaint.setTextAlign(Paint.Align.LEFT);
        whitePaint.setTextSize(scale*15);
       //myTurn = new Random().nextBoolean();
        myTurn=true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawText("Computer Score: " +
                Integer.toString(oppScore), 10,
                whitePaint.getTextSize()+10, whitePaint);
        canvas.drawText("My Score: " +
                Integer.toString(myScore), 10,
                screenH-whitePaint.getTextSize()-10,
                whitePaint);
        for (int i = 0; i < myHand.size(); i++) {
            if (i < 7) {
                canvas.drawBitmap(myHand.get(i).getBitmap(),i*(scaleCardW+5),
                        screenH-scaleCardH-whitePaint.
                                getTextSize()-(50*scale),null);
            }
        }
        for (int i = 0; i < oppHand.size(); i++) {
            canvas.drawBitmap(cardBack,
                    i*(scale*5),
                    whitePaint.getTextSize()+(50*scale),
                    null);
        }
        canvas.drawBitmap(cardBack,
                (screenW/2)-cardBack.getWidth()-10,
                (screenH/2)-(cardBack.getHeight()/2), null);
        if (!discardPile.isEmpty()) {
            canvas.drawBitmap(discardPile.get(0).getBitmap(),
                    (screenW/2)+10,
                    (screenH/2)-(cardBack.getHeight()/2),
                    null);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventAction = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (eventAction) {
            case MotionEvent.ACTION_DOWN:
                if (myTurn) {
                    for (int i = 0; i < 7; i++) {
                        if (x > i*(scaleCardW+5) &&
                                x < i*(scaleCardW+5) + scaleCardW &&
                                y > screenH-scaleCardH-whitePaint.getTextSize()- (50*scale)) {
                            movingCardIdx = i;
                            movingX = x;
                            movingY = y;
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                movingX = x;
                movingY = y;
                break;
            case MotionEvent.ACTION_UP:
                movingCardIdx = -1;
                break;
        }
        invalidate();
        return true;
    }

    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenW=w;
        screenH=h;
        Bitmap tempBitmap =
                BitmapFactory.decodeResource(mycontext.getResources(),R.drawable.card_back);
        scaleCardW = (int) (screenW/8);
        scaleCardH = (int) (scaleCardW*1.28);
        cardBack = Bitmap.createScaledBitmap(tempBitmap, scaleCardW, scaleCardH,false);
        initCards();
        dealCards();
        drawCard(discardPile);

    }

    public void initCards() {
        for (int i = 0; i < 4; i++) {
            for (int j = 102; j < 115; j++) {
                int tempId = j + (i * 100);
                Card tempCard = new Card(tempId);
                int resourceId = getResources().getIdentifier("card" + tempId, "drawable", mycontext.getPackageName());
                Bitmap tempBitmap = BitmapFactory.decodeResource(mycontext.getResources(), resourceId);
                scaleCardW = (int) screenW /8;
                scaleCardH = (int) (scaleCardW * 1.28);
                Bitmap scaleBitmap = Bitmap.createScaledBitmap(tempBitmap, scaleCardW, scaleCardH, false);
                tempCard.setBitmap(scaleBitmap);
                deck.add(tempCard);
            }
        }
    }

    private void drawCard(List<Card> handToDraw) {
        handToDraw.add(0, deck.get(0));
        deck.remove(0);
        if (deck.isEmpty()) {
            for (int i = discardPile.size()-1; i > 0 ; i--) {
                deck.add(discardPile.get(i));
                discardPile.remove(i);
                Collections.shuffle(deck,new Random());
            }
        }
    }
    private void dealCards() {
        Collections.shuffle(deck,new Random());
        for (int i = 0; i < 7; i++) {
            drawCard(myHand);
            drawCard(oppHand);
        }
    }


}