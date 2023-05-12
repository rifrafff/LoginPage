package com.rose.loginpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {


    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1="create table users(name text,email text,username text,password text)";
        sqLiteDatabase.execSQL(qry1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void Register(String name,String email,String username,String password){
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("email",email);
        cv.put("username",username);
        cv.put("password",password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }

    public int Login(String username,String password){
        int result=0;
        SQLiteDatabase db =getReadableDatabase();
        Cursor c=db.rawQuery("select * from users",null);
        int usernamee=c.getColumnIndex("username");
        int passwordd=c.getColumnIndex("password");
        while(c.moveToNext()){
            String us,pass;
            us=c.getString(usernamee);
            pass=c.getString(passwordd);
            if(username.equals(us) && password.equals(pass)){
                result = 1;
                break;
            }
        }
        c.close();
        db.close();
        return result;
    }

    public void Profile(String username){

    }
}
