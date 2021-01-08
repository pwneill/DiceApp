package com.pwneill.rollthedice;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView diceImage1 = findViewById(R.id.imgDice1);
        ImageView diceImage2 = findViewById(R.id.imgDice2);

        Integer[] diceImages = {
          R.drawable.dice1,
          R.drawable.dice2,
          R.drawable.dice3,
          R.drawable.dice4,
          R.drawable.dice5,
          R.drawable.dice6
        };

        int myBox = 10;

        float myFloatBox = .2f;

        double doubleBox = 3.34578923;

        Button btnRoll = findViewById(R.id.btnRollDice);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random randomObj = new Random();

                int myRandomNumb = randomObj.nextInt(6);
                diceImage1.setImageResource(diceImages[myRandomNumb]);

                myRandomNumb = randomObj.nextInt(6);
                diceImage2.setImageResource(diceImages[myRandomNumb]);

                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImage1);

                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImage2);

                mp.start();
            }
        });



    }
}