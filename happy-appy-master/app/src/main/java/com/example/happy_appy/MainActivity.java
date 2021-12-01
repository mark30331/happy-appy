package com.example.happy_appy;

import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.preference.PreferenceManager;
import android.util.JsonReader;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.gson.Gson;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Calendar calendar = Calendar.getInstance();
        int thisDay = calendar.get(Calendar.DAY_OF_YEAR);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        long last = prefs.getLong("date", 0);
        calendar.setTimeInMillis(last);
        int lastDay = calendar.get(Calendar.DAY_OF_YEAR);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String pathName = "quotes.txt";
        ArrayList<String> quotes = new ArrayList<>();
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(getAssets().open(pathName)));
            while (fileReader.readLine() != null) {
                quotes.add(fileReader.readLine());
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        Random rand = new Random();
        String quote;
        int index = 0;
        //TODO: Figure out how to refresh quotes on a daily basis
        if(quotes.size() != 0) {
            if(lastDay != thisDay || last == 0) {
                index = rand.nextInt(quotes.size());
            }
            quote = quotes.get(index);
        }
        else {
            quote = "We don't have any quotes!!";
        }

        TextView quoteView = findViewById(R.id.daily_quote);
        quoteView.setText(quote);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_preset1, R.id.nav_preset2, R.id.nav_preset3, R.id.menu_build,
                R.id.nav_music, R.id.nav_tools)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void loadWebPage(View v){
        Intent intent = new Intent(this, WebActivity.class);
        startActivity(intent);
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}
