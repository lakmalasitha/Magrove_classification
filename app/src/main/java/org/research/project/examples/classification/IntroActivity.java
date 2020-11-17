package org.research.project.examples.classification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import org.tensorflow.lite.examples.classification.R;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPageAdapter introViewPageAdapter;
    TabLayout tabIndicator;
    Button btnNext;
    int position = 0;
    Button btnGetstarted;
    Animation btnanim;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //make activity on full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        if(restorepreData()){
//            Intent galary_capture = new Intent(getApplicationContext(),Galary_Capture.class);
//            startActivity(galary_capture);
//            finish();
//        }

        setContentView(R.layout.activity_intro);



        //ini views
        btnNext=findViewById(R.id.btn_next);
         btnGetstarted=findViewById(R.id.btn_getstarted);
        tabIndicator = findViewById(R.id.tab_indicator);
        btnanim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.btn_animation_getstart);




        //fill list screen
        List<ScreemItem> mList = new ArrayList<>();
        mList.add(new ScreemItem("What are Mangroves?","There are about 80 different species of mangrove trees. All of these trees grow in areas with low-oxygen soil, where slow-moving waters allow fine sediments to accumulate.",R.drawable.acanthus_illicifolius));
        mList.add(new ScreemItem("Why Mangroves?","There are about 80 different species of mangrove trees. All of these trees grow in areas with low-oxygen soil, where slow-moving waters allow fine sediments to accumulate.",R.drawable.aegicerus_corniculatum));
        mList.add(new ScreemItem("How to Identify?","There are about 80 different species of mangrove trees. All of these trees grow in areas with low-oxygen soil, where slow-moving waters allow fine sediments to accumulate.",R.drawable.scyphiphora_hydrophylacea));



        //setup screen page
        screenPager = (ViewPager) findViewById(R.id.screen_viewpager);
        introViewPageAdapter= new IntroViewPageAdapter(this,mList);
        screenPager.setAdapter(introViewPageAdapter);

        //setup tablayout with view

        tabIndicator.setupWithViewPager(screenPager);

        //next button click listner
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = screenPager.getCurrentItem();
                if(position<mList.size()){
                    position++;
                    screenPager.setCurrentItem(position);
                }
                if(position == mList.size()-1){
                    //TODO: show the GETSTARTED Button and hide the indicator and the next button

                    loadLastScreen();

                }
            }
        });
        //tablayout add change listner
        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() ==mList.size()-1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btnGetstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent galary_capture = new Intent(getApplicationContext(),Galary_Capture.class);
                startActivity(galary_capture);

                //saved the reched users data
                //savePrefsData();
                finish();

            }
        });

    }

//    private boolean restorepreData() {
//        SharedPreferences pref = getApplicationContext().getSharedPreferences("myprefs",MODE_PRIVATE);
//        Boolean isIntroActivityOpenBefore = pref.getBoolean("isIntroOpened",false);
//        return isIntroActivityOpenBefore;
//    }
//
//    private void savePrefsData() {
//        SharedPreferences pref = getApplicationContext().getSharedPreferences("myprefs",MODE_PRIVATE);
//        SharedPreferences.Editor editor =pref.edit();
//        editor.putBoolean("isIntroOpened",true);
//        editor.commit();
//
//    }

    //show the getsrated button
    private void loadLastScreen() {
        btnNext.setVisibility(View.INVISIBLE);
        btnGetstarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        //TODO:ADD an animation the getstarted button

        //create the animation for the button
        btnGetstarted.setAnimation(btnanim);


    }
}