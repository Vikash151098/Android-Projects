package com.hfad.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int activeplayer = 0;
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int winninglocation[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean gameover = false;
    LinearLayout winnerlayout;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        winnerlayout = (LinearLayout) findViewById(R.id.winnerlayout);
        winnerlayout.setVisibility(View.INVISIBLE);
    }

    public void playagain(View view) {


        winnerlayout.setVisibility(view.INVISIBLE);
        gameover = false;
        activeplayer = 0;
        for (int i = 0; i < gamestate.length; i++) {
            gamestate[i] = 2;
        }
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gd);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    public void seticon(View view) {
        int a=0;
        String msg = "";
        ImageView tappedimage = (ImageView) view;
        int tappedlocation = Integer.parseInt(view.getTag().toString());
        if (gamestate[tappedlocation] == 2 && !gameover) {
            gamestate[tappedlocation] = activeplayer;
            if (activeplayer == 0) {
                tappedimage.setImageResource(R.drawable.cross);
                activeplayer = 1;
            } else if (activeplayer == 1) {
                tappedimage.setImageResource(R.drawable.round);
                activeplayer = 0;
            }

            for (int[] winningposition : winninglocation) {
                if (gamestate[winningposition[0]] == gamestate[winningposition[1]]
                        && gamestate[winningposition[1]] == gamestate[winningposition[2]]
                        && gamestate[winningposition[0]] != 2) {
                    if (activeplayer == 0) {
                        msg = "second Player Won";
                    }
                    if (activeplayer == 1) {
                        msg = "First Player Won";
                    }
                    gameover = true;
                    btn = (Button) findViewById(R.id.button);
                    btn.setText("Play Again");
                    winnerlayout.setVisibility(view.VISIBLE);
                    TextView tv = (TextView) findViewById(R.id.textView);
                    tv.setText(msg);
                }
                else {
                    for (int j = 0; j < gamestate.length; j++) {
                        if (gamestate[j] == 2)
                            a++;
                    }
                    if (a == 0) {
                        msg = "Draw match";
                        gameover = true;
                        btn = (Button) findViewById(R.id.button);
                        btn.setText("Reset");
                        winnerlayout.setVisibility(view.VISIBLE);
                        TextView tv = (TextView) findViewById(R.id.textView);
                        tv.setText(msg);
                    }
            }
        }

        }

    }
}
