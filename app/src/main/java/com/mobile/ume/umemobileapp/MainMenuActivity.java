package com.mobile.ume.umemobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {
    ImageView image1,image11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        image1 = (ImageView) findViewById(R.id.imageButton1);
        image11 = (ImageView) findViewById(R.id.imageButton11);
        image1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent homepage = new Intent(getBaseContext(),SelectDistributorActivity.class);
                startActivity(homepage);
            }
        });
        image11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent homepage = new Intent(getBaseContext(),LoginActivity.class);
                startActivity(homepage);
            }
        });
        image1.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(), "Select Distributor for Approval", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        image1.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(), "To Logout", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
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
