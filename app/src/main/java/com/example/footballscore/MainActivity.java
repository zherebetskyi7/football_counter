package com.example.footballscore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Integer score_1 = 0;
    Integer score_2 = 0;

    public void displayScorTeam1(int score){
        TextView score_1 = (TextView) findViewById(R.id.score_1_team);
        score_1.setText(String.valueOf(score));
    }

    public void displayScorTeam2(int score){
        TextView score_2 = (TextView) findViewById(R.id.score_2_team);
        score_2.setText(String.valueOf(score));
    }

    public void team_1_button_score(View view){
        score_1++;
        displayScorTeam1(score_1);
    }

    public void team_2_button_score(View view){
        score_2++;
        displayScorTeam2(score_2);
    }

    public void resetAll(View view){
        score_1 = 0;
        score_2 = 0;
        displayScorTeam1(score_1);
        displayScorTeam2(score_2);
    }

    public void sendResults(View view){
        EditText team_1 = (EditText)  findViewById(R.id.first_team_name);
        EditText team_2 = (EditText)  findViewById(R.id.second_team_name);

        String email_text = "The result of match is: ";
        email_text += "\n" + team_1.getText().toString() + " " + score_1;
        email_text += " : " + score_2 + " " + team_2.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Game results");
        intent.putExtra(Intent.EXTRA_TEXT, email_text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
