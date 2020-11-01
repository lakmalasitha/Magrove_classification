package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;

    //variable
    Animation sideAnim,bottomAnim;
    ImageView backgroundImage;
    TextView poweredByLine;
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        //viewhome
        backgroundImage = findViewById(R.id.imageView);
        poweredByLine = findViewById(R.id.textView);
        //animation
           sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_animation);
           bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);


        //animation
        backgroundImage.setAnimation(sideAnim);
        poweredByLine.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),IntroActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);
    }

}