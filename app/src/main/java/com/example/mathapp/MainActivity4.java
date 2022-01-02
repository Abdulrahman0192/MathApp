package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity4 extends AppCompatActivity {
EditText answer;
TextView correct, incorrect, question, counter1, timer, GameRe, Counter;
Button submit, next;
CountDownTimer countDownTimer;
ColorStateList colorStateList, colorStateList1;
Random random = new Random();
int pons = random.nextInt(100);
long backPressed = 0;
int counter = 0, result = 0, num1, num2, answerHolder, c, r, playerPoints, timeDown = 10;
int a = 1;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);


    correct = findViewById(R.id.correct);
    GameRe = findViewById(R.id.GameRe);
    Counter = findViewById(R.id.Counter);
    incorrect = findViewById(R.id.incorrect);
    question = findViewById(R.id.question);
    counter1 = findViewById(R.id.counter);
    timer = findViewById(R.id.timer);
    submit = findViewById(R.id.submit);
    next = findViewById(R.id.Next);
    answer = findViewById(R.id.answer);
    colorStateList = timer.getTextColors();
    timer.setTextColor(colorStateList);
    counter1.setText("Question" + counter);

    countDownTimer = new CountDownTimer(10000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {

            timeDown--;

            timer.setText(timeDown + "");

            if (timeDown <= 5) {

                timer.setTextColor(Color.RED);

            }//end if

            else {

                timer.setTextColor(colorStateList);

            }//end else

        }//end onTick

        @Override
        public void onFinish() {
            countDownTimer.cancel();
            timeDown = 0;
            timer.setText("0");
            submit.setEnabled(false);
            next.setEnabled(true);


        }//end onFinish
    };


    updater();


}//end onCreate

public void updater() {


    timeDown = 10;
    timer.setText("0");

    Random random = new Random();

do{
    num1 = random.nextInt(20) * 2;
    num2 = random.nextInt(10);

}while(num1<=0&&num2>num1);
    countDownTimer.start();
    question.setText(num1 + "-" + num2 + "=" + "??");
    next.setEnabled(false);
    submit.setEnabled(true);
    counter++;

    counter1.setText(counter + "السؤال ");

}//end method

public void Next(View view) {

    next.setEnabled(true);
    submit.setEnabled(false);
    updater();
    GameCounter();
}//end method

public void submit(View view) {

    if (submit.isPressed() &&answer.getText().toString().isEmpty()) {

        Toast.makeText(this, "يجب عليك ان ادخال قيمة", Toast.LENGTH_SHORT).show();

    }//end if

    else {

        countDownTimer.cancel();
        timeDown = 0;
        timer.setText("0");
        answerHolder = Integer.parseInt(answer.getText().toString().trim());

        result = num1 - num2;


        if (answerHolder == result) {

            Toast.makeText(this, "true", Toast.LENGTH_SHORT).show();
            c++;
            playerPoints += pons;
            correct.setText("  " + c);
        }//end if


        else {

            Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
            r++;
            incorrect.setText("  " + r);

        }//end else


        next.setEnabled(true);
        submit.setEnabled(false);

    }//end else

}//end method

void cancelTimer() {
    if (countDownTimer != null)
        countDownTimer.cancel();
}

private void GameCounter() {

    a++;

    Counter.setText(a + "");
    GameRe.setText("/" + 10);

    if (a == 10) {


        Intent intent = new Intent(MainActivity4.this, MainActivity.class);
        intent.putExtra("correctAnswer2", c);
        startActivity(intent);

        finish();


    }//end if
}//end method

@Override
public void onBackPressed() {
    long t = System.currentTimeMillis();
    if (t - backPressed > 2000) {
        backPressed = t;
        Toast.makeText(this, "ستخسر كل تقدمك ان خرجت", Toast.LENGTH_SHORT).show();
    }//end if

    else {
        Intent intent = new Intent(MainActivity4.this, MainActivity.class);
        startActivity(intent);
        playerPoints=0;
        c=0;
        this.finish();

    }//end else

}//end method
}