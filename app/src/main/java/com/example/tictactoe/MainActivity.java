package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int myactiveplayer =0;
    int myGamestate[] = {2,2,2,2,2,2,2,2,2};
    // 0 for cross and 1 for circle


    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};


    public void imageTapped(View view) {
        ImageView myimage = (ImageView) view;


        int imageTappedTag = Integer.parseInt(myimage.getTag().toString());

        if (myGamestate[imageTappedTag] == 2) {
            myGamestate[imageTappedTag] = myactiveplayer;

            if (myactiveplayer == 0) {
                myimage.setImageResource(R.drawable.cross);
                myimage.animate().rotation(360).setDuration(1000);
                myactiveplayer = 1;
            } else {
                myimage.setImageResource(R.drawable.circle);

                myactiveplayer = 0;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Place is Already filled", Toast.LENGTH_SHORT).show();
        }


        for (int[] winPosition : winPositions) {
            if (myGamestate[winPosition[0]] == myGamestate[winPosition[1]] &&
                    myGamestate[winPosition[1]] == myGamestate[winPosition[2]] &&
                    myGamestate[winPosition[0]] != 2) {

                if (myGamestate[winPosition[0]] == 0) {
                    Toast.makeText(getApplicationContext(), "X has won the game", Toast.LENGTH_SHORT).show();
                    playAgain(view);
                } else {
                    Toast.makeText(getApplicationContext(), "O has won the game", Toast.LENGTH_SHORT).show();
                    playAgain(view);
                }

            }

        }

    }

    public void playAgain(View view){

        // set Gamestate to 2
        for (int i =0;i<myGamestate.length;i++){
            myGamestate[i]=2;
        }


        // set myactiveplayer to 0

        myactiveplayer=0;


        // set all images to ic_launcher
        LinearLayout layout =  findViewById(R.id.lineone);
        for(int i=0;i<layout.getChildCount();i++){
            ((ImageView)layout.getChildAt(i)).setImageResource(R.mipmap.ic_launcher_round);
        }

        LinearLayout layoutone =  findViewById(R.id.linetwo);
        for(int i=0;i<layoutone.getChildCount();i++){
            ((ImageView)layoutone.getChildAt(i)).setImageResource(R.mipmap.ic_launcher_round);
        }

        LinearLayout layouttwo =  findViewById(R.id.linethree);
        for(int i=0;i<layouttwo.getChildCount();i++){
            ((ImageView)layouttwo.getChildAt(i)).setImageResource(R.mipmap.ic_launcher_round);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}
