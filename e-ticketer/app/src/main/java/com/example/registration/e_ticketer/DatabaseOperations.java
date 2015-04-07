package com.example.registration.e_ticketer;
/**
 * Created by 3542 on 01/04/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version = 1;

    public String CREATE_QUERY = "CREATE TABLE " + TableData.TableInfo.TABLE_NAME + "(" + TableData.TableInfo.USER_NAME + "TEXT,"+ TableData.TableInfo.USER_PASS+"TEXT ); ";

    public DatabaseOperations(Context context){
        //  super(context,name,factory,version);
        super(context, TableData.TableInfo.DATABASE_NAME,null,database_version);
        Log.d("Database operations" , "Database created");
    }
    public void onCreate(SQLiteDatabase sdb){
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations" , "Table created");
    }
    public void onUpgrade(SQLiteDatabase arg0 , int arg1 ,int arg2){

    }

    public void putInformation(DatabaseOperations dop ,String name ,String pass){
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.USER_NAME ,name);
        cv.put(TableData.TableInfo.USER_PASS , pass);
        long k = SQ.insert(TableData.TableInfo.TABLE_NAME,null,cv);
        Log.d("Database operations" , "One row inserted");
    }
}

