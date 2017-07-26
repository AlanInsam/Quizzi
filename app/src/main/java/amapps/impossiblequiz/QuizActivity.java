package amapps.impossiblequiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    private MenuItem menuItem;
    private Intent in;

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    private Button popup4;
    private PopupWindow popupWindow;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);




        //Randomizes the row of the questions
        QuestionLibrary q = new QuestionLibrary();
        System.out.printf("Question:0 Choice:(%s, %s, %s) Answer:%s%n",
                q.getChoice1(0), q.getChoice2(0), q.getChoice3(0), q.getCorrectAnswer(0));
        q.shuffle();
        System.out.printf("Question:0 Choice:(%s, %s, %s) Answer:%s%n",
                q.getChoice1(0), q.getChoice2(0), q.getChoice3(0), q.getCorrectAnswer(0));
        mQuestionLibrary.shuffle();
        //End randomizer

        //We need this for the NAVIGATION DRAWER
        mToolbar = (Toolbar) findViewById(R.id.nav_action);

        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Able to see the Navigation Burger "Button"


        NavigationView mNavigationView = (NavigationView) findViewById(R.id.nv1);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                switch (menuItem.getItemId()){
                    case(R.id.nav_stats): //If nav stats selected Activity 2 will show up
                        startActivity(new Intent(QuizActivity.this,Menu2.class));
                        break;
                    case R.id.nav_about:
                        startActivity(new Intent(QuizActivity.this, Menu3.class));
                        break;


                }
                return true;
            }
        });

            //Initialise

            mScoreView = (TextView) findViewById(R.id.score_score);
            mQuestionView = (TextView) findViewById(R.id.question);
            mButtonChoice1 = (Button) findViewById(R.id.choice1);
            mButtonChoice2 = (Button) findViewById(R.id.choice2);
            mButtonChoice3 = (Button) findViewById(R.id.choice3);


            updateQuestion(); //New question appears

            //Start of Button Listener1 -> if true, next question appears +score +1[] Else menu 2 will show
            mButtonChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //My logic for Button goes in here

                    if (mButtonChoice1.getText() == mAnswer) {
                        mScore = mScore + 1;
                        updateScore(mScore);
                        updateQuestion();



                        //This line of code is optional...
                        Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(QuizActivity.this, "Wrong... Try again!", Toast.LENGTH_SHORT).show();


                        Intent intent = new Intent(QuizActivity.this, Menu2.class);
                        intent.putExtra("score",mScore); //pass score to Menu2
                        startActivity(intent);




                    }
                }


            });
            //End of Button Listener1

            //Start of Button Listener2
            mButtonChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //My logic for Button goes in here

                    if (mButtonChoice2.getText() == mAnswer) {
                        mScore = mScore + 1;
                        updateScore(mScore);
                        updateQuestion();




                        //This line of code is optional...
                        Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(QuizActivity.this, "Oh... wrong your score is 0", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(QuizActivity.this, Menu2.class);
                        intent.putExtra("score",mScore); //pass score to Menu2
                        startActivity(intent);




                    }
                }


            });
            //End of Button Listener2

            //Start of Button Listener3
            mButtonChoice3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //My logic for Button goes in here

                    if (mButtonChoice3.getText() == mAnswer) {
                        mScore = mScore + 1;
                        updateScore(mScore);
                        updateQuestion();




                        //This line of code is optional...
                        Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(QuizActivity.this, "Come on, that was not so hard...", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(QuizActivity.this, Menu2.class);
                        intent.putExtra("score",mScore); //pass score to Menu2
                        startActivity(intent);




                    }
                }


            });
            //End of Button Listener3

        //Initializes the popUP window
        popup4 = (Button) findViewById(R.id.tutorial);
        //start POPUP window 3

        popup4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container2 = (ViewGroup)layoutInflater.inflate(R.layout.popup_menu1_1,null);
                popupWindow = new PopupWindow(container2,1000,980,true); //400,400=popUp size, true = makes that we can close the pop up by simply click out of the window
                popupWindow.showAtLocation(mDrawerLayout, Gravity.CENTER, 0, 0);
                mDrawerLayout.setAlpha((float) 0.3);

                container2.setOnTouchListener(new View.OnTouchListener(){

                    @Override

                    public boolean onTouch(View view, MotionEvent motionEvent  ){
                        mDrawerLayout.setAlpha((float) 1);
                        popupWindow.dismiss();

                        return true;

                    }

                });


                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

                    @Override
                    public void onDismiss() {
                        mDrawerLayout.setAlpha((float) 1);
                        popupWindow.dismiss();

                    }
                });
            }
        });

        //End POPUP window 3

        }


    private void updateQuestion() {
            //If the max. number of questions is reached, menu2 will be open if not  a  new quiz selection appears
       if (mQuestionNumber < mQuestionLibrary.getLength()) {
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
        else {
            Toast.makeText(QuizActivity.this, "Last Question! You are very intelligent!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuizActivity.this, Menu2.class);
            intent.putExtra("score",mScore); //pass score to Menu2
            startActivity(intent);


        }

    }

    private void updateScore ( int point){
        mScoreView.setText("" + mScore);
        //Shared preferences = a variabe (mScore) gets saved and call up in another activity
        SharedPreferences mypref =getPreferences(MODE_PRIVATE);
        int highScore = mypref.getInt("highScore", 0);
        if(mScore> highScore){
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("currentscore", mScore);
            editor.apply();
        }




    }

        @Override //Makes that the "Burger" Item, shows the Drawer if someone clicks on the simbol
        public boolean onOptionsItemSelected (MenuItem item){
            if (mToggle.onOptionsItemSelected(item)) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }


    }