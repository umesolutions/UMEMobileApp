/*
package com.mobile.ume.umemobileapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Register4Activity extends AppCompatActivity {
    Button btn_register;
    int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    Button poi_btn,poa_btn,sign_btn;
    ImageView poi_image1,poi_image2,poa_image1,poa_image2,sign_image;
    public static Integer imagePos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register4);
        poi_image1 = (ImageView) findViewById(R.id.poi_image1);
        poi_image2 = (ImageView) findViewById(R.id.poi_image2);
        poa_image1 = (ImageView) findViewById(R.id.poa_image1);
        poa_image2 = (ImageView) findViewById(R.id.poa_image2);
        sign_image = (ImageView) findViewById(R.id.sign_image);
       // poi_btn1 = (Button) findViewById(R.id.poi_button1);
        poi_image1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imagePos=1;
                selectImage();
            }
        });

       // poi_btn2 = (Button) findViewById(R.id.poi_button2);
        poi_image2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imagePos=2;
                selectImage();
            }
        });

       // poa_btn1 = (Button) findViewById(R.id.poa_button1);
        poa_image1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imagePos=3;
                selectImage();
            }
        });

       // poa_btn2 = (Button) findViewById(R.id.poa_button2);
        poa_image2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imagePos=4;
                selectImage();
            }
        });

        sign_btn = (Button) findViewById(R.id.btn_sign);
        sign_image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imagePos=5;
                selectImage();
            }
        });


        btn_register=(Button)findViewById(R.id.reg4_btnSubmit);
        btn_register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                for(int i=0;i<=3;i++) {
                    Toast.makeText(getApplicationContext(), "Thanks for Uploading the Document. The Distributor will keep in touch with you for Verification", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register4, menu);
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


    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Uri selectedImageUri = data.getData();
        String[] projection = { MediaStore.MediaColumns.DATA };
        Cursor cursor = managedQuery(selectedImageUri, projection, null, null,
                null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
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

        if(imagePos==1){
            poi_image1.setImageBitmap(bm);
        }else if(imagePos==2){
            poi_image2.setImageBitmap(bm);
        }else if(imagePos==3){
            poa_image1.setImageBitmap(bm);
        }else if(imagePos==4){
            poa_image2.setImageBitmap(bm);
        }else if(imagePos==5){
            sign_image.setImageBitmap(bm);
        }
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
        AlertDialog.Builder builder = new AlertDialog.Builder(Register4Activity.this);
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
                    intent.setType("image*/
/*");
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
*/
