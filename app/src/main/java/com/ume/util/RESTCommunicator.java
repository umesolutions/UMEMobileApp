package com.ume.util;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.mobile.ume.umemobileapp.LoginActivity;
import com.util.beans.Retailer;

import java.util.Map;

/**
/**
 * Created by govinb2 on 14-09-2015.
 */
public class RESTCommunicator {

    public static void main(String[] args) throws Exception
    {
        System.out.print("test");
        RequestParams params = new RequestParams();
        invokeWS(params,null);

      //  Log.d("eer", "main");
    }

    public static String getOTP(String nicName,String mobileno)
    {

        return null;
    }

    public static boolean isValidandCreateLogin(String OTP,String mobileno,String username,String password)
    {

        return false;
    }

    public static String createRetailer(Retailer retailer)
    {
        //Update Retailer information
        return "RetailerID";
    }

    private static void uploadImage(String image)
    {

    }

    public static boolean isValid(String username,String password)
    {

        return false;
    }
    /**
     * Method that performs RESTful webservice invocations
     *
     * @param params
     */
    public static void invokeWS(RequestParams params,Map returnMap){
        // Show Progress Dialog

        // Make RESTful webservice call using AsyncHttpClient object
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://default-environment-fyzdfhtmgc.elasticbeanstalk.com/umerest/RegistrationService/ValidateActivationCodes?retailerName=venkatesh&phoneNumber=9940206335&activationCode=OTP-8554",params ,
                new AsyncHttpResponseHandler() {
            // When the response returned by REST has Http response code '200'
            @Override
            public void onSuccess(String response) {
                // Hide Progress Dialog
                try {
                    // JSON Object
                    JSONObject obj = new JSONObject(response);
                    Log.d("df", "Output from REST:" + obj.toString());
                    Log.d("df", "Output from REST Response:" + response.toString());
                     Toast.makeText(new LoginActivity().getApplicationContext(), "RESPONSE"+response.toString(), Toast.LENGTH_LONG).show();
                    Toast.makeText( new LoginActivity().getApplicationContext(), "RESPONSE OBJECT"+obj.toString(), Toast.LENGTH_LONG).show();
                    if(obj.getBoolean("status")){
                        // Set Default Values for Edit View controls

                        // Display successfully registered message using Toast
                       // Toast.makeText(getApplicationContext(), "You are successfully registered!", Toast.LENGTH_LONG).show();
                    }
                    // Else display error message
                    else{
                        //errorMsg.setText(obj.getString("error_msg"));
                       // Toast.makeText(getApplicationContext(), obj.getString("error_msg"), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    //Toast.makeText(getApplicationContext(), "Error Occured [Server's JSON response might be invalid]!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();

                }
            }
            // When the response returned by REST has Http response code other than '200'
            @Override
            public void onFailure(int statusCode, Throwable error,
                                  String content) {
                // Hide Progress Dialog
              //  prgDialog.hide();
                // When Http response code is '404'
                if(statusCode == 404){
                 //   Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                }
                // When Http response code is '500'
                else if(statusCode == 500){
                  //  Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
                }
                // When Http response code other than 404, 500
                else{
                   // Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
