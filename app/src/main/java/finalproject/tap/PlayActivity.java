package finalproject.tap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.RelativeLayout;
import android.widget.TextView;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import java.util.concurrent.TimeUnit;


public class PlayActivity extends AppCompatActivity {


    TextView CountDownText;
    TextView GameStartCountDownText;
    private static final String FORMAT = "%02d:%02d:%02d";
    private static final String FORMAT2 = "%02d:%02d:%02d";
    int seconds , minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_main);

        //I got the countdown timer code from
        //http://stackoverflow.com/questions/10032003/how-to-make-a-countdown-timer-in-android
        //I just copied and paste it for now so I won't forget where I got it.
        //will change it a bit later.
        GameStartCountDownText = (TextView) findViewById(R.id.gamestartcountdown);
        new CountDownTimer(5000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {

                GameStartCountDownText.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                GameStartCountDownText.setText("Start Game!");
                GameStartCountDownText.setVisibility(View.INVISIBLE);
                gameCountDownTimer();



            }
        }.start();

    }




    public void gameCountDownTimer(){


        //I got the countdown timer code from
        //http://stackoverflow.com/questions/10032003/how-to-make-a-countdown-timer-in-android
        //I just copied and paste it for now so I won't forget where I got it.
        //will change it a bit later.
        CountDownText = (TextView) findViewById(R.id.countdowntimer);
        CountDownText.setVisibility(View.VISIBLE);

        new CountDownTimer(60000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {

                CountDownText.setText(""+String.format(FORMAT2,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                CountDownText.setText("Game Over!");
            }
        }.start();
    }

}
