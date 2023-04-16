package com.example.project.activitypages;

import static com.example.project.R.id;
import static com.example.project.R.layout;
import static com.example.project.R.string;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;


import com.example.project.fragments.New_Meeting;
import com.example.project.fragments.Reports;
import com.example.project.fragments.UserProfile;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_dashboard);


        Toolbar toolbar = findViewById(id.toolbar);
        setSupportActionBar(toolbar);
        try{
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);}
        catch (NullPointerException e){ e.printStackTrace();}

        drawerLayout = findViewById(id.drawer_layout);
        NavigationView navigationView = findViewById(id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, string.open_nav,
                string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(id.fragment_container, new Reports()).commit();
            navigationView.setCheckedItem(id.nav_Reports);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case id.nav_New_Meeting:
                getSupportFragmentManager().beginTransaction().replace(id.fragment_container, new New_Meeting()).commit();
                break;
            case id.nav_Reports:
                getSupportFragmentManager().beginTransaction().replace(id.fragment_container, new Reports()).commit();
                break;
            case id.nav_Profile:
                getSupportFragmentManager().beginTransaction().replace(id.fragment_container, new UserProfile()).commit();
                break;
            case id.nav_logout:
                super.onBackPressed();
                finish();

                break;
        }
        drawerLayout.closeDrawers();
        return true;
    }



    @Override
    public void onBackPressed() {
        if (getDrawerToggleDelegate().isNavigationVisible())  {
             drawerLayout.closeDrawers();
        }

    }
}
