package com.example.eirkuratli.lyfjabox;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.eirikuratli.lyfjabox.models.User;
import com.example.eirkuratli.lyfjabox.ConnectionClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by EiríkurAtli on 22.3.2017.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    private final static int DB_VERSION = 10;

    private Connection database = null;
    String ConnURL = "jdbc:postgresql://localhost:5432/HBV";
    String username = "postgres";
    String password = "nufc";

    //String ConnURL = "jdbc:postgresql://ec2-174-129-29-118.compute-1.amazonaws.com:5432/d15m5640ih7gen"; //?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    //String username = "jhqeymjpexdoqy";
    //String password = "SXcbqtqdVInNzUCON9glAeahE_";



    public MySQLiteHelper(Context context) {
        super(context, "HBV.db", null,DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table userdata (Id Integer primary key autoincrement, "+
                " email text, password text)";
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

    public User getUser (String email) {
        String query = "Select * from userdata where email ='"+email+"'";
        User myUser = new User(0,email,"", 0, "", "", 0, 0, "", "", "", 0, 0, null);
        try {
            Class<?> aClass = Class.forName("org.postgresql.Driver");

            database = DriverManager.getConnection(ConnURL, username, password);
            Statement stmt = database.createStatement( );
            ResultSet rs = stmt.executeQuery( query );
            database.close();

            rs.next( );
            myUser.setId(rs.getLong("Id"));
            myUser.setFirstName(rs.getString("first_name"));
            myUser.setLastName(rs.getString("last_name"));
            myUser.setEmail(rs.getString("email"));
            myUser.setPassword(rs.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //Connection db = database; //this.getReadableDatabase();



        /*Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do {
                myUser.setId(cursor.getLong(0));
                myUser.setPassword(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        */
        return myUser;
    }
}
