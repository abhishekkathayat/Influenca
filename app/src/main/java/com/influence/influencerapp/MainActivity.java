package com.influence.influencerapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.influence.influencerapp.Fragments.HomeFragment;
import com.influence.influencerapp.Fragments.ProfileFragment;
import com.influence.influencerapp.Fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    private static int navIndex = 0;
    private static final String TAG_HOME = "Home";
    private static final String TAG_PROFILE = "Profile";
    private static final String TAG_SETTINGS = "Settings";
    private static String CURRENT_TAG = TAG_HOME;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Handler mHandler;
    private boolean shouldLoadHomeFragOnBackPress = true;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);

        mHandler = new Handler();
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation);
        fab = findViewById(R.id.fab_add);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoUploadActivity.class);
                startActivity(intent);
            }
        });

        setUpNavigationView();
        if(savedInstanceState == null) {
            navIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
        TextView textView = findViewById(R.id.TextView_1);
        Shader textShader = new LinearGradient(0, 0, 0, textView.getTextSize(), new int[]{Color.BLUE, Color.RED}, new float[]{0, 1}, Shader.TileMode.MIRROR);
        textView.getPaint().setShader(textShader);
    }
    private void loadHomeFragment() {
        selectNavMenu();
        if(getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawerLayout.closeDrawers();
            return;
        }
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };
        if(mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }
        toggleFab();
        drawerLayout.closeDrawers();
        invalidateOptionsMenu();
    }
    private Fragment getHomeFragment() {
        switch(navIndex) {
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                ProfileFragment profileFragment = new ProfileFragment();
                return profileFragment;
            case 2:
                SettingsFragment settingsFragment = new SettingsFragment();
                return settingsFragment;
            default:
                return new HomeFragment();
        }
    }
    private void selectNavMenu() {
        navigationView.getMenu().getItem(navIndex).setChecked(true);
    }
    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        navIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;
                    case R.id.nav_profile:
                        navIndex = 1;
                        CURRENT_TAG = TAG_PROFILE;
                        break;
                    case R.id.nav_settings:
                        navIndex = 2;
                        CURRENT_TAG = TAG_SETTINGS;
                        break;
                    case R.id.nav_logout:
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        navIndex = 0;
                }
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);
                loadHomeFragment();
                return true;
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {
          @Override
          public void onDrawerClosed(View drawerView) {
              super.onDrawerClosed(drawerView);
          }
          @Override
            public void onDrawerOpened(View drawerView) {
              super.onDrawerOpened(drawerView);
          }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
            return;
        }
        if (shouldLoadHomeFragOnBackPress) {
            if (navIndex != 0) {
                navIndex = 0;
                CURRENT_TAG = TAG_HOME;
                loadHomeFragment();
                return;
            }
        }
        super.onBackPressed();
    }
    private void toggleFab() {
        if(navIndex == 0) {
            fab.show();
        }
        else {
            fab.hide();
        }
    }
}
