package com.mobile.ume.umemobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.ume.util.DatabaseHandler;
import com.util.beans.Distributor;
import com.util.beans.Catagory;

import java.util.ArrayList;
import java.util.List;

public class RetailerOrderActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_order);
        button = (Button) findViewById(R.id.viewordereditem);
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        List<Catagory> catagories = databaseHandler.getAllCategory();
        List<String> categorynames = new ArrayList<String>();
        for (int i = 0; i < catagories.size(); i++) {
            categorynames.add(catagories.get(i).getCatagoryName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categorynames);

        final Spinner spinYear = (Spinner) findViewById(R.id.spinner1);
        spinYear.setAdapter(adapter);


        List<Distributor> distributor = databaseHandler.getAllDistributor();
        categorynames = new ArrayList<String>();
        for (int i = 0; i < distributor.size(); i++) {
            categorynames.add(distributor.get(i).getName());
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categorynames);

        final Spinner spinYear1 = (Spinner) findViewById(R.id.spinner2);
        spinYear1.setAdapter(adapter1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(getBaseContext(), ViewOrders.class);
              //  intent.putExtra("categoryname", spinYear.getSelectedItem().toString());
              //  intent.putExtra("distributorname", spinYear1.getSelectedItem().toString());
              //  startActivity(intent);

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_retailer_order, menu);
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
