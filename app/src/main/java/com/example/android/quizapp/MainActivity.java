package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    // Question 1
    EditText qn1_answer;
    // Question 2
    RadioButton qn2_answer1;
    // Question 3
    CheckBox qn3_answer1;
    CheckBox qn3_answer2;
    CheckBox qn3_answer3;
    CheckBox qn3_answer4;
    // Question 4
    RadioButton qn4_answer1;
    // Question 5
    CheckBox qn5_answer1;
    CheckBox qn5_answer2;
    CheckBox qn5_answer3;
    CheckBox qn5_answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
    }
    public void submitAnswers(View view){
      CharSequence resultsDisplay;

      int answer1_score;
      int answer2_score;
      int answer3_score;
      int answer4_score;
      int answer5_score;
      int finalScore;

      // Answer 1 is any name(String)
        String answer1;
        answer1_score = 1;

        // Answer 2 is answer 1
        Boolean answer2;

        qn2_answer1 = (RadioButton) this.findViewById(R.id.qn2_answer1);
        answer2 = qn2_answer1.isChecked();
        if (answer2) {
            answer2_score = 1;
        } else {
            answer2_score = 0;
        }
        // Answer 3 is answer1 & 3
        Boolean answer3_answer1;
        Boolean answer3_answer2;
        Boolean answer3_answer3;
        Boolean answer3_answer4;
        qn3_answer1 = (CheckBox) this.findViewById(R.id.qn3_answer1);
        qn3_answer2 = (CheckBox) this.findViewById(R.id.qn3_answer2);
        qn3_answer3 = (CheckBox) this.findViewById(R.id.qn3_answer3);
        qn3_answer4 = (CheckBox) this.findViewById(R.id.qn3_answer4);
        answer3_answer1 = qn3_answer1.isChecked();
        answer3_answer2 = qn3_answer2.isChecked();
        answer3_answer3 = qn3_answer3.isChecked();
        answer3_answer4 = qn3_answer4.isChecked();
        if (answer3_answer1 && !answer3_answer2 && answer3_answer3 && !answer3_answer4) {
            answer3_score = 1;
        } else {
            answer3_score = 0;
        }
        // Answer 4 is answer1
        Boolean answer4;
        qn4_answer1 = (RadioButton) this.findViewById(R.id.qn4_answer1);
        answer4 = qn4_answer1.isChecked();
        if (answer4) {
            answer4_score = 1;
        } else {
            answer4_score = 0;
        }
        // Answer 5 is answer 2&4
        Boolean answer5_answer1;
        Boolean answer5_answer2;
        Boolean answer5_answer3;
        Boolean answer5_answer4;
        qn5_answer1 = (CheckBox) this.findViewById(R.id.qn5_answer1);
        qn5_answer2 = (CheckBox) this.findViewById(R.id.qn5_answer2);
        qn5_answer3 = (CheckBox) this.findViewById(R.id.qn5_answer3);
        qn5_answer4 = (CheckBox) this.findViewById(R.id.qn5_answer4);
        answer5_answer1 = qn5_answer1.isChecked();
        answer5_answer2 = qn5_answer2.isChecked();
        answer5_answer3 = qn5_answer3.isChecked();
        answer5_answer4 = qn5_answer4.isChecked();
        if (!answer5_answer1 && answer5_answer2 && !answer5_answer3 && answer5_answer4) {
            answer5_score = 1;
        } else {
            answer5_score = 0;
        }
        // Final Score
        finalScore = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score;
        if (finalScore == 5) {
            resultsDisplay = "Excellent! You got all answers correct";
        } else {
            resultsDisplay = "Try again. You got " + finalScore + " out of 5 correct answers";

        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultsDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();



    }

    public void reset(View view) {
       TextView editText = findViewById(R.id.qn1);
        editText.setText("");

        RadioGroup radioGroup = findViewById(R.id.qn2);
        radioGroup.clearCheck();

        CheckBox checkBox = findViewById(R.id.qn3_answer1);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.qn3_answer2);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.qn3_answer3);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.qn3_answer4);
        checkBox.setChecked(false);

         radioGroup = findViewById(R.id.qn4);
        radioGroup.clearCheck();

        checkBox = findViewById(R.id.qn5_answer1);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.qn5_answer2);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.qn5_answer3);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.qn5_answer4);
        checkBox.setChecked(false);

    }
}