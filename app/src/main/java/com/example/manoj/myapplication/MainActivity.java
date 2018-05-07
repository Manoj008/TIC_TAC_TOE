package com.example.manoj.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.manoj.myapplication.R.id.image;
import static com.example.manoj.myapplication.R.id.line;

public class MainActivity extends AppCompatActivity {
    int active,star,circle;
    int played[]={2,2,2,2,2,2,2,2,2};
    int[][] winstates={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    TextView text;
    Button button;
    ImageView image0,image1,image2,image3,image4,image5,image6,image7,image8;
    boolean isGameActive=true;
    TextView play1,play2;
    LinearLayout line;
    boolean turn=true;
    public void dropIn(View v) {
        ImageView image = (ImageView) v;
        int tapped =Integer.parseInt(image.getTag().toString());
        text=(TextView)findViewById(R.id.text);
        button=(Button)findViewById(R.id.button);

        if (played[tapped] == 2 && isGameActive==true) {
            if (active == 0) {
                image.setImageResource(R.drawable.star);
                played[tapped]=active;
                active = 1;

            } else if (active == 1) {
                image.setImageResource(R.drawable.circle);
                played[tapped]=active;
                active = 0;
            }

           for (int[] winstate:winstates){
               if(played[winstate[0]]==played[winstate[1]] && played[winstate[1]]==played[winstate[2]]
                       && played[winstate[0]]!=2){
                   button.setVisibility(View.VISIBLE);
                   text.setVisibility(View.VISIBLE);
                   isGameActive=false;
                   if(played[winstate[0]]==0) {
                       text.setText("STAR WON");
                       star++;
                       play1.setText("STAR : "+star);

                   }
                   if(played[winstate[0]]==1){
                       text.setText("CIRCLE WON");
                       circle++;
                       play2.setText("CIRCLE : "+circle);
                   }
               }
               else{
                   boolean isGameOver=true;
                   for(int counter:played){
                       if(counter==2) {
                           isGameOver = false;
                       }
                   }
                   if(isGameOver){
                       button.setVisibility(View.VISIBLE);
                       text.setVisibility(View.VISIBLE);
                       text.setText("IT'S A DRAW");
                   }
               }

           }

        }
    }
    public void playAgain(View view){
        text.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
        isGameActive=true;
        for(int i=0;i<9;i++){
            played[i]=2;
        }
       ImageView image0=(ImageView)findViewById(R.id.image0);
        ImageView image1=(ImageView)findViewById(R.id.image1);
        ImageView image2=(ImageView)findViewById(R.id.image2);
        ImageView image3=(ImageView)findViewById(R.id.image3);
        ImageView image4=(ImageView)findViewById(R.id.image4);
        ImageView image5=(ImageView)findViewById(R.id.image5);
        ImageView image6=(ImageView)findViewById(R.id.image6);
        ImageView image7=(ImageView)findViewById(R.id.image7);
        ImageView image8=(ImageView)findViewById(R.id.image8);
        image0.setImageResource(0);
        image1.setImageResource(0);
        image2.setImageResource(0);
        image3.setImageResource(0);
        image4.setImageResource(0);
        image5.setImageResource(0);
        image6.setImageResource(0);
        image7.setImageResource(0);
        image8.setImageResource(0);

        if(turn) {
            active = 1;
            turn = false;
        }
        else {
            active = 0;
            turn = true;
        }

    }
    public void restart(View view){
        playAgain(view);
        if(turn) {
            active = 1;
            turn = false;
        }
        else {
            active = 0;
            turn = true;
        }
    }
    public void reset(View view){
        playAgain(view);
        star=0;
        circle=0;
        play1.setText("STAR : "+star);
        play2.setText("CIRCLE : "+circle);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play1=(TextView)findViewById(R.id.play1);
        play2=(TextView)findViewById(R.id.play2);
        line=(LinearLayout)findViewById(R.id.line);
        active=0;
        star=0;
        circle=0;

    }

}
