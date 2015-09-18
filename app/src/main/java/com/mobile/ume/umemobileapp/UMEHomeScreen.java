package com.mobile.ume.umemobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.loopj.android.http.RequestParams;
import com.ume.util.RESTCommunicator;

import java.util.Timer;
import java.util.TimerTask;

public class UMEHomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umehome_screen);
        int timeout = 3000; // make the activity visible for 4 seconds
        RequestParams params = new RequestParams();
       // RESTCommunicator.invokeWS(params);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                finish();
                Intent homepage = new Intent(getBaseContext(),AgreeTerms_ConditionActivity.class);
                startActivity(homepage);
            }
        }, timeout);


    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        try {
//            Thread.sleep(10000);
//        }catch(Exception e)
//        {
//
//        }
//        Intent intent = new Intent(getBaseContext(),AgreeTerms_ConditionActivity.class);
//        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_umehome_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
