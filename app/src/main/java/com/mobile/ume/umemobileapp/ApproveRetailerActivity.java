//package com.mobile.ume.umemobileapp;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.LinearLayout;
//import android.widget.Toast;
//
//import com.ume.util.DatabaseHandler;
//import com.util.beans.Retailer;
//
//import java.util.List;
//import android.os.Bundle;
//import android.app.Activity;
//import android.app.ActionBar.LayoutParams;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//public class ApproveRetailerActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_approve_retailer);
//        Bundle b = new Bundle();
//        b = getIntent().getExtras();
//        final String distid =(String) b.get("distid");
//        final String loginid=(String) b.get("loginid");
//        final DatabaseHandler databaseHandler= new DatabaseHandler(getApplicationContext());
//        final List<Retailer> retailers = databaseHandler.getUnApprovedRetailers(distid);
//        if(retailers==null || retailers.size()<1)
//        {
//            Toast.makeText(getApplicationContext(), "No Valid Retailer for approval" ,
//                    Toast.LENGTH_LONG).show();
//        }else
//        {
//            final LinearLayout lm = (LinearLayout) findViewById(R.id.dynamiclayout);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//            for(int j=0;j<retailers.size();j++){
//            LinearLayout ll = new LinearLayout(this);
//            ll.setOrientation(LinearLayout.HORIZONTAL);
//            TextView product = new TextView(this);
//           // product.setText("Retailer Name:"+retailers.get(j).getName()+ "     ");
//            ll.addView(product);
//            final Button btn = new Button(this);
//            // Give button an ID
//            btn.setId(j+1);
//            btn.setText("Approve");
//            // set the layoutParams on the button
//            btn.setLayoutParams(params);
//
//            final int index = j;
//            btn.setOnClickListener(new OnClickListener() {
//               public void onClick(View v) {
//                    databaseHandler.updateAppRequest(retailers.get(index).getMobileno());
//                    Log.i("TAG", "index :" + index);
//                    Toast.makeText(getApplicationContext(),"Retailer Approved",Toast.LENGTH_LONG).show();
//                   Intent intent = new Intent(getBaseContext(), DistributorMainActivity.class);
//                   intent.putExtra("distid", distid);
//                   intent.putExtra("loginid", loginid);
//                   startActivity(intent);
//                    }
//                });
//
//           ll.addView(btn);
//
//          lm.addView(ll);
//          }
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_approve_retailer, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
