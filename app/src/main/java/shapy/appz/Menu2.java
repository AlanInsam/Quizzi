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
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static shapy.appz.R.id.nv2;

public class Menu2 extends AppCompatActivity {

    private int mScore;
    private ActionBarDrawerToggle mToggle;


    @Override
    public void onBackPressed() {
        Intent intent =new Intent(Menu2.this,QuizActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);




        TextView txtScore = (TextView) findViewById(R.id.textScore2);
        TextView txtHighScore = (TextView) findViewById(R.id.textHighScore);

        ImageView trophy1 = (ImageView) findViewById(R.id.trophy1);
        ImageView trophy2 = (ImageView) findViewById(R.id.trophy2);
        ImageView trophy3 = (ImageView) findViewById(R.id.trophy3);
        ImageView trophy4 = (ImageView) findViewById(R.id.trophy4);
        ImageView trophy5 = (ImageView) findViewById(R.id.trophy5);
        ImageView trophy6 = (ImageView) findViewById(R.id.trophy6);
        ImageView genius60Score = (ImageView)findViewById(R.id.genius60Img);
        ImageView trophyImgBefore60 = (ImageView)findViewById(R.id.statsTrophy);




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
            trophy1.setVisibility(View.VISIBLE);
        }

        if (highScore >= 20) {
            trophy2.setVisibility(View.VISIBLE);
        }

        if (highScore >= 30) {
            trophy3.setVisibility(View.VISIBLE);
        }

        if (highScore >= 40) {
            trophy4.setVisibility(View.VISIBLE);
        }

        if (highScore >=50) {
            trophy5.setVisibility(View.VISIBLE);
        }

        if (highScore >= 60) {
            trophy6.setVisibility(View.VISIBLE);
            trophyImgBefore60.setVisibility(View.GONE);
            genius60Score.setVisibility(View.VISIBLE);
        }

        final List<ImageView> containers = new ArrayList<>();
        containers.add(trophy1);
        containers.add(trophy2);
        containers.add(trophy3);
        containers.add(trophy4);
        containers.add(trophy5);
        containers.add(trophy6);

        final List<Integer> dialogs = new ArrayList<>();
        dialogs.add(R.layout.popup_menu2_1);
        dialogs.add(R.layout.popup_menu2_2);
        dialogs.add(R.layout.popup_menu2_3);
        dialogs.add(R.layout.popup_menu2_4);
        dialogs.add(R.layout.popup_menu2_5);
        dialogs.add(R.layout.popup_menu2_6);

        for (int i = 0; i < containers.size(); i++) {
            final int j = i;

            containers.get(j).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Dialog dialog = new Dialog(Menu2.this);
                    dialog.setTitle("Trophies");
                    dialog.setContentView(dialogs.get(j));
                    dialog.show();
                }
            });
        }

        setSupportActionBar((Toolbar) findViewById(R.id.nav_action));
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout2);

        mToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(mToggle);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        Intent intent = new Intent(Menu2.this, QuizActivity.class);
        intent.putExtra("score", mScore);
        startActivity(intent);
    }
}
