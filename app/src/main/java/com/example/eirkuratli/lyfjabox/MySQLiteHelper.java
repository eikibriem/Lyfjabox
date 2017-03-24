package com.example.eirkuratli.lyfjabox;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.eirikuratli.lyfjabox.models.User;

import java.sql.Connection;

/**
 * Created by EiríkurAtli on 22.3.2017.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    private final static int DB_VERSION = 10;

    //Connection db = ConnectionClass.CONN();

    public MySQLiteHelper(Context context) {
        super(context, "HBV.db", null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table userdata (Id Integer primary key autoincrement, "+
                " username text, password text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        try{
            //System.out.println("UPGRADE DB oldVersion="+oldVersion+" - newVersion="+newVersion);
            recreateDb(sqLiteDatabase);
            if (oldVersion<10){
                String query = "create table userdata (Id Integer primary key autoincrement, "+
                        " username text, password text)";
                sqLiteDatabase.execSQL(query);
            }
        }
        catch (Exception e){e.printStackTrace();}
    }

    private void recreateDb(SQLiteDatabase sqLiteDatabase) {
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // super.onDowngrade(db, oldVersion, newVersion);
        System.out.println("DOWNGRADE DB oldVersion="+oldVersion+" - newVersion="+newVersion);
    }

    public User insertUser (User queryValues){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", queryValues.getUsername());
        values.put("password", queryValues.getPassword());
        queryValues.setId(database.insert("userdata", null, values));
        database.close();
        return queryValues;
    }

    public int updateUserPassword (User queryValues){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", queryValues.getUsername());
        values.put("password", queryValues.getPassword());
        queryValues.setId(database.insert("userdata", null, values));
        database.close();
        return database.update("userdata", values, "userId = ?", new String[] {String.valueOf(queryValues.getId())});
    }

    public User getUser (String email){
        String query = "Select * from userdata where email ='"+email+"'";
        User myUser = new User(0,email,"", 0, "", "", 0, 0, "", "", "", 0, 0, null);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do {
                myUser.setId(cursor.getLong(0));
                myUser.setPassword(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return myUser;
    }
}
