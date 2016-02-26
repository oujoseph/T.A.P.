package finalproject.tap;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


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
