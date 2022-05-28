package com.example.mysweetrobotpdm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB extends SQLiteOpenHelper {

    public static final String DBNAME="PDMproiect.db";
    public DB( Context context) {
        super(context, "PDMproiect.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table utils(nume TEXT primary key, parola TEXT, nivel TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
    db.execSQL("drop table if exists utils");
    }

        public Boolean insertData(String user, String pass,String lvl){
        SQLiteDatabase db=this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put("nume", user);
            values.put("parola", pass);
            values.put("nivel", lvl);

            long result=db.insert("utils",null, values);
            if(result==-1) return false;
            else return true;

        }

    public Boolean updateNAME(String nume, String pass,String vechi, String lvl){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nume", nume);
        values.put("parola", pass);
        values.put("nivel", lvl);
        Cursor cursor=db.rawQuery("select * from utils where nume=? and parola=?" , new String[] {vechi,pass});
        if(cursor.getCount()>0){
        long result=db.update("utils",values,"nume=? and parola=?",new String[] {vechi,pass});
        if(result==-1) return false;
        else return true;} else return false;

    }

    public Boolean updatePASS(String passNEW, String pass, String nume, String lvl){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nume", nume);
        values.put("parola", passNEW);
        values.put("nivel", lvl);
        Cursor cursor=db.rawQuery("select * from utils where nume=? and parola=?" , new String[] {nume,pass});
        if(cursor.getCount()>0){
            long result=db.update("utils",values,"nume=? and parola=?",new String[] {nume,pass});
            if(result==-1) return false;
            else return true;} else return false;

    }

    public Boolean updateNIVEL(String nume, String pass, String lvlnou){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nume", nume);
        values.put("parola", pass);
        values.put("nivel", lvlnou);
        Cursor cursor=db.rawQuery("select * from utils where nume=? and parola=?" , new String[] {nume,pass});
        if(cursor.getCount()>0){
            long result=db.update("utils",values,"nume=? and parola=?",new String[] {nume,pass});
            if(result==-1) return false;
            else return true;} else return false;

    }

        public Boolean checkusername(String user){
            SQLiteDatabase db=this.getWritableDatabase();
            Cursor cursor=db.rawQuery("select * from utils where nume=?", new String[] {user});
            if(cursor.getCount()>0) return true;
            else return false;

        }

        public Boolean checkusernamepass(String user, String pass){
            SQLiteDatabase db=this.getWritableDatabase();
            Cursor cursor=db.rawQuery("select * from utils where nume=? and parola=?" , new String[] {user,pass});
            if(cursor.getCount()>0) return true;
            else return false;
        }

    public String findlvl(String user, String pass) throws SQLException {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select nivel from utils where nume=? and parola=?" , new String[] {user,pass});

        if (cursor.moveToFirst()){
            do {
                // Passing values
                String column1 = cursor.getString(0);
                return column1;

            } while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return "taci";

    }
}
