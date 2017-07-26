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
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import static amapps.impossiblequiz.R.id.nv2;

            public class Menu2 extends AppCompatActivity {




    private DrawerLayout mDrawerLayout2;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    private Button popup;
    private Button popup2;
    private Button popup3;
    private PopupWindow popupWindow;private LayoutInflater layoutInflater; //Alows to add a new layout in our window



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);



        TextView txtScore = (TextView) findViewById(R.id.textScore2);
        TextView txtHighScore = (TextView) findViewById(R.id.textHighScore);
        ImageView imgTrophyView1 = (ImageView) findViewById(R.id.trophy1);
        ImageView imgTrophyView2 = (ImageView) findViewById(R.id.trophy2);
        Button bttPOPUP = (Button) findViewById(R.id.enablePOPUP);
        Button bttPOPUP2 =(Button)findViewById(R.id.enablePOPUP2);
        Button bttPOPUP3 = (Button) findViewById(R.id.enablePOPUP3);
        ImageView imgTrophyView3=(ImageView)findViewById(R.id.trophy3);


        Intent intent = getIntent();
        int mScore = intent.getIntExtra("score", 0);
        txtScore.setText("Your score is: " + mScore);



        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highScore = mypref.getInt("highScore", 0);
        if (highScore >= mScore){
            txtHighScore.setText("High score: " + highScore);




            if (highScore >= 10) {
                imgTrophyView1.setVisibility(View.VISIBLE);
                bttPOPUP.setVisibility(View.VISIBLE);

            }
            if (highScore >= 20) {
                imgTrophyView2.setVisibility(View.VISIBLE);
                bttPOPUP2.setVisibility(View.VISIBLE);

            }

            if (highScore >= 30) {
                imgTrophyView3.setVisibility(View.VISIBLE);
                bttPOPUP3.setVisibility(View.VISIBLE);

            }



        }



        else {
            txtHighScore.setText("New highscore: " + mScore);

            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highScore", mScore);
            editor.commit();
        }



        //Start POPUP window 1

        popup = (Button)findViewById(R.id.enablePOPUP);
        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutInflater =(LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popup_menu2_1,null);
                popupWindow = new PopupWindow(container,1000,980,true); //400,400=popUp size, true = makes that we can close the pop up by simply click out of the window
                popupWindow.showAtLocation(mDrawerLayout2, Gravity.CENTER, 0, 0);
                mDrawerLayout2.setAlpha((float) 0.3);

                container.setOnTouchListener(new View.OnTouchListener(){

                    @Override

                    public boolean onTouch(View view, MotionEvent motionEvent  ){
                        mDrawerLayout2.setAlpha((float) 1);
                        popupWindow.dismiss();

                        return true;

                    }

                });


                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

                    @Override
                    public void onDismiss() {
                        mDrawerLayout2.setAlpha((float) 1);
                        popupWindow.dismiss();

                    }
                });
            }
        });

        //End POPUP window 1
        //start POPUP window 2

        popup2 = (Button)findViewById(R.id.enablePOPUP2);
        popup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutInflater =(LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popup_menu2_2,null);
                popupWindow = new PopupWindow(container,1000,980,true); //400,400=popUp size, true = makes that we can close the pop up by simply click out of the window
                popupWindow.showAtLocation(mDrawerLayout2, Gravity.CENTER, 0, 0);
                mDrawerLayout2.setAlpha((float) 0.3);

                container.setOnTouchListener(new View.OnTouchListener(){

                    @Override

                    public boolean onTouch(View view, MotionEvent motionEvent  ){
                        mDrawerLayout2.setAlpha((float) 1);
                        popupWindow.dismiss();

                        return true;

                    }

                });


                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

                    @Override
                    public void onDismiss() {
                        mDrawerLayout2.setAlpha((float) 1);
                        popupWindow.dismiss();

                    }
                });
            }
        });

    //End POPUP window 2
        //start POPUP window 3

        popup3 = (Button)findViewById(R.id.enablePOPUP3);
        popup3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutInflater =(LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popup_menu2_3,null);
                popupWindow = new PopupWindow(container,1000,980,true); //400,400=popUp size, true = makes that we can close the pop up by simply click out of the window
                popupWindow.showAtLocation(mDrawerLayout2, Gravity.CENTER, 0, 0);
                mDrawerLayout2.setAlpha((float) 0.3);

                container.setOnTouchListener(new View.OnTouchListener(){

                    @Override

                    public boolean onTouch(View view, MotionEvent motionEvent  ){
                        mDrawerLayout2.setAlpha((float) 1);
                        popupWindow.dismiss();

                        return true;

                    }

                });


                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

                    @Override
                    public void onDismiss() {
                        mDrawerLayout2.setAlpha((float) 1);
                        popupWindow.dismiss();

                    }
                });
            }
        });

        //End POPUP window 3



        mToolbar = (Toolbar)findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);
        mDrawerLayout2 = (DrawerLayout) findViewById(R.id.drawerLayout2);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout2, R.string.open, R.string.close);
        mDrawerLayout2.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView mNavigationView = (NavigationView) findViewById(nv2);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                switch (menuItem.getItemId()){
                    case R.id.nav_home2:
                        startActivity(new Intent(Menu2.this, QuizActivity.class));
                        break;
                    case R.id.nav_about2:
                        startActivity(new Intent(Menu2.this, Menu3.class));
                        break;


                } return true;

            }
        });
    }










    @Override //Makes that the "Burger" Item, shows the Drawer if someone clicks on the simbol
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);






    }

                public void onClick(View view) {
                    Intent intent = new Intent(Menu2.this,QuizActivity.class);
                    startActivity(intent);
                }
            }



