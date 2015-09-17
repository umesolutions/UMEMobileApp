//package com.mobile.ume.umemobileapp;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.ume.util.DatabaseHandler;
//import com.util.beans.Distributor;
//
//public class DistributorMainActivity extends AppCompatActivity {
//
//    Distributor dist;
//    Button approve,vieworder,accesscode;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_distributor_main);
//        approve=(Button)findViewById(R.id.btn_approve);
//       // vieworder=(Button)findViewById(R.id.btn_vieworder);
//        accesscode=(Button)findViewById(R.id.btn_accesscode);
//
//        Bundle b = new Bundle();
//        b = getIntent().getExtras();
//        final String loginid =(String) b.get("loginid");
//        DatabaseHandler databaseHandler= new DatabaseHandler(this);
//        dist= databaseHandler.getDistributor(loginid);
//        TextView textView= (TextView)findViewById(R.id.textView);
//        if(dist!=null)
//             textView.setText("Welcome "+ dist.getName());
//        else
//            textView.setText("Welcome");
//
//        approve.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getBaseContext(), ApproveRetailerActivity.class);
//                intent.putExtra("distid",dist.getDistributorid());
//                intent.putExtra("loginid",loginid);
//                startActivity(intent);
//            }
//        });
//
////        vieworder.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
//////                Intent intent = new Intent(getBaseContext(), RegisterPersonalDetailsActivity.class);
//////                intent.putExtra("distid",dist.getDistributorid());
//////                startActivity(intent);
////            }
////        });
//
//
//        accesscode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_distributor_main, menu);
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
