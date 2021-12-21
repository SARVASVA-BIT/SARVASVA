package com.example.sarvasva.app.activities;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.sarvasva.R;
import com.example.sarvasva.app.fragments.Announcements;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private FrameLayout parentFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.main_drawer_layout);
        toolbar = findViewById(R.id.activity_main_toolbar);
        parentFrameLayout = findViewById(R.id.main_activity_frame_layout);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setItemIconTintList(null);
        setFragment(new Announcements());


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                Class fragmentClass;
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        setFragment(new Announcements());
                        break;

                    case R.id.nav_Logout:

                        FirebaseAuth.getInstance().signOut();

                        // todo: clea all data of the user;

                        Intent intent = new Intent(MainActivity.this , AuthenticationActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    default:
                        fragmentClass = Announcements.class;
                }


                // Insert the fragment by replacing any existing fragment

                // Highlight the selected item has been done by NavigationView
                menuItem.setChecked(true);
                // Set action bar title

                // Close the navigation drawer

                drawerLayout.closeDrawer(GravityCompat.START);



                return true;
            }

        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START))
                {
                    drawerLayout.closeDrawer(Gravity.RIGHT);
                }
                else
                    {
                    drawerLayout.openDrawer(GravityCompat.START);
                    }
            }
        });



    }
    @Override
    public void onBackPressed(){
        int count = getFragmentManager().getBackStackEntryCount(); // if stack count is 0, it means no fragment left to pop back stack
        if (count == 0) {
            finish();
        }
    }



    private void setFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();

    }
}