/*
package com.mobile.ume.umemobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ume.util.DatabaseHandler;
import com.util.beans.Product;

import java.util.List;

public class ViewOrders extends AppCompatActivity {

    public static String message="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_orders);
        Bundle b = new Bundle();
        b = getIntent().getExtras();
        String distname =(String) b.get("distributorname");
        String categoryname = (String) b.get("categoryname");
        final LinearLayout lm = (LinearLayout) findViewById(R.id.vieworderlayout);
    //    DatabaseHandler databaseHandler = new DatabaseHandler(this);
     //   final List<Product> products = databaseHandler.getProductForDistributor(distname,categoryname);
        // create the layout params that will be used to define how your
        // button will be displayed
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        //Create four
        for(int j=0;j<=products.size();j++)
        {
            // Create LinearLayout
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            if(j==products.size())
            {
                final Button btn = new Button(this);
                // Give button an ID
                btn.setId(j + 1);
                btn.setText("Confirm");
                // set the layoutParams on the button
                btn.setLayoutParams(params);
                btn.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        if (message != null && message.length() > 10) {
                            Toast.makeText(ViewOrders.this, " Your order confirmed with Products" + message, Toast.LENGTH_SHORT).show();
                            message="";
                            Intent intent = new Intent(getBaseContext(), RetailerOrderActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(ViewOrders.this, " Kindly select list of products to order", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                //Add button to LinearLayout
                ll.addView(btn);
                //Add button to LinearLayout defined in XML
                lm.addView(ll);
                return;
            }
            // Create TextView
            TextView product = new TextView(this);
            product.setText(""+products.get(j).getName()+"-");
            ll.addView(product);

            // Create TextView
            TextView price = new TextView(this);
            price.setText(" " +products.get(j).getPrice()+"-");
            ll.addView(price);

            TextView model = new TextView(this);
            model.setText(" " +products.get(j).getModel());
            ll.addView(model);
            // Create Button
            final Button btn = new Button(this);
            // Give button an ID
            btn.setId(j+1);
            btn.setText(" ADD ");
            btn.setRight(1);
            // set the layoutParams on the button
            btn.setLayoutParams(params);

            final int index = j;
            // Set click listener for button
            btn.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {

                   message=message+","+products.get(index).getName()+"("+products.get(index).getModel()+")";

                }
            });

            //Add button to LinearLayout
            ll.addView(btn);
            //Add button to LinearLayout defined in XML
            lm.addView(ll);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_orders, menu);
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
*/
