package shapy.appz;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static shapy.appz.R.id.nv2;

public class Menu2 extends AppCompatActivity {

    private int mScore;
    private DrawerLayout mDrawerLayout2;
    private ActionBarDrawerToggle mToggle;
    private PopupWindow mPopupWindow;
    private LayoutInflater mLayoutInflater; // Allows adding a new layout in our window
    private RelativeLayout mRel;
    Dialog dialog;
    TextView closebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        TextView txtScore = (TextView) findViewById(R.id.textScore2);
        TextView txtHighScore = (TextView) findViewById(R.id.textHighScore);
        ImageView imgTrophyView1 = (ImageView) findViewById(R.id.trophy1);
        ImageView imgTrophyView2 = (ImageView) findViewById(R.id.trophy2);
        ImageView imgTrophyView3 = (ImageView) findViewById(R.id.trophy3);
        ImageView imgTrophyView4 =(ImageView)findViewById(R.id.trophy4);
        ImageView imgTrophyView5 =(ImageView)findViewById(R.id.trophy5);
        ImageView imgTrophyView6 =(ImageView)findViewById(R.id.trophy6);

        final Button bttPOPUP = (Button) findViewById(R.id.enablePOPUP);
        Button bttPOPUP2 = (Button) findViewById(R.id.enablePOPUP2);
        Button bttPOPUP3 = (Button) findViewById(R.id.enablePOPUP3);
        Button bttPOPUP4 = (Button) findViewById(R.id.enablePOPUP4);
        Button bttPOPUP5 = (Button) findViewById(R.id.enablePOPUP5);
        Button bttPOPUP6 = (Button) findViewById(R.id.enablePOPUP6);

        final RelativeLayout mRel = (RelativeLayout) findViewById(R.id.bgpop);

        Intent intent = getIntent();
        mScore = intent.getIntExtra("score", 0);
        txtScore.setText(String.format("Your score: %d", mScore));

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highScore = mypref.getInt("highScore", 0);

        if (mScore > highScore) {
            highScore = mScore;

            txtHighScore.setText(String.format("High score: %d", mScore));

            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highScore", mScore);
            editor.apply();
        } else {
            txtHighScore.setText(String.format("High score: %d", highScore));
        }

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

        if (highScore >= 30) {
            imgTrophyView4.setVisibility(View.VISIBLE);
            bttPOPUP4.setVisibility(View.VISIBLE);
        }

        if (highScore >= 30) {
            imgTrophyView5.setVisibility(View.VISIBLE);
            bttPOPUP5.setVisibility(View.VISIBLE);
        }

        if (highScore >= 30) {
            imgTrophyView6.setVisibility(View.VISIBLE);
            bttPOPUP6.setVisibility(View.VISIBLE);
        }

        final List<Button> containers = new ArrayList<>();
        containers.add(bttPOPUP);
        containers.add(bttPOPUP2);
        containers.add(bttPOPUP3);
        containers.add(bttPOPUP4);
        containers.add(bttPOPUP5);
        containers.add(bttPOPUP6);

        final List<Integer> dialogs = new ArrayList<>();
        dialogs.add(R.layout.popup_menu2_1);
        dialogs.add(R.layout.popup_menu2_2);
        dialogs.add(R.layout.popup_menu2_3);
        dialogs.add(R.layout.popup_menu2_4);
        dialogs.add(R.layout.popup_menu2_5);
        dialogs.add(R.layout.popup_menu2_6);

        for (int i = 0; i < dialogs.size(); i++) {
            final int j = i;

            containers.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //createDialog
                    createDialog();
                    Button bttopendia = (Button) findViewById(R.id.enablePOPUP);

                    bttopendia.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.show();

                        }
                    });

                    //close dialog
                    closebtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                }

            });
        }

        Toolbar mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);
        mDrawerLayout2 = (DrawerLayout) findViewById(R.id.drawerLayout2);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout2, R.string.open, R.string.close);
        mDrawerLayout2.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView mNavigationView = (NavigationView) findViewById(nv2);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home2:
                        startActivity(new Intent(Menu2.this, QuizActivity.class));
                        break;
                    case R.id.nav_about2:
                        startActivity(new Intent(Menu2.this, Menu3.class));
                        break;
                }

                return true;
            }
        });
    }

    @Override //Makes that the "Burger" Item, shows the Drawer if someone clicks on the symbol
    public boolean onOptionsItemSelected(MenuItem item) {
        return mToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        Intent intent = new Intent(Menu2.this, QuizActivity.class);
        intent.putExtra("score", mScore);
        startActivity(intent);
    }

    private void createDialog(){

        dialog = new Dialog(this);
        //Title of the dialogwith dialog.setTitle
        dialog.setTitle("Tutorial");
        //content
        dialog.setContentView(R.layout.popup_menu2_1);
        closebtn = (TextView) dialog.findViewById(R.id.closeBtn1);



    }









}



