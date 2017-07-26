package amapps.impossiblequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import static amapps.impossiblequiz.R.id.nv3;

public class Menu3 extends AppCompatActivity {

    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);
        DrawerLayout mDrawerLayout3 = (DrawerLayout) findViewById(R.id.drawerLayout3);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout3, R.string.open, R.string.close);
        mDrawerLayout3.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView mNavigationView = (NavigationView) findViewById(nv3);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case (R.id.nav_home3):
                        startActivity(new Intent(Menu3.this, QuizActivity.class));
                        break;
                    case (R.id.nav_stats3):
                        startActivity(new Intent(Menu3.this, Menu2.class));
                        break;
                }

                return true;
            }
        });
    }

    @Override //Makes that the "Burger" Item, shows the Drawer if someone clicks on the simbol
    public boolean onOptionsItemSelected(MenuItem item) {
        return mToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
