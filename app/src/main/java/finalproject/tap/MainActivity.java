package finalproject.tap;


import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView mainlistView;

    private ImageView animatedimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        final ImageButton playGameButton = (ImageButton) findViewById(R.id.play_button);
//        final ImageButton instructions = (ImageButton) findViewById(R.id.instruction_button);
//        final ImageButton credits = (ImageButton) findViewById(R.id.Credit);
        animatedimg = (ImageView) findViewById(R.id.animatedimg);
        animatedimg.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable)animatedimg.getBackground()).start();

            }
        });


        MAList list_data[] = new MAList[]
                {
                        new MAList(R.id.play_button),
                        new MAList(R.id.instruction_button),
                        new MAList(R.id.Credit),
                        new MAList(R.id.settings_button)
        };

        MAListAdapter adapter = new MAListAdapter(this, R.layout.activity_main_list_layout, list_data);
        mainlistView = (ListView)findViewById(R.id.mainListView);
        mainlistView.setAdapter(adapter);

        mainlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)playGame(view);
                if (position == 1)instructionActivity(view);
                if (position == 2)creditActivity(view);
                if (position == 3)settingsActivity(view);
                String item = ("starting activity " + position);
                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
            }
        });

    }


    private View.OnClickListener playGamePressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            playGame(v);
        }
    };
    private View.OnClickListener instructionPressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            instructionActivity(v);
        }
    };
    private View.OnClickListener creditPressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            creditActivity(v);
        }
    };

    //Goes to Play Activity when Play button is pressed
    public void playGame(View v){
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }

    //Goes to Instruction Activity when Instruction button is pressed
    public void instructionActivity(View v){
        Intent intent = new Intent(this, InstructionActivity.class);
        startActivity(intent);
    }

    //Goes to Credit Activity when Credit button is pressed
    public void creditActivity(View v){
        Intent intent = new Intent(this, CreditActivity.class);
        startActivity(intent);
    }

    //Goes to Credit Activity when Credit button is pressed
    public void settingsActivity(View v){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
