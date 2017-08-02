package shapy.appz;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mToggle;

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    Dialog dialog;
    TextView closeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        createDialog();
        Button dialogButton = (Button) findViewById(R.id.dialogbtn);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();

            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        TextView shareTextView = (TextView) findViewById(R.id.share);
        shareTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                myIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello!");
                myIntent.putExtra(Intent.EXTRA_TEXT, "My highscore in Quizzi is very high! I bet you can't beat me except you are cleverer than me. Download the app now!");
                startActivity(Intent.createChooser(myIntent, "Share with:"));
            }
        });

        mQuestionLibrary.shuffle();

        setSupportActionBar((Toolbar) findViewById(R.id.nav_action));
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Able to see the Navigation Burger "Button"

        ((NavigationView) findViewById(R.id.nv1)).setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_stats:
                        startActivity(new Intent(QuizActivity.this, Menu2.class));
                        break;
                    case R.id.nav_about:
                        startActivity(new Intent(QuizActivity.this, Menu3.class));
                        break;
                }

                return true;
            }
        });

        mScoreView = (TextView) findViewById(R.id.score_score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);

        List<Button> choices = new ArrayList<>();
        choices.add(mButtonChoice1);
        choices.add(mButtonChoice2);
        choices.add(mButtonChoice3);

        updateQuestion();

        for (final Button choice : choices) {
            choice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (choice.getText().equals(mAnswer)) {
                        updateScore();
                        updateQuestion();

                        Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(QuizActivity.this, "Wrong... Try again!", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(QuizActivity.this, Menu2.class);
                        intent.putExtra("score", mScore); // pass score to Menu2
                        startActivity(intent);
                    }
                }
            });
        }

    }

    private void updateQuestion() {
        if (mQuestionNumber < mQuestionLibrary.getLength()) {
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber++);
        } else {
            Toast.makeText(QuizActivity.this, "Last Question! You are very intelligent!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuizActivity.this, Menu2.class);
            intent.putExtra("score", mScore);
            startActivity(intent);
        }
    }

    private void updateScore() {
        mScoreView.setText(String.valueOf(++mScore));

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highScore = mypref.getInt("highScore", 0);

        if (mScore > highScore) {
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highScore", mScore);
            editor.apply();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    private void createDialog() {
        dialog = new Dialog(this);
        dialog.setTitle("Tutorial");
        dialog.setContentView(R.layout.popup_menu1_1);
        closeButton = (TextView) dialog.findViewById(R.id.closeTXT);
    }
}