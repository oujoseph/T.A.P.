package finalproject.tap;

import android.graphics.Color;
import android.graphics.Point;
import android.media.Image;
import android.net.Uri;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import android.os.Handler;

import com.facebook.CallbackManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;


public class PlayActivity extends AppCompatActivity {


    TextView CountDownText;
    TextView GameOverTexts;
    TextView TimerCountDown;
    ImageButton redbox_button;
    Button fbbutton;
    private static final String FORMAT = "%2d";
    private static final String FORMAT2 = "%02d:%02d";
    int seconds , minutes;
    //checks to see if the game is over or not
    public int check = 0;
    public static boolean timerPaused = false;
    public static int game_score = 0;
    private int bounce = 0;
    public static int pausestatus = 0;
    public long Remainingtime = 0;
    public long Remainingtime2 = 0;
    public static boolean timerResume = false;
    public static int timerstopped = 0;
    public long millisResumed = 0;
    public static boolean hasitPaused = false;

    CallbackManager callbackManager;
    ShareDialog shareDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_main);
        pausestatus = 0;
        timerResume = false;
        timerstopped = 0;
        hasitPaused = false;


        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        // this part is optional



        Button fbbutton = (Button)findViewById(R.id.fb_button);
        fbbutton.setVisibility(View.INVISIBLE);
        /*
        ImageButton pauseib = (ImageButton) findViewById(R.id.pause_button);

        pauseib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayActivity.this, Popupmenu.class));
                pausestatus = 1;
                //redbox_button = (ImageButton) findViewById(R.id.green_box);
                //redbox_button.setVisibility(View.INVISIBLE);
                redbox_button = (ImageButton) findViewById(R.id.red_box);
                redbox_button.setVisibility(View.INVISIBLE);
                redbox_button = (ImageButton) findViewById(R.id.red_box2);
                redbox_button.setVisibility(View.INVISIBLE);
                redbox_button = (ImageButton) findViewById(R.id.yellow_box);
                redbox_button.setVisibility(View.INVISIBLE);
                redbox_button = (ImageButton) findViewById(R.id.orange_box);
                redbox_button.setVisibility(View.INVISIBLE);
                redbox_button = (ImageButton) findViewById(R.id.blue_box);
                redbox_button.setVisibility(View.INVISIBLE);
                redbox_button = (ImageButton) findViewById(R.id.purple_box);
                redbox_button.setVisibility(View.INVISIBLE);
                Button rb = (Button) findViewById(R.id.restart_button);
                rb.setVisibility(View.INVISIBLE);
                Button mu = (Button) findViewById(R.id.menu_button);
                mu.setVisibility(View.INVISIBLE);

            }
        });*/


        redbox_button = (ImageButton) findViewById(R.id.red_box);
        redbox_button.setVisibility(View.INVISIBLE);
        redbox_button = (ImageButton) findViewById(R.id.red_box2);
        redbox_button.setVisibility(View.INVISIBLE);
        redbox_button = (ImageButton) findViewById(R.id.yellow_box);
        redbox_button.setVisibility(View.INVISIBLE);
        redbox_button = (ImageButton) findViewById(R.id.orange_box);
        redbox_button.setVisibility(View.INVISIBLE);
        redbox_button = (ImageButton) findViewById(R.id.blue_box);
        redbox_button.setVisibility(View.INVISIBLE);
        redbox_button = (ImageButton) findViewById(R.id.purple_box);
        redbox_button.setVisibility(View.INVISIBLE);
        Button rb = (Button) findViewById(R.id.restart_button);
        rb.setVisibility(View.INVISIBLE);
        Button mu = (Button) findViewById(R.id.menu_button);
        mu.setVisibility(View.INVISIBLE);

        GameOverTexts = (TextView) findViewById(R.id.gameover_textview);
        GameOverTexts.setVisibility(View.INVISIBLE);

        TextView scores = (TextView) findViewById(R.id.score_view);
        scores.setText("Score: " + game_score);

        ImageButton ib = (ImageButton) findViewById(R.id.green_box);
        //ib.setBackgroundColor(Color.TRANSPARENT);
        ib.setVisibility(View.INVISIBLE);
        //ib.setOnClickListener(new View.OnClickListener() {


                /*
                TextView scores = (TextView) findViewById(R.id.score_view);
                scores.setText("Score: " + game_score);
                ImageButton ib = (ImageButton) findViewById(R.id.green_box);
                Random randomizer = new Random();
                Display ssize = getWindowManager().getDefaultDisplay();
                Point screensize = new Point();
                ssize.getSize(screensize);
                int x = screensize.x;
                int y = screensize.y;

                ImageButton ib2 = (ImageButton) findViewById(R.id.red_box);
                if (game_score >= 50) {
                    ib2.setVisibility(View.VISIBLE);
                }

                if (v.equals(ib)) {
                    int xaxis = randomizer.nextInt(x - 100) + 10;
                    int yaxis = randomizer.nextInt(y - 50) + 30;
                    ib.setX(xaxis);
                    ib.setY(yaxis);

                    game_score = game_score + 10;
                }
            }
        });*/

       /* ImageButton ib2 = (ImageButton) findViewById(R.id.red_box);
        ib2.setBackgroundColor(Color.TRANSPARENT);
        ib2.setVisibility(View.INVISIBLE);

        ib2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                TextView scores = (TextView) findViewById(R.id.score_view);
                scores.setText("Score: " + game_score);
                ImageButton ib2 = (ImageButton) findViewById(R.id.red_box);
                Random randomizer2 = new Random();
                Display ssize2 = getWindowManager().getDefaultDisplay();
                Point screensize = new Point();
                ssize2.getSize(screensize);
                int x = screensize.x;
                int y = screensize.y;

                if (v.equals(ib2)) {
                   int xaxis2 = randomizer2.nextInt(x - 100) + 10;
                   int yaxis2 = randomizer2.nextInt(y - 50) + 30;
                   ib2.setX(xaxis2);
                   ib2.setY(yaxis2);
                   game_score = game_score - 5;
                }
            }
        });*/


            //I got the countdown timer code from
            //http://stackoverflow.com/questions/10032003/how-to-make-a-countdown-timer-in-android
            //I just copied and paste it for now so I won't forget where I got it.
            //will change it a bit later.
            TimerCountDown=(TextView)

            findViewById(R.id.timer_view);

            new CountDownTimer(6000,1000) { // adjust the milli seconds here

                public void onTick ( long millisUntilFinished){

                    TimerCountDown.setText("" + String.format(FORMAT,
                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                }

            public void onFinish() {
                //GameStartCountDownText.setText("Start Game!");
                TimerCountDown.setVisibility(View.INVISIBLE);
                //onRanBoxes(null);
                ImageButton ib = (ImageButton) findViewById(R.id.green_box);
                ib.setVisibility(View.VISIBLE);
                timerPaused = false;
                gameCountDownTimer();

            }
        }.start();

    }





    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.green_box:

                ImageButton ib = (ImageButton) findViewById(R.id.green_box);
                Random randomizer = new Random();
                Display ssize = getWindowManager().getDefaultDisplay();
                Point screensize = new Point();
                ssize.getSize(screensize);
                int x = screensize.x;
                int y = screensize.y;

                //ImageButton ib2 = (ImageButton) findViewById(R.id.red_box);
                //ImageButton ib4 = (ImageButton) findViewById(R.id.red_box2);



                int xaxis = randomizer.nextInt(x - 150) + 10;
                int yaxis = randomizer.nextInt(y - 350) + 10;
                ib.setX(xaxis);
                ib.setY(yaxis);

                game_score = game_score + 10;


                TextView scores = (TextView) findViewById(R.id.score_view);
                scores.setText("Score: " + game_score);
                break;

            case R.id.red_box:


                ImageButton redbox = (ImageButton) findViewById(R.id.red_box);
                Random randomizer2 = new Random();
                Display ssize2 = getWindowManager().getDefaultDisplay();
                Point screensize2 = new Point();
                ssize2.getSize(screensize2);
                int x2 = screensize2.x;
                int y2 = screensize2.y;


                int xaxis2 = randomizer2.nextInt(x2 - 150) + 10;
                int yaxis2 = randomizer2.nextInt(y2 - 350) + 10;
                redbox.setX(xaxis2);
                redbox.setY(yaxis2);


                game_score = game_score - 20;

                TextView scores2 = (TextView) findViewById(R.id.score_view);
                scores2.setText("Score: " + game_score);


                break;

            case R.id.red_box2:


            ImageButton redbox2 = (ImageButton) findViewById(R.id.red_box2);
            Random randomizer3 = new Random();
            Display ssize3 = getWindowManager().getDefaultDisplay();
            Point screensize3 = new Point();
            ssize3.getSize(screensize3);
            int x3 = screensize3.x;
            int y3 = screensize3.y;


            int xaxis3 = randomizer3.nextInt(x3 - 150) + 10;
            int yaxis3 = randomizer3.nextInt(y3 - 350) + 10;
            redbox2.setX(xaxis3);
            redbox2.setY(yaxis3);


            game_score = game_score - 20;

            TextView scores3 = (TextView) findViewById(R.id.score_view);
            scores3.setText("Score: " + game_score);


            break;

            case R.id.yellow_box:


                ImageButton redbox3 = (ImageButton) findViewById(R.id.yellow_box);
                Random randomizer4 = new Random();
                Display ssize4 = getWindowManager().getDefaultDisplay();
                Point screensize4 = new Point();
                ssize4.getSize(screensize4);
                int x4 = screensize4.x;
                int y4 = screensize4.y;


                int xaxis4 = randomizer4.nextInt(x4 - 150) + 10;
                int yaxis4 = randomizer4.nextInt(y4 - 350) + 10;
                redbox3.setX(xaxis4);
                redbox3.setY(yaxis4);


                game_score = game_score - 50;

                TextView scores4 = (TextView) findViewById(R.id.score_view);
                scores4.setText("Score: " + game_score);


                break;

            case R.id.orange_box:


                ImageButton redbox4 = (ImageButton) findViewById(R.id.yellow_box);
                Random randomizer5 = new Random();
                Display ssize5 = getWindowManager().getDefaultDisplay();
                Point screensize5 = new Point();
                ssize5.getSize(screensize5);
                int x5 = screensize5.x;
                int y5 = screensize5.y;


                int xaxis5 = randomizer5.nextInt(x5 - 150) + 10;
                int yaxis5 = randomizer5.nextInt(y5 - 350) + 10;
                redbox4.setX(xaxis5);
                redbox4.setY(yaxis5);


                game_score = game_score - 75;

                TextView scores5 = (TextView) findViewById(R.id.score_view);
                scores5.setText("Score: " + game_score);


                break;

            case R.id.blue_box:


                ImageButton redbox5 = (ImageButton) findViewById(R.id.yellow_box);
                Random randomizer6 = new Random();
                Display ssize6 = getWindowManager().getDefaultDisplay();
                Point screensize6 = new Point();
                ssize6.getSize(screensize6);
                int x6 = screensize6.x;
                int y6 = screensize6.y;


                int xaxis6 = randomizer6.nextInt(x6 - 150) + 10;
                int yaxis6 = randomizer6.nextInt(y6 - 350) + 10;
                redbox5.setX(xaxis6);
                redbox5.setY(yaxis6);


                game_score = game_score - 100;

                TextView scores6 = (TextView) findViewById(R.id.score_view);
                scores6.setText("Score: " + game_score);


                break;
            case R.id.purple_box:


                ImageButton redbox6 = (ImageButton) findViewById(R.id.purple_box);
                Random randomizer7 = new Random();
                Display ssize7 = getWindowManager().getDefaultDisplay();
                Point screensize7 = new Point();
                ssize7.getSize(screensize7);
                int x7 = screensize7.x;
                int y7 = screensize7.y;


                int xaxis7 = randomizer7.nextInt(x7 - 150) + 10;
                int yaxis7 = randomizer7.nextInt(y7 - 350) + 10;
                redbox6.setX(xaxis7);
                redbox6.setY(yaxis7);


                game_score = game_score - 200;

                TextView scores7 = (TextView) findViewById(R.id.score_view);
                scores7.setText("Score: " + game_score);


                break;
        }



            //http://stackoverflow.com/questions/21511850/android-app-that-generates-random-words-every-second-and-displays-them-on-screen

                /*new Thread(
                        new Runnable() {
                            public void run() {
                                new Timer().scheduleAtFixedRate(new TimerTask() {
                                    public void run() {

                                        // This will update your box instance without the need of a Handler


                                        ImageButton ib3 = (ImageButton) findViewById(R.id.red_box);
                                        Random randomizer2 = new Random();
                                        Display ssize2 = getWindowManager().getDefaultDisplay();
                                        Point screensize2 = new Point();
                                        ssize2.getSize(screensize2);
                                        int x2 = screensize2.x;
                                        int y2 = screensize2.y;


                                        int xaxis2 = randomizer2.nextInt(x2 - 150) + 10;
                                        int yaxis2 = randomizer2.nextInt(y2 - 350) + 10;
                                        ib3.setX(xaxis2);
                                        ib3.setY(yaxis2);


                                    }
                                }, 5000, 5000);
                            }
                        }).start();*/


        }




    public void gameCountDownTimer() {

        //I got the countdown timer code from
        //http://stackoverflow.com/questions/10032003/how-to-make-a-countdown-timer-in-android
        CountDownText = (TextView) findViewById(R.id.countdowntimer);
        CountDownText.setVisibility(View.VISIBLE);

        new CountDownTimer(61000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                if(timerstopped == 2) {
                    //resumeTimer();

                }else if (timerstopped == 1) {
                    cancel();

                }else if (timerstopped == 0 && pausestatus != 1){
                        CountDownText.setText("" + String.format(FORMAT2,
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));


                        Remainingtime = millisUntilFinished;
                        Remainingtime2 = millisUntilFinished;



                        ImageButton ib3 = (ImageButton) findViewById(R.id.red_box);
                        ImageButton ib4 = (ImageButton) findViewById(R.id.red_box2);
                        ImageButton ib5 = (ImageButton) findViewById(R.id.yellow_box);
                        ImageButton ib6 = (ImageButton) findViewById(R.id.orange_box);
                        ImageButton ib7 = (ImageButton) findViewById(R.id.blue_box);
                        ImageButton ib8 = (ImageButton) findViewById(R.id.purple_box);
                        if (game_score > 50) {

                            ib3.setVisibility(View.VISIBLE);

                        } else if (game_score < 50) {
                            ib3.setVisibility(View.INVISIBLE);
                        }

                        if (game_score > 100) {
                            ib4.setVisibility(View.VISIBLE);

                        } else if (game_score < 100) {
                            ib4.setVisibility(View.INVISIBLE);

                        }

                        if (game_score > 150) {
                            ib5.setVisibility(View.VISIBLE);
                        } else if (game_score < 150) {
                            ib5.setVisibility(View.INVISIBLE);
                        }

                        if (game_score > 200) {
                            ib6.setVisibility(View.VISIBLE);
                        } else if (game_score < 200) {
                            ib6.setVisibility(View.INVISIBLE);
                        }

                        if (game_score > 300) {
                            ib7.setVisibility(View.VISIBLE);
                        } else if (game_score < 300) {
                            ib7.setVisibility(View.INVISIBLE);
                        }

                        if (game_score > 400) {
                            ib8.setVisibility(View.VISIBLE);
                        } else if (game_score < 400) {
                            ib8.setVisibility(View.INVISIBLE);
                        }

                        if (game_score > 50) {


                            Random randomizer2 = new Random();
                            Display ssize2 = getWindowManager().getDefaultDisplay();
                            Point screensize2 = new Point();
                            ssize2.getSize(screensize2);
                            int x2 = screensize2.x;
                            int y2 = screensize2.y;


                            int xaxis2 = randomizer2.nextInt(x2 - 150) + 10;
                            int yaxis2 = randomizer2.nextInt(y2 - 350) + 10;
                            ib3.setX(xaxis2);
                            ib3.setY(yaxis2);

                            if (game_score > 100) {
                                int xaxis3 = randomizer2.nextInt(x2 - 150) + 10;
                                int yaxis3 = randomizer2.nextInt(y2 - 350) + 10;
                                ib4.setX(xaxis3);
                                ib4.setY(yaxis3);
                            }
                            if (game_score > 150) {
                                int xaxis4 = randomizer2.nextInt(x2 - 150) + 10;
                                int yaxis4 = randomizer2.nextInt(y2 - 350) + 10;
                                ib5.setX(xaxis4);
                                ib5.setY(yaxis4);
                            }
                            if (game_score > 200) {
                                int xaxis5 = randomizer2.nextInt(x2 - 150) + 10;
                                int yaxis5 = randomizer2.nextInt(y2 - 350) + 10;
                                ib6.setX(xaxis5);
                                ib6.setY(yaxis5);
                            }
                            if (game_score > 300) {
                                int xaxis6 = randomizer2.nextInt(x2 - 150) + 10;
                                int yaxis6 = randomizer2.nextInt(y2 - 350) + 10;
                                ib7.setX(xaxis6);
                                ib7.setY(yaxis6);
                            }
                            if (game_score > 400) {
                                int xaxis7 = randomizer2.nextInt(x2 - 150) + 10;
                                int yaxis7 = randomizer2.nextInt(y2 - 350) + 10;
                                ib8.setX(xaxis7);
                                ib8.setY(yaxis7);
                            }
                        }
                    }
                }



            public void onFinish() {
                //CountDownText.setText("Game Over!");

                check = 1; //Game is over.
                Button facebookPost = (Button) findViewById(R.id.fb_button);
                facebookPost.setVisibility(View.VISIBLE);
                ImageButton ib = (ImageButton) findViewById(R.id.green_box);
                ib.setVisibility(View.INVISIBLE);
                ImageButton redb = (ImageButton) findViewById(R.id.red_box);
                redb.setVisibility(View.INVISIBLE);
                redb = (ImageButton) findViewById(R.id.red_box2);
                redb.setVisibility(View.INVISIBLE);
                redb = (ImageButton) findViewById(R.id.yellow_box);
                redb.setVisibility(View.INVISIBLE);
                redb = (ImageButton) findViewById(R.id.orange_box);
                redb.setVisibility(View.INVISIBLE);
                redb = (ImageButton) findViewById(R.id.blue_box);
                redb.setVisibility(View.INVISIBLE);
                redb = (ImageButton) findViewById(R.id.purple_box);
                redb.setVisibility(View.INVISIBLE);
                CountDownText.setVisibility(View.INVISIBLE);
                GameOverTexts = (TextView) findViewById(R.id.gameover_textview);
                //game_score = game_score - 5;
                GameOverTexts.setText(Html.fromHtml("<p>Game Over!</p>" + "<p>Final Score: </p>" + game_score));
                GameOverTexts.setVisibility(View.VISIBLE);
                Button rb = (Button) findViewById(R.id.restart_button);
                rb.setVisibility(View.VISIBLE);
                Button mu = (Button) findViewById(R.id.menu_button);
                mu.setVisibility(View.VISIBLE);
            }


        }.start();


    }




    public void resumeGame(){

                        ImageButton ib3 = (ImageButton) findViewById(R.id.red_box);
                        ImageButton ib4 = (ImageButton) findViewById(R.id.red_box2);
                        ImageButton ib5 = (ImageButton) findViewById(R.id.yellow_box);
                        ImageButton ib6 = (ImageButton) findViewById(R.id.orange_box);
                        ImageButton ib7 = (ImageButton) findViewById(R.id.blue_box);
                        ImageButton ib8 = (ImageButton) findViewById(R.id.purple_box);
                        if (game_score > 50) {

                            ib3.setVisibility(View.VISIBLE);

                        } else if (game_score < 50) {
                            ib3.setVisibility(View.INVISIBLE);
                        }

                        if (game_score > 100) {
                            ib4.setVisibility(View.VISIBLE);

                        } else if (game_score < 100) {
                            ib4.setVisibility(View.INVISIBLE);

                        }

                        if (game_score > 150) {
                            ib5.setVisibility(View.VISIBLE);
                        } else if (game_score < 150) {
                            ib5.setVisibility(View.INVISIBLE);
                        }

                        if (game_score > 200) {
                            ib6.setVisibility(View.VISIBLE);
                        } else if (game_score < 200) {
                            ib6.setVisibility(View.INVISIBLE);
                        }

                        if (game_score > 300) {
                            ib7.setVisibility(View.VISIBLE);
                        } else if (game_score < 300) {
                            ib7.setVisibility(View.INVISIBLE);
                        }

                        if (game_score > 400) {
                            ib8.setVisibility(View.VISIBLE);
                        } else if (game_score < 400) {
                            ib8.setVisibility(View.INVISIBLE);
                        }

                        if (game_score > 50) {


                            Random randomizer2 = new Random();
                            Display ssize2 = getWindowManager().getDefaultDisplay();
                            Point screensize2 = new Point();
                            ssize2.getSize(screensize2);
                            int x2 = screensize2.x;
                            int y2 = screensize2.y;


                            int xaxis2 = randomizer2.nextInt(x2 - 150) + 10;
                            int yaxis2 = randomizer2.nextInt(y2 - 350) + 10;
                            ib3.setX(xaxis2);
                            ib3.setY(yaxis2);

                            if (game_score > 100) {
                                int xaxis3 = randomizer2.nextInt(x2 - 150) + 10;
                                int yaxis3 = randomizer2.nextInt(y2 - 350) + 10;
                                ib4.setX(xaxis3);
                                ib4.setY(yaxis3);
                            }
                            if (game_score > 150) {
                                int xaxis4 = randomizer2.nextInt(x2 - 150) + 10;
                                int yaxis4 = randomizer2.nextInt(y2 - 350) + 10;
                                ib5.setX(xaxis4);
                                ib5.setY(yaxis4);
                            }
                            if (game_score > 200) {
                                int xaxis5 = randomizer2.nextInt(x2 - 150) + 10;
                                int yaxis5 = randomizer2.nextInt(y2 - 350) + 10;
                                ib6.setX(xaxis5);
                                ib6.setY(yaxis5);
                            }
                            if (game_score > 300) {
                                int xaxis6 = randomizer2.nextInt(x2 - 150) + 10;
                                int yaxis6 = randomizer2.nextInt(y2 - 350) + 10;
                                ib7.setX(xaxis6);
                                ib7.setY(yaxis6);
                            }
                            if (game_score > 400) {
                                int xaxis7 = randomizer2.nextInt(x2 - 150) + 10;
                                int yaxis7 = randomizer2.nextInt(y2 - 350) + 10;
                                ib8.setX(xaxis7);
                                ib8.setY(yaxis7);
                            }
                        }
    }
    public void finishGame(){
        check = 1; //Game is over.
        ImageButton ib = (ImageButton) findViewById(R.id.green_box);
        ib.setVisibility(View.INVISIBLE);
        ImageButton redb = (ImageButton) findViewById(R.id.red_box);
        redb.setVisibility(View.INVISIBLE);
        redb = (ImageButton) findViewById(R.id.red_box2);
        redb.setVisibility(View.INVISIBLE);
        redb = (ImageButton) findViewById(R.id.yellow_box);
        redb.setVisibility(View.INVISIBLE);
        redb = (ImageButton) findViewById(R.id.orange_box);
        redb.setVisibility(View.INVISIBLE);
        redb = (ImageButton) findViewById(R.id.blue_box);
        redb.setVisibility(View.INVISIBLE);
        redb = (ImageButton) findViewById(R.id.purple_box);
        redb.setVisibility(View.INVISIBLE);
        CountDownText.setVisibility(View.INVISIBLE);
        GameOverTexts = (TextView) findViewById(R.id.gameover_textview);
        //game_score = game_score - 5;
        GameOverTexts.setText(Html.fromHtml("<p>Game Over!</p>" + "<p>Final Score: </p>" + game_score));
        GameOverTexts.setVisibility(View.VISIBLE);
        Button rb = (Button) findViewById(R.id.restart_button);
        rb.setVisibility(View.VISIBLE);
        Button mu = (Button) findViewById(R.id.menu_button);
        mu.setVisibility(View.VISIBLE);
    }
    //trying to implement this
    //http://stackoverflow.com/questions/31716152/how-do-i-make-my-buttons-show-up-in-random-places-until-the-button-is-pressed
/*    public void onRanBoxes(View v){

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
            int yaxis = randomizer.nextInt(y - 50) + 30;
            ib.setX(xaxis);
            ib.setY(yaxis);
            ib.setVisibility(View.VISIBLE);

            if (game_score >= 50) {
                ImageButton red_box = (ImageButton) findViewById(R.id.green_box);
                red_box.setImageResource(R.drawable.redbox);
                game_score = game_score - 15;
            } else if (game_score < 50) {
                ImageButton green_box = (ImageButton) findViewById(R.id.green_box);
                green_box.setImageResource(R.drawable.greenbox);
                game_score = game_score + 10;
            }
        }

    }*/




    @Override
    public void onResume(){
        super.onResume();


        CountDownText = (TextView) findViewById(R.id.countdowntimer);
        CountDownText.setVisibility(View.VISIBLE);
        if(timerResume) {
            if(hasitPaused) {
                millisResumed = Remainingtime2;
            }else if(!hasitPaused) {
                millisResumed = Remainingtime;
            }
            new CountDownTimer(millisResumed, 1000) {
                public void onTick(long millisUntilFinished) {
                    if (timerstopped == 1) {
                        cancel();
                    } else {
                        if (timerstopped == 2) {
                            CountDownText.setText("" + String.format(FORMAT2,
                                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                            TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));

                            Remainingtime2 = millisUntilFinished;

                            resumeGame();
                        }

                    }
                }
                @Override
                public void onFinish() {
                    finishGame();
                }
            }.start();

        }
    }


    @Override
        public void onPause(){
        super.onPause();


    }

    public void pausestuff() {
        pausestatus = 1;
        timerPaused = true;
        timerResume = false;
        timerstopped = 1;
        hasitPaused = true;

        //redbox_button = (ImageButton) findViewById(R.id.green_box);
        //redbox_button.setVisibility(View.INVISIBLE);
        redbox_button = (ImageButton) findViewById(R.id.red_box);
        redbox_button.setVisibility(View.INVISIBLE);
        redbox_button = (ImageButton) findViewById(R.id.red_box2);
        redbox_button.setVisibility(View.INVISIBLE);
        redbox_button = (ImageButton) findViewById(R.id.yellow_box);
        redbox_button.setVisibility(View.INVISIBLE);
        redbox_button = (ImageButton) findViewById(R.id.orange_box);
        redbox_button.setVisibility(View.INVISIBLE);
        redbox_button = (ImageButton) findViewById(R.id.blue_box);
        redbox_button.setVisibility(View.INVISIBLE);
        redbox_button = (ImageButton) findViewById(R.id.purple_box);
        redbox_button.setVisibility(View.INVISIBLE);
        //Button rb = (Button) findViewById(R.id.restart_button);
        //rb.setVisibility(View.INVISIBLE);
        //Button mu = (Button) findViewById(R.id.menu_button);
        //mu.setVisibility(View.INVISIBLE);
    }


    public void backToMenu(View v) {
        Intent intent = new Intent(PlayActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        timerResume = false;
        timerstopped = 0;
        game_score = 0;
        finish();
        startActivity(intent);
    }

    public void restartGame(View v) {
        timerResume = false;
        timerstopped = 0;
        game_score = 0;
        hasitPaused = false;
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void pauseMenu(View v){
        Intent intent = new Intent(PlayActivity.this, Popupmenu.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        pausestuff();
        startActivity(intent);
    }


    public void fbPost(View v){
        String string = "I got a score of " + game_score + " on this sweet new game made by Joseph Ou and Kevin Yen!";
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle("T.A.P.")
                    .setContentDescription(string)
                    .setContentUrl(Uri.parse("http://tapallthethings.com"))
                    .build();
            shareDialog.show(linkContent);
        }
    }
}
