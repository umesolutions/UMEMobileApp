package com.mobile.ume.umemobileapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class AgreeTerms_ConditionActivity extends AppCompatActivity {

    CheckBox chkbox1,chkbox2,chkbox3;
    boolean agree1=false,agree2=false,agree3=false;
    Button agree,reject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_conditions);
        chkbox1=(CheckBox)findViewById(R.id.checkBox1);
        chkbox2=(CheckBox)findViewById(R.id.checkBox2);
        chkbox3=(CheckBox)findViewById(R.id.checkBox3);
        reject=(Button)findViewById(R.id.btnreject);
        agree= (Button)findViewById(R.id.btnagree);
        agree.setEnabled(false);
        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);

            }
        });
        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chkbox1.setChecked(false);
                chkbox2.setChecked(false);
                chkbox3.setChecked(false);
                finish();

            }
        });
        chkbox1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                        agree1=true;
                } else
                {
                    agree1=false;
                }
                if(agree1&& agree2&&agree3){
                    agree.setEnabled(true);
                }else{
                    agree.setEnabled(false);
                }
            }

        });
        chkbox2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    agree2=true;
                } else
                {
                    agree2=false;
                }
                if(agree1&& agree2&&agree3){
                    agree.setEnabled(true);
                }else{
                    agree.setEnabled(false);
                }
            }

        });
        chkbox3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    agree3=true;
                } else
                {
                    agree3=false;
                }
                if(agree1&& agree2&&agree3){
                    agree.setEnabled(true);
                }else{
                    agree.setEnabled(false);
                }
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
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
