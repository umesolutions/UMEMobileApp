package com.mobile.ume.umemobileapp;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ume.util.DatabaseHandler;

public class RegisterOTP_PasswordActivity extends AppCompatActivity {
    EditText name,mobileno,otp,username,password,cpassword;
    //CheckBox chkbox;
    TextView textview,txtUsername,txtpassword,txtcpassword;
    Button btnSubmit,btnValidate;
    String generatedOTP;
    public static String usernamevalue,passwordvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_password_registration);
        btnSubmit=(Button)findViewById(R.id.btnSubmit);
        name=(EditText)findViewById(R.id.reg1_name);
        mobileno=(EditText)findViewById(R.id.reg1_mobileno);
        otp=(EditText)findViewById(R.id.reg1_otp);
        btnValidate=(Button)findViewById(R.id.btnRegister);
        textview=(TextView)findViewById(R.id.textviewotp);
        username=(EditText)findViewById(R.id.reg1_username);
        password=(EditText)findViewById(R.id.reg1_password);
        cpassword=(EditText)findViewById(R.id.reg1_confirmpassword);
        txtUsername=(TextView)findViewById(R.id.textusername);
        txtpassword=(TextView)findViewById(R.id.textpassword);
        txtcpassword=(TextView)findViewById(R.id.textcpassword);


        otp.setVisibility(View.GONE);
        textview.setVisibility(View.GONE);
        btnValidate.setVisibility(View.GONE);
        username.setVisibility(View.GONE);
        password.setVisibility(View.GONE);
        cpassword.setVisibility(View.GONE);
        txtUsername.setVisibility(View.GONE);
        txtpassword.setVisibility(View.GONE);
        txtcpassword.setVisibility(View.GONE);
       // btnSubmit.setEnabled(false);
//        chkbox.setOnClickListener(new View.OnClickListener() {
//            @Override
//
//            public void onClick(View v) {
//                if (((CheckBox) v).isChecked()) {
//                    Toast.makeText(RegisterOTP_PasswordActivity.this, "Terms and Condition Accepted.", Toast.LENGTH_SHORT).show();
//                    btnSubmit.setEnabled(true);
//                } else {
//                    Toast.makeText(RegisterOTP_PasswordActivity.this, "Please agree Terms & Conditions.", Toast.LENGTH_SHORT).show();
//                    btnSubmit.setEnabled(false);
//                }
//            }
//
//        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText() != null && name.getText().length() >= 3 && mobileno.getText() != null && mobileno.getText().length() >= 10){
                    generatedOTP = "" + new java.util.Random().nextInt(100000);
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// Sets an ID for the notification, so it can be updated
                int notifyID = 1;
                NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(getApplicationContext()).setContentTitle("OTP for UME Authentication")
                        .setContentText("You've received OTP for UME Authentication.")
                        .setSmallIcon(R.drawable.star_icon);

                mNotifyBuilder.setContentText("The OTP generated for UME application is:" + generatedOTP + ".Do not share the OTP with anyone. Kindly enter the OTP to initiate the Registration Process.")
                        .setNumber(0);
                mNotifyBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText("The OTP generated for UME application is:" + generatedOTP + ".Do not share the OTP with anyone. Kindly enter the OTP to initiate the Registration Process."));
                mNotificationManager.notify(
                        notifyID,
                        mNotifyBuilder.build());
                otp.setVisibility(View.VISIBLE);
                textview.setVisibility(View.VISIBLE);
                btnValidate.setVisibility(View.VISIBLE);
                btnSubmit.setVisibility(View.GONE);
                    username.setVisibility(View.VISIBLE);
                    password.setVisibility(View.VISIBLE);
                    cpassword.setVisibility(View.VISIBLE);
                    txtUsername.setVisibility(View.VISIBLE);
                    txtpassword.setVisibility(View.VISIBLE);
                    txtcpassword.setVisibility(View.VISIBLE);
            }else
                {
                    Toast.makeText(RegisterOTP_PasswordActivity.this, "Kindly enter Valid Name & Mobile Number.", Toast.LENGTH_SHORT).show();
                }
            }

        });

        btnValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(otp.getText()!=null & otp.getText().toString().equalsIgnoreCase(generatedOTP)) {
//                    Intent intent = new Intent(getBaseContext(), Activity3Register.class);
//
//                    startActivity(intent);
                }else{
                    Toast.makeText(RegisterOTP_PasswordActivity.this, "Enter Valid OTP", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(username.getText()!=null & password.getText()!=null & cpassword.getText()!=null) {
                    if(password.getText().toString().equalsIgnoreCase(cpassword.getText().toString()))
                    {
                        Intent intent = new Intent(getBaseContext(), RegisterPersonalDetailsActivity.class);
                        intent.putExtra("name", name.getText().toString());
                        intent.putExtra("mobileno", mobileno.getText().toString());
                        intent.putExtra("username", username.getText().toString());
                        intent.putExtra("password", password.getText().toString());
                        usernamevalue=username.getText().toString();
                        passwordvalue=password.getText().toString();
                        try {
                            new DatabaseHandler(getApplicationContext()).insertLogin(usernamevalue, passwordvalue);
                        }catch(Exception e)
                        {}
                        startActivity(intent);
                    }else
                    {
                        Toast.makeText(getApplicationContext(), "Passwords are Mismatching. Reenter passwords..", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Enter Valid Username and Password", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register1, menu);
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
