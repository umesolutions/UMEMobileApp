package com.mobile.ume.umemobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class SelectDistributorActivity extends AppCompatActivity {
    Button btnSubmit;
    Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_distributor);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        spinner1 =(Spinner)findViewById(R.id.spinner3);
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                for(int i=0;i<=5;i++)
                {
                    Toast.makeText(getApplicationContext(), "Thanks for Selecting Distributor:"+spinner1.getSelectedItem().toString()+". The Distributor will keep in touch with you for Verification", Toast.LENGTH_SHORT).show();
                }
                Intent homepage = new Intent(getBaseContext(),MainMenuActivity.class);
                startActivity(homepage);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_distributor, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

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

