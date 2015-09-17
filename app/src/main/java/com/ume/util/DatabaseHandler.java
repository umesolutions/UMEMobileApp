package com.ume.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.util.beans.Distributor;
import com.util.beans.Retailer;
import com.util.beans.Catagory;
import com.util.beans.Product;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "umedatabase";
    private static final String TABLE_CONTACTS = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";
    SQLiteDatabase db;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db=getWritableDatabase();
        //3rd argument to be passed is CursorFactory instance
    }
    public void resetDB()
    {
        db=getWritableDatabase();
        {
            String DROP_TABLE = "DROP TABLE  IF EXISTS  APP_REQUEST";
            db.execSQL(DROP_TABLE);
            DROP_TABLE = "DROP TABLE  IF EXISTS  REGISTRATION";
            db.execSQL(DROP_TABLE);
            DROP_TABLE = "DROP TABLE  IF EXISTS  STORE";
            db.execSQL(DROP_TABLE);
            DROP_TABLE = "DROP TABLE  IF EXISTS  LOGIN";
            db.execSQL(DROP_TABLE);
            DROP_TABLE = "DROP TABLE  IF EXISTS  CATEGORY";
            db.execSQL(DROP_TABLE);
            DROP_TABLE = "DROP TABLE  IF EXISTS  CATEGORY_STORE";
            db.execSQL(DROP_TABLE);
            DROP_TABLE = "DROP TABLE  IF EXISTS  PRODUCT";
            db.execSQL(DROP_TABLE);
            DROP_TABLE = "DROP TABLE  IF EXISTS  PRODUCT_ATTRIBUTE";
            db.execSQL(DROP_TABLE);
            DROP_TABLE = "DROP TABLE  IF EXISTS  PRODUCT_DISTRIBUTOR";
            db.execSQL(DROP_TABLE);
            DROP_TABLE = "DROP TABLE  IF EXISTS  ORDER_DETAILS";
            db.execSQL(DROP_TABLE);
            DROP_TABLE = "DROP TABLE  IF EXISTS  ORDERED_PRODUCT";
            db.execSQL(DROP_TABLE);
            DROP_TABLE = "DROP TABLE  IF EXISTS  DISTRIBUTOR";
            db.execSQL(DROP_TABLE);


            Log.i("Debug", "============================================= ");
            String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS APP_REQUEST(DISTRIBUTORID TEXT,ACTIVATIONCODE TEXT,MOBILENO VARCHAR(10),ISVERIFIED TEXT)";
            db.execSQL(CREATE_TABLE);
            CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS REGISTRATION(CUSTOMERID TEXT,CUSTOMERNAME TEXT,ADDRESS TEXT,CITY TEXT,PINCODE TEXT,MOBILENO VARCHAR(10),EMAIL TEXT,PHONEIME TEXT,POI BLOB,POA BLOB,COMMENTS TEXT,LOGINID TEXT,PREFERREDDISTRID TEXT)";
            db.execSQL(CREATE_TABLE);
            CREATE_TABLE = "CREATE TABLE IF NOT EXISTS STORE(STOREID TEXT,STORENAME TEXT,ADDRESS TEXT,CITY TEXT,PINCODE TEXT,CUSTOMERID TEXT)";
            db.execSQL(CREATE_TABLE);
            CREATE_TABLE = "CREATE TABLE IF NOT EXISTS LOGIN(LOGINID TEXT,PASSWORD TEXT,ROLE TEXT)";
            db.execSQL(CREATE_TABLE);
            CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS DISTRIBUTOR(DISTRIBUTORID TEXT,DISTRIBUTORNAME TEXT,ADDRESS TEXT,CITY TEXT,PINCODE TEXT,MOBILENO VARCHAR(10),EMAIL TEXT,PHONEIME TEXT,LOGINID TEXT)";
            db.execSQL(CREATE_TABLE);
            CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS CATEGORY(CATEGORYID TEXT,NAME TEXT)";
            db.execSQL(CREATE_TABLE);
            CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS CATEGORY_STORE(CATEGORYID TEXT,STOREID TEXT)"; // Not needed as of now.
            db.execSQL(CREATE_TABLE);
            CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS PRODUCT(PRODUCTID TEXT,PRODUCTNAME TEXT,PRICE REAL,MODEL TEXT,WEIGHT TEXT,CATEGORYID TEXT)";
            db.execSQL(CREATE_TABLE);
            CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS PRODUCT_ATTRIBUTE(PRODUCTID TEXT,ATTRIBUTEID TEXT,NAME TEXT,VALUE TEXT)";
            db.execSQL(CREATE_TABLE);
            CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS PRODUCT_DISTRIBUTOR(PRODUCTID TEXT,DISTRIBUTORID TEXT)";
            db.execSQL(CREATE_TABLE);
            CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS ORDER_DETAILS(ORDERID TEXT,RETAILERID TEXT,STOREID TEXT,DISTRIBUTORID TEXT,AMOUNT REAL,ORDER_DATE DATE)";
            db.execSQL(CREATE_TABLE);
            CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS ORDERED_PRODUCT(ORDERID TEXT,PRODUCTID TEXT,PRODUCT NAME,QUANTITY INT)";
            db.execSQL(CREATE_TABLE);
            insert(db);
        }
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String DROP_TABLE = "DROP TABLE  IF EXISTS  APP_REQUEST";
        db.execSQL(DROP_TABLE);
        DROP_TABLE = "DROP TABLE  IF EXISTS  REGISTRATION";
        db.execSQL(DROP_TABLE);
        DROP_TABLE = "DROP TABLE  IF EXISTS  STORE";
        db.execSQL(DROP_TABLE);
        DROP_TABLE = "DROP TABLE  IF EXISTS  LOGIN";
        db.execSQL(DROP_TABLE);
        DROP_TABLE = "DROP TABLE  IF EXISTS  CATEGORY";
        db.execSQL(DROP_TABLE);
        DROP_TABLE = "DROP TABLE  IF EXISTS  CATEGORY_STORE";
        db.execSQL(DROP_TABLE);
        DROP_TABLE = "DROP TABLE  IF EXISTS  PRODUCT";
        db.execSQL(DROP_TABLE);
        DROP_TABLE = "DROP TABLE  IF EXISTS  PRODUCT_ATTRIBUTE";
        db.execSQL(DROP_TABLE);
        DROP_TABLE = "DROP TABLE  IF EXISTS  PRODUCT_DISTRIBUTOR";
        db.execSQL(DROP_TABLE);
        DROP_TABLE = "DROP TABLE  IF EXISTS  ORDER_DETAILS";
        db.execSQL(DROP_TABLE);
        DROP_TABLE = "DROP TABLE  IF EXISTS  ORDERED_PRODUCT";
        db.execSQL(DROP_TABLE);
        DROP_TABLE = "DROP TABLE  IF EXISTS  DISTRIBUTOR";
        db.execSQL(DROP_TABLE);

        Log.i("Debug", "============================================= ");
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS APP_REQUEST(DISTRIBUTORID TEXT,ACTIVATIONCODE TEXT,MOBILENO VARCHAR(10),ISVERIFIED TEXT)";
        db.execSQL(CREATE_TABLE);
        CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS REGISTRATION(CUSTOMERID TEXT,CUSTOMERNAME TEXT,ADDRESS TEXT,CITY TEXT,PINCODE TEXT,MOBILENO VARCHAR(10),EMAIL TEXT,PHONEIME TEXT,POI BLOB,POA BLOB,COMMENTS TEXT,LOGINID TEXT,PREFERREDDISTRID TEXT)";
        db.execSQL(CREATE_TABLE);
        CREATE_TABLE = "CREATE TABLE IF NOT EXISTS STORE(STOREID TEXT,STORENAME TEXT,ADDRESS TEXT,CITY TEXT,PINCODE TEXT,CUSTOMERID TEXT)";
        db.execSQL(CREATE_TABLE);
        CREATE_TABLE = "CREATE TABLE IF NOT EXISTS LOGIN(LOGINID TEXT,PASSWORD TEXT,ROLE TEXT)";
        db.execSQL(CREATE_TABLE);
        CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS DISTRIBUTOR(DISTRIBUTORID TEXT,DISTRIBUTORNAME TEXT,ADDRESS TEXT,CITY TEXT,PINCODE TEXT,MOBILENO VARCHAR(10),EMAIL TEXT,PHONEIME TEXT,LOGINID TEXT)";
        db.execSQL(CREATE_TABLE);
        CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS CATEGORY(CATEGORYID TEXT,NAME TEXT)";
        db.execSQL(CREATE_TABLE);
        CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS CATEGORY_STORE(CATEGORYID TEXT,STOREID TEXT)"; // Not needed as of now.
        db.execSQL(CREATE_TABLE);
        CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS PRODUCT(PRODUCTID TEXT,PRODUCTNAME TEXT,PRICE REAL,MODEL TEXT,WEIGHT TEXT,CATEGORYID TEXT)";
        db.execSQL(CREATE_TABLE);
        CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS PRODUCT_ATTRIBUTE(PRODUCTID TEXT,ATTRIBUTEID TEXT,NAME TEXT,VALUE TEXT)";
        db.execSQL(CREATE_TABLE);
        CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS PRODUCT_DISTRIBUTOR(PRODUCTID TEXT,DISTRIBUTORID TEXT)";
        db.execSQL(CREATE_TABLE);
        CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS ORDER_DETAILS(ORDERID TEXT,RETAILERID TEXT,STOREID TEXT,DISTRIBUTORID TEXT,AMOUNT REAL,ORDER_DATE DATE)";
        db.execSQL(CREATE_TABLE);
        CREATE_TABLE = "CREATE  TABLE IF NOT EXISTS ORDERED_PRODUCT(ORDERID TEXT,PRODUCTID TEXT,PRODUCT NAME,QUANTITY INT)";
        db.execSQL(CREATE_TABLE);
        insert(db);
    }


    public void insert(SQLiteDatabase db) {

        String INSERT_TABLE = "INSERT INTO LOGIN VALUES('DIST0001','ABC@123','Distributor')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO LOGIN VALUES('DIST0002','ABC@123','Distributor')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO LOGIN VALUES('DIST0003','ABC@123','Distributor')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO DISTRIBUTOR VALUES('D0001','KRISH','T.Nagar','Chennai','600001','9898989898','abcd@gmail.com','IMEPhone_ABC','DIST0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO DISTRIBUTOR VALUES('D0002','BALAG','Mambalam','Chennai','600002','9898909098','defd@gmail.com','IMEPhone_DEF','DIST0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO DISTRIBUTOR VALUES('D0001','VENKY','Tambaram','Chennai','600003','9878987888','xyz@gmail.com','IMEPhone_XYZ','DIST0003')";
        db.execSQL(INSERT_TABLE);

        INSERT_TABLE = "INSERT INTO CATEGORY VALUES('C0001','Mobiles')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO CATEGORY VALUES('C0002','Television')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT VALUES('P0001','Nokia',10000.00,'Model 2000','.23kg','C0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT VALUES('P0002','Nokia',11000.00,'Model 2005','.25kg','C0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT VALUES('P0003','Samsung',12000.00,'Model 2001','.13kg','C0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT VALUES('P0004','Samsung',20000.00,'Model 2013','.18kg','C0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT VALUES('P0005','Micromax',8000.00,'Model 2010','.30kg','C0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT VALUES('P0006','Micromax',9000.00,'Model 2015','.32kg','C0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT VALUES('P0007','Micromax',19000.00,'Model 2014','1.32kg','C0001')";
        db.execSQL(INSERT_TABLE);
        //Televisions
        INSERT_TABLE = "INSERT INTO PRODUCT VALUES('P0008','LG',9000.00,'LCD 42','3.32kg','C0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT VALUES('P0009','LG',19000.00,'LED 42','1.32kg','C0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT VALUES('P0010','SAMSUNG',29000.00,'LED 32','2.32kg','C0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT VALUES('P0011','SAMSUNG',8000.00,'LCD 24','3.32kg','C0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT VALUES('P0012','SAMSUNG',21000.00,'Plasma 40','5.32kg','C0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT VALUES('P0013','LG',9200.00,'LCD 32','8.32kg','C0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT VALUES('P0014','LG',9900.00,'LCD 39','.32kg','C0002')";
        db.execSQL(INSERT_TABLE);


        ///Product_Attribute
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0001','A0001','Color','Blue')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0001','A0002','Front Camera','Yes')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0001','A0003','3G/4G support','Yes')";
        db.execSQL(INSERT_TABLE);

        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0002','A0001','Color','RED')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0002','A0002','Back Camera','5MB')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0002','A0003','WIFI','Yes')";
        db.execSQL(INSERT_TABLE);

        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0003','A0001','Color','Yellow')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0003','A0002','BlueTooth','Yes')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0003','A0003','Lollipop Support','Yes')";
        db.execSQL(INSERT_TABLE);

        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0004','A0001','Color','Black')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0004','A0002','Radio','Yes')";
        db.execSQL(INSERT_TABLE);


        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0005','A0001','Color','Blue')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0005','A0002','WIFI','Yes')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0005','A0003','2G','Yes')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0005','A0004','Offer Available','Yes')";
        db.execSQL(INSERT_TABLE);

        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0006','A0001','Color','Violet')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0006','A0002',' Camera','Yes')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0006','A0003','3G/4G support','Yes')";
        db.execSQL(INSERT_TABLE);

        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0007','A0001','Color','Blue')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0007','A0002','Front Camera','Yes')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0007','A0003','3G/4G support','Yes')";
        db.execSQL(INSERT_TABLE);

        //Television Attribute
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0008','A0001','Color','Blue')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0008','A0002','Warranty','6 months')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0008','A0003','SMART','Yes')";
        db.execSQL(INSERT_TABLE);

        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0009','A0001','Color','Blue')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0009','A0002','USB Supported','Yes')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0009','A0003','Eye safe glasses','Yes')";
        db.execSQL(INSERT_TABLE);


        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0010','A0001','Color','Blue')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0010','A0002','Offer available','Yes')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0010','A0003','Warrenty','4 years')";
        db.execSQL(INSERT_TABLE);

        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0011','A0001','Color','Blue')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0011','A0002','Warrenty available','Yes')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0011','A0003','3G/4G support','Yes')";
        db.execSQL(INSERT_TABLE);

        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0012','A0001','Color','Blue')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0012','A0002','Speaker watts','5000')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0012','A0003','External speaker','Yes')";
        db.execSQL(INSERT_TABLE);


        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0013','A0001','Color','Blue')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0013','A0002','Offer percentage','40')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0013','A0003','USB Supported','No')";
        db.execSQL(INSERT_TABLE);

        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0014','A0001','Color','Blue')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0014','A0002','Compatible with Laptop','Yes')";
        db.execSQL(INSERT_TABLE);

        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0008','A0004','External Speaker','Yes')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0009','A0004','USB Supported','Yes')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_ATTRIBUTE VALUES('P0010','A0004','SMART','Yes')";
        db.execSQL(INSERT_TABLE);

        //PRODUCT_DISTRIBUTE
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0001','D0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0002','D0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0004','D0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0003','D0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0014','D0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0011','D0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0005','D0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0006','D0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0009','D0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0008','D0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0010','D0001')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0013','D0001')";
        db.execSQL(INSERT_TABLE);

        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0002','D0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0004','D0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0009','D0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0007','D0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0001','D0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0010','D0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0011','D0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0005','D0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0012','D0002')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0014','D0001')";
        db.execSQL(INSERT_TABLE);

        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0007','D0003')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0005','D0003')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0001','D0003')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0013','D0003')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0002','D0003')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0001','D0003')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0012','D0003')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0007','D0003')";
        db.execSQL(INSERT_TABLE);
        INSERT_TABLE = "INSERT INTO PRODUCT_DISTRIBUTOR VALUES('P0008','D0003')";
        db.execSQL(INSERT_TABLE);


    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }
   public String getLogin(String username,String password)
   {
       SQLiteDatabase db = this.getReadableDatabase();
       Cursor res =  db.rawQuery( "select ROLE from LOGIN where upper(loginid)='"+ username.toUpperCase()+"' and upper(PASSWORD)='"+password.toUpperCase()+"'", null );
       if(res.moveToFirst()){
            String role=res.getString(res.getColumnIndex("ROLE"));
            return role;
       }
       return null;
   }
    public Distributor getDistributor(String loginid)
    {
        Distributor distributor= new Distributor();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from DISTRIBUTOR where upper(loginid)='"+ loginid.toUpperCase()+"'", null );
        if(res.moveToFirst()){
            distributor.setDistributorid(res.getString(res.getColumnIndex("DISTRIBUTORID")));
            distributor.setName(res.getString(res.getColumnIndex("DISTRIBUTORNAME")));
            distributor.setAddress(res.getString(res.getColumnIndex("ADDRESS")));
            distributor.setCity(res.getString(res.getColumnIndex("CITY")));
            distributor.setPincode(res.getString(res.getColumnIndex("PINCODE")));
            distributor.setMobileno(res.getString(res.getColumnIndex("MOBILENO")));
            distributor.setEmailid(res.getString(res.getColumnIndex("EMAIL")));
            distributor.setPhoneIMENo(res.getString(res.getColumnIndex("PHONEIME")));
            distributor.getLogin().setUserid(loginid);
            return distributor;
        }
        return null;
    }
    public void insertAccessCode(String distid,String mobileno,String accessCode)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Insert into APP_REQUEST Values('"+distid+"','"+accessCode+"','"+mobileno+"','FALSE')");
    }

    public String verifyOTP(Retailer retailer){return null;}
//    {
// Distributor distributor= new Distributor();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor res =  db.rawQuery( "select * from APP_REQUEST where upper(ACTIVATIONCODE)='"+ retailer.getOTP().toUpperCase()+"' and MOBILENO='"+retailer.getMobileno()+"'", null );
//        if(res.moveToFirst()){
//            retailer.setPreferredDistributorid(res.getString(res.getColumnIndex("DISTRIBUTORID")));
//            return res.getString(res.getColumnIndex("DISTRIBUTORID"));
//        }
//        else{
//            return null;
//        }
//
//        return null;
//    }
    public String insertRetailer(Retailer retailer){return null;}
//    {
//        SQLiteDatabase myDb = this.getWritableDatabase();
//        byte[] byteImage1 = null;
//        String s = myDb.getPath();
//
//         // clearing the table
//        ContentValues newValues = new ContentValues();
//        String retailerid="R"+ new java.util.Random().nextInt(10000);
//        retailer.setRetailId(retailerid);
//        newValues.put("CUSTOMERID", retailerid);
//        newValues.put("CUSTOMERNAME", retailer.getName());
//        newValues.put("ADDRESS", retailer.getAddress());
//        newValues.put("CITY", retailer.getCity());
//        newValues.put("PINCODE", retailer.getPincode());
//        newValues.put("MOBILENO", retailer.getMobileno());
//        newValues.put("EMAIL", retailer.getEmailid());
//        newValues.put("PHONEIME", retailer.getPhoneIMENo());
//        newValues.put("COMMENTS", "All terms and condition agreed");
//        newValues.put("LOGINID", retailer.getLogin().getUserid());
//        newValues.put("PREFERREDDISTRID",retailer.getPreferredDistributorid());
//        try {
//            if(retailer.getImagePOI()!=null) {
//                FileInputStream instream = new FileInputStream(retailer.getImagePOI());
//                BufferedInputStream bif = new BufferedInputStream(instream);
//                byteImage1 = new byte[bif.available()];
//                bif.read(byteImage1);
//                newValues.put("POI", byteImage1);
//            }else
//            {
//                newValues.put("POI", new byte[1]);
//            }
//            if(retailer.getImagePOA()!=null) {
//                FileInputStream instream = new FileInputStream(retailer.getImagePOA());
//                BufferedInputStream bif = new BufferedInputStream(instream);
//                byteImage1 = new byte[bif.available()];
//                bif.read(byteImage1);
//                newValues.put("POA", byteImage1);
//            }else
//            {
//                newValues.put("POA", new byte[1]);
//            }
//            long ret = myDb.insert("REGISTRATION", null, newValues);
//            if (ret > 0)
//                return "Inserted Successfully";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        myDb.close();
//        return null;
//    }
    public String insertStore(Retailer retailer)
    {
        SQLiteDatabase myDb = this.getWritableDatabase();
        byte[] byteImage1 = null;
        String s = myDb.getPath();

        // clearing the table
        ContentValues newValues = new ContentValues();
        newValues.put("STOREID", "STORE"+ new java.util.Random().nextInt(10000));
        newValues.put("STORENAME", retailer.getFirstname());
        newValues.put("ADDRESS", retailer.getAddress());
        newValues.put("CITY", retailer.getCity());
        newValues.put("PINCODE", retailer.getPincode());
        newValues.put("CUSTOMERID", retailer.getRetailId());

        try{
            long ret = myDb.insert("STORE", null, newValues);
            if (ret > 0)
                return "Inserted Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        myDb.close();
        return null;
    }
    public String insertLogin(String username,String password)
    {
        SQLiteDatabase myDb = this.getWritableDatabase();
        byte[] byteImage1 = null;
        String s = myDb.getPath();

        // clearing the table
        ContentValues newValues = new ContentValues();
        newValues.put("LOGINID", username);
        newValues.put("PASSWORD",password);
        newValues.put("ROLE", "RETAILER");


        try{
            long ret = myDb.insert("LOGIN", null, newValues);
            if (ret > 0)
                return "Inserted Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        myDb.close();
        return null;
    }
    public List<Retailer> getUnApprovedRetailers(String distid){return null;}
//    {
//        SQLiteDatabase myDb = this.getReadableDatabase();
//        ArrayList<Retailer> retailers = new ArrayList<Retailer>();
//        try {
//            SQLiteDatabase db = this.getReadableDatabase();
//            Cursor res = db.rawQuery("select CUSTOMERID,CUSTOMERNAME,REGISTRATION.MOBILENO from REGISTRATION,APP_REQUEST where upper(PREFERREDDISTRID)='" + distid.toUpperCase() + "' and PREFERREDDISTRID = DISTRIBUTORID and ISVERIFIED='FALSE' ", null);
//            while (res.moveToNext()) {
//                Retailer retailer = new Retailer();
//                retailer.setRetailId(res.getString(res.getColumnIndex("CUSTOMERID")));
//                retailer.setName(res.getString(res.getColumnIndex("CUSTOMERNAME")));
//
//                retailer.setMobileno(res.getString(res.getColumnIndex("MOBILENO")));
//                retailers.add(retailer);
//            }
//            return retailers;
//        }catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
    public boolean updateAppRequest(String mobileno)
    {
        SQLiteDatabase myDb = this.getWritableDatabase();
        try {
            db.execSQL("UPDATE APP_REQUEST SET ISVERIFIED='TRUE' WHERE MOBILENO='" +mobileno+"'");
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean getAppRequestStatus(String loginid)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select ISVERIFIED from APP_REQUEST where  MOBILENO=(SELECT MOBILENO FROM REGISTRATION WHERE upper(LOGINID)='"+loginid.toUpperCase()+"')", null );
        if(res.moveToFirst()){
            return(res.getString(res.getColumnIndex("ISVERIFIED"))).equalsIgnoreCase("TRUE");
        }
        else{
            return false;
        }

    }

    public List<Catagory> getAllCategory(){
        List<Catagory> catagories = new ArrayList<Catagory>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from CATEGORY", null );
        while(res.moveToNext()){
            Catagory catagory = new Catagory();
            catagory.setCatagoryId(res.getString(res.getColumnIndex("CATEGORYID")));
            catagory.setCatagoryName(res.getString(res.getColumnIndex("NAME")));
            catagories.add(catagory);
        }
       return catagories;
    }

    public List<Distributor> getAllDistributor(){
        List<Distributor> distributors = new ArrayList<Distributor>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from DISTRIBUTOR", null );
        while(res.moveToNext()){
            Distributor distributor = new Distributor();
            distributor.setDistributorid(res.getString(res.getColumnIndex("DISTRIBUTORID")));
            distributor.setName(res.getString(res.getColumnIndex("DISTRIBUTORNAME")));
            distributors.add(distributor);
        }
        return distributors;
    }

    public List<Distributor> getDistributorsForCategory(String categoryid){
        List<Distributor> distributors = new ArrayList<Distributor>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from DISTRIBUTOR where DISTRIBUTORID in(SELECT DISTRIBUTORID from PRODUCT_DISTRIBUTOR" +
                " WHERE PRODUCTID IN(SELECT PRODUCTID from PRODUCT where CATEGORYID='"+categoryid+"'))", null );
        while(res.moveToNext()){
            Distributor distributor = new Distributor();
            distributor.setDistributorid(res.getString(res.getColumnIndex("DISTRIBUTORID")));
            distributor.setName(res.getString(res.getColumnIndex("DISTRIBUTORNAME")));
            distributors.add(distributor);
        }
        return distributors;
    }
    public List<Product> getProductForDistributor(String distributorid,String categoryname){

        List<Product> products = new ArrayList<Product>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            System.out.println("select * from PRODUCT where CATEGORYID =(SELECT CATEGORYID from CATEGORY where CATEGORYNAME='" + categoryname + "') and PRODUCTID in(SELECT PRODUCTID from PRODUCT_DISTRIBUTOR" +
                    " WHERE DISTRIBUTORID =(SELECT DISTRIBUTORID FROM DISTRIBUTOR WHERE DISTRIBUTORNAME='" + distributorid + "'))");

            Cursor res = db.rawQuery("select * from PRODUCT where CATEGORYID =(SELECT CATEGORYID from CATEGORY where NAME='" + categoryname + "') and PRODUCTID in(SELECT PRODUCTID from PRODUCT_DISTRIBUTOR" +
                    " WHERE DISTRIBUTORID =(SELECT DISTRIBUTORID FROM DISTRIBUTOR WHERE DISTRIBUTORNAME='" + distributorid + "'))", null);
                while (res.moveToNext()) {
                Product product = new Product();
                product.setPrice(res.getInt(res.getColumnIndex("PRICE")));
                product.setName(res.getString(res.getColumnIndex("PRODUCTNAME")));
                product.setProductid(res.getString(res.getColumnIndex("PRODUCTID")));
                product.setModel(res.getString(res.getColumnIndex("MODEL")));
                products.add(product);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return products;
    }
}
