package finalproject.tap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import finalproject.tap.PlayActivity;
public class Popupmenu extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_main);

        DisplayMetrics disMet = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(disMet);

        int width = disMet.widthPixels;
        int height = disMet.heightPixels;

        getWindow().setLayout((int) (width), (int) (height));




    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();
    }


    public void bMenu(View v) {
        Intent intent = new Intent(Popupmenu.this, MainActivity.class);
        PlayActivity.game_score = 0;
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        finish();
        startActivity(intent);
    }







    public void resumeGame(View v){

        PlayActivity.pausestatus = 0;
        PlayActivity.timerPaused = false;
        PlayActivity.timerResume = true;
        PlayActivity.timerstopped = 2;
        //Activity PlayActivity.onResume();

        //PlayActivity.resumeTimer();
        //finish();
        //Intent intent = new Intent(this, Popupmenu.class);
        //Intent intent = new Intent(Popupmenu.this, PlayActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //|  Intent.FLAG_ACTIVITY_SINGLE_TOP);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        //intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        //intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        //startActivity(intent);

        finish();
    }

    public void restartGame(View v) {
        Intent intent = new Intent(Popupmenu.this, PlayActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PlayActivity.timerResume = false;
        PlayActivity.game_score = 0;
        finish();
        startActivity(intent);
    }


}
