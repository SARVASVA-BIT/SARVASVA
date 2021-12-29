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
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sarvasva.R;
import com.example.sarvasva.app.fragments.ClubDirectory;
import com.example.sarvasva.app.fragments.Colledge_directory_page;
import com.example.sarvasva.app.fragments.UserProfile;

import com.example.sarvasva.app.fragments.Announcements;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private View navHeader;
    private TextView currentUser , clubsTv , titleTvMain;
    private ImageView userProfilePicture;
    private DrawerLayout drawer;
    private ExpandableListView drawerList;
    private CheckBox checkBox;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    private FrameLayout parentFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.main_drawer_layout);
        toolbar = findViewById(R.id.activity_main_toolbar);
        parentFrameLayout = findViewById(R.id.main_activity_frame_layout);
        titleTvMain = findViewById(R.id.titleTvMain);


        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setItemIconTintList(null);
        setFragment(new Announcements());


        navHeader = navigationView.getHeaderView(0);
        currentUser = (TextView) navHeader.findViewById(R.id.currentUser);
        userProfilePicture = (ImageView) navHeader.findViewById(R.id.user_profile_icon);





//        drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
//        drawerList = (ExpandableListView) findViewById(R.id.left_drawer2);
//        drawerList.setAdapter(new ExpandableListAdapter(this, groupItem, childItem));

          userProfilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Todo : change activity to user profile
                setFragment(new UserProfile());




                        if (drawerLayout.isDrawerOpen(GravityCompat.START))
                        {
                            drawerLayout.closeDrawer(GravityCompat.START);
                        }
                        else
                        {
                            drawerLayout.openDrawer(GravityCompat.START);
                        }


            }
        });
          currentUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Todo : change activity to user profile
                setFragment(new UserProfile());




                if (drawerLayout.isDrawerOpen(GravityCompat.START))
                {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else
                {
                    drawerLayout.openDrawer(GravityCompat.START);
                }


            }
          });
          //ammouncement , also the home page


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                Class fragmentClass;
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:

                        goToFragment(new Announcements() , "Announcement");

                        break;
                    case R.id.nav_clubs:
                        goToFragment(new ClubDirectory() , "CLUBS");
                        break;
                    case R.id.nav_DIRECTORY:
                        goToFragment(new Colledge_directory_page() , "CAMPUS DIRECTORY");
                        break;
                    case R.id.nav_Logout:

                        FirebaseAuth.getInstance().signOut();

                        // todo: clea all data of the user;

                        Intent intent = new Intent(MainActivity.this , AuthenticationActivity.class);
                        startActivity(intent);
                        finish();
                        break;
//                    case R.id.nav_MAPS:
//                        Intent intent1 = new Intent(MainActivity.this , GoogleMapsInSarvasva.class);
//                        startActivity(intent1);
//                        finish();

//                        break;
                    case R.id.nav_ERP:
                        Intent intent2 = new Intent(MainActivity.this , WebVIiewERP.class);
                        startActivity(intent2);
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



    private void setFragment(Fragment fragment)
    {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();

    }


    private void goToFragment(Fragment fragment , String title)
    {

        setFragment(fragment);
        titleTvMain.setText(title);


    }
//    private void prepareListData() {
//
//        listDataHeader = new ArrayList<String>();
//        listDataChild = new HashMap<String, List<String>>();
////list of array for header data
//        String[] array = getResources()
//                .getStringArray(R.array.nav_drawer_items);
//        listDataHeader = Arrays.asList(array);
//
//        // Adding child data
//        // dash board
//        //list for each child as array values
//        List<String> dashboard = new ArrayList<String>();
//        String[] dash = getResources().getStringArray(R.array.dash_board);
//        dashboard = Arrays.asList(dash);
//
//        // before you file
//        List<String> beforeyoufile = new ArrayList<String>();
//        String[] beforeyou = getResources().getStringArray(
//                R.array.before_you_file);
//        beforeyoufile = Arrays.asList(beforeyou);
//
//        // profile
//        List<String> profile = new ArrayList<String>();
//        String[] myprofile = getResources().getStringArray(R.array.my_profile);
//        profile = Arrays.asList(myprofile);
//
//        // income slip
//        List<String> income = new ArrayList<String>();
//        String[] incomeslip = getResources()
//                .getStringArray(R.array.income_slip);
//        income = Arrays.asList(incomeslip);
//
//        // federal deduction
//        List<String> federaldeduction = new ArrayList<String>();
//        String[] federal = getResources().getStringArray(
//                R.array.federal_deduction);
//        federaldeduction = Arrays.asList(federal);
//
//        // provincial credits
//        List<String> provincialcredits = new ArrayList<String>();
//        String[] provincial = getResources().getStringArray(
//                R.array.provincial_credit);
//        provincialcredits = Arrays.asList(provincial);
//
//        // expenses
//        List<String> expenses = new ArrayList<String>();
//        String[] expen = getResources().getStringArray(R.array.expenses);
//        expenses = Arrays.asList(expen);
//
//        //child array without adding array values, only initalized.
//        // review
//        List<String> review = new ArrayList<String>();
//
//        // cra profile
//        List<String> craprofile = new ArrayList<String>();
//
//        // submit
//        List<String> submit = new ArrayList<String>();
//
//        // cloud drive
//        List<String> clouddrive = new ArrayList<String>();
//
//        // assigning values to menu and submenu
//
//        //initally placing the header data from array of list and
//        placing child array name for each data header
//
//        listDataChild.put(listDataHeader.get(0), dashboard); // Header, Child              // data
//        listDataChild.put(listDataHeader.get(1), beforeyoufile);
//        listDataChild.put(listDataHeader.get(2), profile);
//        listDataChild.put(listDataHeader.get(3), income);
//        listDataChild.put(listDataHeader.get(4), federaldeduction);
//        listDataChild.put(listDataHeader.get(5), provincialcredits);
//        listDataChild.put(listDataHeader.get(6), expenses);
//        listDataChild.put(listDataHeader.get(7), review);
//        listDataChild.put(listDataHeader.get(8), craprofile);
//        listDataChild.put(listDataHeader.get(9), submit);
//        listDataChild.put(listDataHeader.get(10), clouddrive);
//
//    }

}