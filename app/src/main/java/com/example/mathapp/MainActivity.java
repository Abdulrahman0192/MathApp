package com.example.mathapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

public static final String SHARED_PRE = "sharedPre";
public static final String HIGH_SCORE = "highScore";
public static final String HIGH_SCORE1 = "highScore2";
public static final String HIGH_SCORE2 = "highScore3";
public static final String HIGH_SCORE3 = "highScore4";
public static int getAnswers;
public static int getAnswers1;
public static int getAnswers2;
public static int getAnswers3;
Button AdditionGameBtn, MultiplyGameBtn, SubtractGameBtn, DivisionGameBtn, TwitterBtn, InstagramBtn;
TextView result, result1, result2, result3;
int increment = 0;
int increment1 = 0;
int increment2 = 0;
int increment3 = 0;
int increment4 = 0;
CardView AdditionMotionEffect;
CardView MultiplyMotionEffect;
CardView SubtractMotionEffect;
CardView DivisionMotionEffect;
long backPressedTime =
        0;
Animation animateMain;

@Override

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    gettingID();
    LoadPoints();
    gettingData();
    gamesButtons();
    SocialMediaAccounts(TwitterBtn, InstagramBtn);
}//end onCreate

public void UpdatePoints(int score, int score1, int score2, int score3, int score4) {
    increment = score;
    increment1 = score1;
    increment2 = score2;
    increment3 = score3;
    increment4 = score4;
    result.setText(increment + "+");
    result1.setText(increment1 + "+");
    result2.setText(increment2 + "+");
    result3.setText(increment3 + "+");
    SharedPreferences sp = getSharedPreferences(SHARED_PRE, MODE_PRIVATE);
    SharedPreferences.Editor editor = sp.edit();
    editor.putInt(HIGH_SCORE, increment);
    editor.putInt(HIGH_SCORE1, increment1);
    editor.putInt(HIGH_SCORE2, increment2);
    editor.putInt(HIGH_SCORE3, increment3);
    editor.apply();

}//end method


public void LoadPoints() {
    SharedPreferences sp = getSharedPreferences(SHARED_PRE, MODE_PRIVATE);
    increment = sp.getInt(HIGH_SCORE, 0);
    increment1 = sp.getInt(HIGH_SCORE1, 0);
    increment2 = sp.getInt(HIGH_SCORE2, 0);
    increment3 = sp.getInt(HIGH_SCORE3, 0);
    result.setText(increment + "+");
    result1.setText(increment1 + "+");
    result2.setText(increment2 + "+");
    result3.setText(increment3 + "+");
}//end method

@Override
public void onBackPressed() {
    long t = System.currentTimeMillis();
    if (t - backPressedTime > 2000) {
        backPressedTime = t;
        Toast.makeText(this, "أضغط مره اخرى للخروج من التطبيق",
                Toast.LENGTH_SHORT).show();
    } else {
        super.onBackPressed();
    }
}//end method

public void gettingID() {


    AdditionGameBtn = findViewById(R.id.additionGame);
    DivisionGameBtn = findViewById(R.id.divisionGame);
    SubtractGameBtn = findViewById(R.id.subtractGame);
    MultiplyGameBtn = findViewById(R.id.multipleGame);
    AdditionMotionEffect = findViewById(R.id.fadeHim);
    DivisionMotionEffect = findViewById(R.id.fadeHim4);
    SubtractMotionEffect = findViewById(R.id.fadeHim3);
    MultiplyMotionEffect = findViewById(R.id.fadeHim2);
    TwitterBtn = findViewById(R.id.TwitterAccount);
    InstagramBtn = findViewById(R.id.InstagramAccount);
    result = findViewById(R.id.result);
    result1 = findViewById(R.id.result1);
    result2 = findViewById(R.id.result2);
    result3 = findViewById(R.id.result3);
    animateMain = AnimationUtils.loadAnimation(this, R.anim.animate_main);

}//edn method

public void gettingData() {
    Intent intent = getIntent();
    getAnswers = intent.getIntExtra("correctAnswer", 0);
    getAnswers1 = intent.getIntExtra("correctAnswer1", 0);
    getAnswers2 = intent.getIntExtra("correctAnswer2", 0);
    getAnswers3 = intent.getIntExtra("correctAnswer3", 0);

    if ((getAnswers == 10)) {
        increment++;
        UpdatePoints(increment, increment1, increment2, increment3, increment4);

    }//end if
    if ((getAnswers1 == 10)) {
        increment1++;
        UpdatePoints(increment, increment1, increment2, increment3, increment4);

    }//end if
    if ((getAnswers2 == 10)) {
        increment2++;
        UpdatePoints(increment, increment1, increment2, increment3, increment4);

    }//end if

    if ((getAnswers3 == 10)) {
        increment3++;
        UpdatePoints(increment, increment1, increment2, increment3, increment4);

    }//end if

}//end method

public void gamesButtons() {
    AdditionGameBtn.setOnClickListener(v->{

        AdditionMotionEffect.startAnimation(animateMain);
        Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent1);
        finish();


    });


    SubtractGameBtn.setOnClickListener(v->{

        SubtractMotionEffect.startAnimation(animateMain);
        Intent intent1 = new Intent(MainActivity.this, MainActivity4.class);
        startActivity(intent1);
        finish();


    });

    MultiplyGameBtn.setOnClickListener(v->{

        MultiplyMotionEffect.startAnimation(animateMain);
        Intent intent1 = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(intent1);
        finish();


    });

    DivisionGameBtn.setOnClickListener(v->{

        DivisionMotionEffect.startAnimation(animateMain);
        Intent intent1 = new Intent(MainActivity.this, MainActivity5.class);
        startActivity(intent1);
        finish();


    });

}//end method

public void SocialMediaAccounts(Button Twitter, Button Instagram) {

    Twitter.setOnClickListener(v->{
     Twitter.startAnimation(animateMain);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://twitter.com/d7om37"));

        startActivity(intent);

    });

    Instagram.setOnClickListener(v->{
        Instagram.startAnimation(animateMain);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse( "http://instagram.com/d7om1059" ));

        startActivity(intent);
    });



















}//end method

}//end class