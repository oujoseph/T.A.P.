package finalproject.tap;


import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageButton playGameButton = (ImageButton) findViewById(R.id.play_button);
        final ImageButton instructions = (ImageButton) findViewById(R.id.instruction_button);
        final ImageButton credits = (ImageButton) findViewById(R.id.Credit);
        playGameButton.setOnClickListener(playGamePressed);
        instructions.setOnClickListener(instructionPressed);
        credits.setOnClickListener(creditPressed);
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

}
