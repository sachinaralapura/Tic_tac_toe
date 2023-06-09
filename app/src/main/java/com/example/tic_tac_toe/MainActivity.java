package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0 - x
    // 1 - o
    int activePlayer = 1;
    int gameState[] = {2,2,2,2,2,2,2,2,2};
    // state  meaning
    // 0 - x
    // 1 - o
    // 2 - null
    int[][] winPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7 },{2,5,8},{0,4,8},{2,4,6}};
    public  void  playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        TextView status = findViewById(R.id.status);
        if(gameState[tappedImage] == 2 ){
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                status.setText("O's turn to play");
            }
            else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                status.setText("X's turn to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] winPosition:winPositions){
               if(gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]]!= 2){
                   String winner;
                   if(gameState[winPosition[0]] == 0)
                       winner = "X won";
                   else
                       winner = "O won";
                   Toast.makeText(getApplicationContext(),winner,Toast.LENGTH_SHORT).show();
//                    gameReset(img);
               }
        }
    }
    public  void gameReset(View view){
        activePlayer = 1;
        for(int i = 0 ;i<gameState.length; i++)
            gameState[i] = 2;
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}