package com.example.databaseassignment.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="user_db";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_NAME="user";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_PHONE="phone";
    public static final String COLUMN_ADDRESS="address";

    public DBHelper(Context context) {
        super(context,DATABASE_NAME ,null, DATABASE_VERSION);
        Log.i("hi","DATABASE created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         String CREATE_TABLE_QUERY="create table if not exists "+TABLE_NAME+
                 "("+COLUMN_ID+" Integer primary key autoincrement,"+
                 COLUMN_NAME+" varchar,"+
                 COLUMN_PHONE+" varchar,"+
                 COLUMN_ADDRESS+" varchar)";
         try {
             db.execSQL(CREATE_TABLE_QUERY);
             Log.i("hi", "table created");
         }catch(SQLException e){
             Log.i("hi","table not created");
         }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           db.execSQL("Drop table if exists "+TABLE_NAME);
           onCreate(db);
           Log.i("hi","database updated");
    }

    public void addUser(int id,String name,String phone,String address){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_ID,id);
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_PHONE,phone);
        values.put(COLUMN_ADDRESS,address);
        database.insert(TABLE_NAME,null,values);
        Log.i("hi","data inserted");
    }

    public void updateName(int id, String name){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_NAME,name);
        database.update(TABLE_NAME,values,COLUMN_ID+"=?",new String[]{String.valueOf(id)});
        Log.i("hi","name updated");
    }
    public void updatePhone(int id, String phone){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_PHONE,phone);
        database.update(TABLE_NAME,values,COLUMN_ID+"=?",new String[]{String.valueOf(id)});
        Log.i("hi","phone updated");
    }
    public void updateAddress(int id, String address){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_ADDRESS,address);
        database.update(TABLE_NAME,values,COLUMN_ID+"=?",new String[]{String.valueOf(id)});
        Log.i("hi","address updated");
    }
    public void deleteUser(int id){
        SQLiteDatabase database=getWritableDatabase();
        database.delete(TABLE_NAME,COLUMN_ID+"=?",new String[]{String.valueOf(id)});
        Log.i("hi","user deleted");

    }

}
