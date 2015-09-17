package com.mobile.ume.umemobileapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;

import android.widget.Button;
        import android.widget.EditText;
import android.widget.Toast;

import com.ume.util.DatabaseHandler;

public class LoginActivity extends Activity  {
    Button b1,b2,b3;
    EditText ed1,ed2;
    LoginActivity activity;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        b1=(Button)findViewById(R.id.button);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);

        b2=(Button)findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String username= ed1.getText().toString();
                String password =ed2.getText().toString();
                if(username.equalsIgnoreCase(RegisterOTP_PasswordActivity.usernamevalue) &&
                        password.equalsIgnoreCase(RegisterOTP_PasswordActivity.passwordvalue))
                {
                    Intent intent = new Intent(getBaseContext(), MainMenuActivity.class);
                    startActivity(intent);

                }else
                {
                    try {
                        String role = new DatabaseHandler(getApplicationContext()).getLogin(username, password);
                        if (role.equalsIgnoreCase("RETAILER")) {
                            Intent intent = new Intent(getBaseContext(), MainMenuActivity.class);
                            startActivity(intent);
                            return;
                        }
                    }catch(Exception e)
                    {}
                    for(int i=0;i<3;i++)
                    Toast.makeText(getApplicationContext(), "User name and password invalid",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        activity=this;
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Your Database reset started",
                        Toast.LENGTH_LONG).show();
                DatabaseHandler handler = new DatabaseHandler(LoginActivity.this);
                handler.resetDB();
                Toast.makeText(getApplicationContext(), "Your Database reset Completed",
                        Toast.LENGTH_LONG).show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), RegisterOTP_PasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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