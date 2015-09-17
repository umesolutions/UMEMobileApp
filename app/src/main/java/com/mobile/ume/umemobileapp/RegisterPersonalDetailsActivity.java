package com.mobile.ume.umemobileapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View.OnClickListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.provider.MediaStore.MediaColumns;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.widget.DatePicker;
import android.widget.ImageButton;


import com.ume.util.DatabaseHandler;
import com.util.beans.Login;
import com.util.beans.Retailer;
import com.util.beans.Store;

public class RegisterPersonalDetailsActivity extends AppCompatActivity {
    Button btn_register;
    int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    StringBuffer errorMessage=new StringBuffer();
    ImageView ivImage,poi_image1,poi_image2,poa_image1,poa_image2,sign_image;
    boolean image1selected=false, image2selected=false,image3selected=false, image4selected=false,image5selected=false, image6selected=false;
   // private ListView lv;
    public static Integer imagePos;
    private ImageButton ib;
    private Calendar cal;
    private int day;
    private int month;
    private int year;
    Spinner gender_spinner;
    EditText reg_firstname,reg_lastname,reg_DOB,reg_mobileno,reg_emailid,reg_address,reg_City,reg_pincode,reg_storename,reg_storeaddress,reg_storeCity,reg_storepincode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details_registration);
        Bundle b = new Bundle();
        b = getIntent().getExtras();
        final String loginid =(String) b.get("name");
        final String mobilenumber =(String) b.get("mobileno");
        final String username=(String) b.get("username");
        final String password=(String)b.get("password");

        btn_register=(Button)findViewById(R.id.btnRegister);
        reg_firstname=(EditText)findViewById(R.id.reg_firstname);
        reg_lastname=(EditText)findViewById(R.id.reg_lastname);
        reg_DOB=(EditText)findViewById(R.id.reg_DOB);
        reg_mobileno=(EditText)findViewById(R.id.reg_mobileno);
        reg_emailid=(EditText)findViewById(R.id.reg_emailid);
        reg_address=(EditText)findViewById(R.id.reg_address);
        reg_City=(EditText)findViewById(R.id.reg_City);
        reg_pincode=(EditText)findViewById(R.id.reg_pincode);

        reg_storename=(EditText)findViewById(R.id.reg_storename);
        reg_storeaddress=(EditText)findViewById(R.id.reg_storeaddress);
        reg_storeCity=(EditText)findViewById(R.id.reg_storeCity);
        reg_storepincode=(EditText)findViewById(R.id.reg_storepincode);
        gender_spinner=(Spinner)findViewById(R.id.gender_spinner);


        ib = (ImageButton) findViewById(R.id.imageButton1);
        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);
        reg_DOB = (EditText) findViewById(R.id.reg_DOB);
        ib.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });

        ivImage =  (ImageView) findViewById(R.id.ivImage);
        poi_image1 = (ImageView) findViewById(R.id.poi_image1);
        poi_image2 = (ImageView) findViewById(R.id.poi_image2);
        poa_image1 = (ImageView) findViewById(R.id.poa_image1);
        poa_image2 = (ImageView) findViewById(R.id.poa_image2);
        sign_image = (ImageView) findViewById(R.id.sign_image);


        ivImage.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                image6selected=true;
                imagePos=6;
                selectImage();

            }
        });

        poi_image1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                image1selected=true;
                imagePos=1;
                selectImage();
            }
        });

        poi_image2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                image2selected=true;
                imagePos=2;
                selectImage();
            }
        });

        poa_image1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                image3selected=true;
                imagePos=3;
                selectImage();
            }
        });

        poa_image2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                image4selected=true;
                imagePos=4;
                selectImage();
            }
        });

        sign_image.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                image5selected=true;
                imagePos=5;
                selectImage();
            }
        });
        reg_mobileno.setText(mobilenumber);
        reg_mobileno.setEnabled(true);
        Spinner spinner = (Spinner) findViewById(R.id.gender_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retailer retailer = new Retailer();
                retailer.setFirstname(isNullCheck("FirstName", reg_firstname.getText().toString()));
                retailer.setLastname(isNullCheck("LastName", reg_lastname.getText().toString()));
                retailer.setDOB(isNullCheck("DOB", reg_DOB.getText().toString()));
                retailer.setGender(isNullCheck("Gender", gender_spinner.getSelectedItem().toString()));
                retailer.setMobileno(isNullCheck("Mobile No", reg_mobileno.getText().toString()));
                retailer.setEmailid(isNullCheck("Email ID", reg_emailid.getText().toString()));
                retailer.setAddress(isNullCheck("Address", reg_address.getText().toString()));
                retailer.setCity(isNullCheck("City", reg_City.getText().toString()));
                retailer.setPincode(isNullCheck("PinCode", reg_pincode.getText().toString()));
                Store store = new Store();
                store.setStorename(isNullCheck("Store Name", reg_storename.getText().toString()));
                store.setAddress(isNullCheck("Store Address", reg_storeaddress.getText().toString()));
                store.setCity(isNullCheck("Store City", reg_storeCity.getText().toString()));
                store.setPincode(isNullCheck("Store Pin Code", reg_storepincode.getText().toString()));
                Login login = new Login();
                login.setPassword(password);
                login.setUserid(username);
                retailer.setLogin(login);
                retailer.setStore(store);
                if(errorMessage.length()>0)
                {
                    for(int i=0;i<2;i++)
                     Toast.makeText(RegisterPersonalDetailsActivity.this, errorMessage +" fields are empty. Kindly fill the fields", Toast.LENGTH_SHORT).show();
                    errorMessage=new StringBuffer();
                    return;
                }else if(!(image6selected&&image1selected&&image2selected&&image3selected&&image4selected&&image5selected))
                {
                    for(int i=0;i<2;i++)
                        Toast.makeText(RegisterPersonalDetailsActivity.this, "Attach all the documents. Few documents not attached", Toast.LENGTH_SHORT).show();
                   // image6selected = false;image1selected=false;image2selected=true;image3selected=true;image4selected=true;image5selected=true;
                    return;
                }

                Toast.makeText(RegisterPersonalDetailsActivity.this, "Personal Data Saved...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), MainMenuActivity.class);
                startActivity(intent);
            }
        });



    }

     private String isNullCheck(String field,String text)
     {
         if(text==null||text.equalsIgnoreCase("")||text.trim().length()<1) {
             errorMessage.append(field+",");return "";
         }
         return text;
     }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.getDeviceId();

        getMenuInflater().inflate(R.menu.menu_register, menu);
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
    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            reg_DOB.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
                    + selectedYear);
        }
    };
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode == RESULT_OK) {
//            if (requestCode == 1) {
//                Uri selectedImageUri = data.getData();
//                selectedImagePath1 = getPath(selectedImageUri);
//
//                System.out.println("Image Path : " + selectedImagePath1);
//                img.setImageURI(selectedImageUri);
//            }else if (requestCode == 2) {
//                Uri selectedImageUri = data.getData();
//                selectedImagePath2 = getPath(selectedImageUri);
//                System.out.println("Image Path : " + selectedImagePath2);
//                img1.setImageURI(selectedImageUri);
//            }
//        }
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);


        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(imagePos==1){
            poi_image1.setImageBitmap(thumbnail);
        }else if(imagePos==2){
            poi_image2.setImageBitmap(thumbnail);
        }else if(imagePos==3){
            poa_image1.setImageBitmap(thumbnail);
        }else if(imagePos==4){
            poa_image2.setImageBitmap(thumbnail);
        }else if(imagePos==5){
            sign_image.setImageBitmap(thumbnail);
        }else if(imagePos==6){
            ivImage.setImageBitmap(thumbnail);
        }

    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Uri selectedImageUri = data.getData();
        String[] projection = { MediaStore.MediaColumns.DATA };
        Cursor cursor = managedQuery(selectedImageUri, projection, null, null,
                null);
        int column_index = cursor.getColumnIndexOrThrow(MediaColumns.DATA);
        cursor.moveToFirst();

        String selectedImagePath = cursor.getString(column_index);

        Bitmap bm;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(selectedImagePath, options);
        final int REQUIRED_SIZE = 200;
        int scale = 1;
        while (options.outWidth / scale / 2 >= REQUIRED_SIZE
                && options.outHeight / scale / 2 >= REQUIRED_SIZE)
            scale *= 2;
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(selectedImagePath, options);

        ivImage.setImageBitmap(bm);
    }

    public String getPath(Uri uri) {
        Cursor cursor = null;
        Context context=getApplicationContext();
        try {
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = context.getContentResolver().query(uri,  proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library", "Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterPersonalDetailsActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);
                } else if (items[item].equals("Choose from Library")) {
                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(
                            Intent.createChooser(intent, "Select File"),
                            SELECT_FILE);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
}
