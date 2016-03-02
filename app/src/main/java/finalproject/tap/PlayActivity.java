package finalproject.tap;

import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.Display;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class PlayActivity extends AppCompatActivity {


    TextView CountDownText;
    TextView GameOverTexts;
    TextView TimerCountDown;
    private static final String FORMAT = "%2d";
    private static final String FORMAT2 = "%02d:%02d:%02d";
    int seconds , minutes;
    //checks to see if the game is over or not
    private int check = 0;
    public int game_score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_main);

        Button rb = (Button) findViewById(R.id.restart_button);
        rb.setVisibility(View.INVISIBLE);
        Button mu = (Button) findViewById(R.id.menu_button);
        mu.setVisibility(View.INVISIBLE);

        GameOverTexts = (TextView) findViewById(R.id.gameover_textview);
        GameOverTexts.setVisibility(View.INVISIBLE);

        TextView scores = (TextView) findViewById(R.id.score_view);
        scores.setText("Score: " + game_score);

        ImageButton ib = (ImageButton) findViewById(R.id.green_box);
        ib.setBackgroundColor(Color.TRANSPARENT);
        ib.setVisibility(View.INVISIBLE);
        //I got the countdown timer code from
        //http://stackoverflow.com/questions/10032003/how-to-make-a-countdown-timer-in-android
        //I just copied and paste it for now so I won't forget where I got it.
        //will change it a bit later.
        TimerCountDown = (TextView) findViewById(R.id.timer_view);
        new CountDownTimer(6000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {

                TimerCountDown.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                //GameStartCountDownText.setText("Start Game!");
                TimerCountDown.setVisibility(View.INVISIBLE);
                gameCountDownTimer();



            }
        }.start();

    }




    public void gameCountDownTimer(){


        onRanBoxes(null);
        /*
        ImageButton ib = (ImageButton) findViewById(R.id.green_box);
        Random randomizer = new Random();
        int xaxis = randomizer.nextInt(450);
        int yaxis = randomizer.nextInt(600);
        ib.setX(xaxis);
        ib.setY(yaxis);


        ib.setVisibility(View.VISIBLE);
        */
        //I got the countdown timer code from
        //http://stackoverflow.com/questions/10032003/how-to-make-a-countdown-timer-in-android
        //I just copied and paste it for now so I won't forget where I got it.
        //will change it a bit later.
        CountDownText = (TextView) findViewById(R.id.countdowntimer);
        CountDownText.setVisibility(View.VISIBLE);

        new CountDownTimer(61000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {

                CountDownText.setText(""+String.format(FORMAT2,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                //CountDownText.setText("Game Over!");
                check = 1; //Game is over.
                ImageButton ib = (ImageButton) findViewById(R.id.green_box);
                ib.setVisibility(View.INVISIBLE);
                CountDownText.setVisibility(View.INVISIBLE);
                GameOverTexts = (TextView) findViewById(R.id.gameover_textview);
                game_score = game_score - 5;
                GameOverTexts.setText(Html.fromHtml("<p>Game Over!</p>" + "<p>Final Score: </p>" + game_score));
                GameOverTexts.setVisibility(View.VISIBLE);
                Button rb = (Button) findViewById(R.id.restart_button);
                rb.setVisibility(View.VISIBLE);
                Button mu = (Button) findViewById(R.id.menu_button);
                mu.setVisibility(View.VISIBLE);
            }
        }.start();
    }


    //trying to implement this
    //http://stackoverflow.com/questions/31716152/how-do-i-make-my-buttons-show-up-in-random-places-until-the-button-is-pressed
    public void onRanBoxes(View v){


        if(check == 0) {

            TextView scores = (TextView) findViewById(R.id.score_view);
            scores.setText("Score: " + game_score);
            ImageButton ib = (ImageButton) findViewById(R.id.green_box);
            Random randomizer = new Random();


            //how i got screen size
            //http://stackoverflow.com/questions/19028990/android-imageview-in-random-position-with-onclicklistener
            //come back to:
            //http://stackoverflow.com/questions/2902640/android-get-the-screen-resolution-pixels-as-integer-values

            Display ssize = getWindowManager().getDefaultDisplay();
            Point screensize = new Point();
            ssize.getSize(screensize);
            int x = screensize.x;
            int y = screensize.y;

            int xaxis = randomizer.nextInt(x - 100) + 50;
            int yaxis = randomizer.nextInt(y - 50) + 5;
            ib.setX(xaxis);
            ib.setY(yaxis);


            ib.setVisibility(View.VISIBLE);
            game_score = game_score + 5;

        }else {
            
            //GameStartCountDownText = (TextView) findViewById(R.id.gamestartcountdown);
            //GameStartCountDownText.setText(Html.fromHtml("<p>Game Over!</p>" + "<p>Final Score: </p>" + game_score));
            //GameStartCountDownText.setVisibility(View.VISIBLE);
        }

    }

    public void backToMenu(View v){
        Intent intent = new Intent(PlayActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
