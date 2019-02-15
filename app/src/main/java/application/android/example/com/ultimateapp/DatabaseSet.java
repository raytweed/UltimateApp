package application.android.example.com.ultimateapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseSet extends SQLiteOpenHelper {
    private static String table_name="Mydatabase";
    private static String database="DATABASE.db";
    private static String id="id";
    private static String name="name";
    private static String contact="contact";
    private static String email="email";
    private static String password="password";
    public DatabaseSet(Context context) {
        super(context, database, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Table="CREATE TABLE "+table_name+"("+id+" Text,"+name+" Text,"+contact+" Text,"+email+" Text,"+password+" Text)";
        db.execSQL(Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long insertData(String mId,String mName,String mContact,String mEmail,String mPassword){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(id,mId);
        values.put(name,mName);
        values.put(contact,mContact);
        values.put(email,mEmail);
        values.put(password,mPassword);
        long val=db.insert(table_name,null,values);
        db.close();
        return val;
    }
    public boolean checkidandpassword(String Xid,String Xpass){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT id,password FROM "+table_name+" WHERE id='"+Xid+"' AND password='"+Xpass+"'",null);
        if(cursor.getCount()<=0){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor admin(String mId){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+table_name+" WHERE id='"+mId+"'",null);
        return cursor;
    }
    public boolean check(){
        SQLiteDatabase db=this.getReadableDatabase();
        return true;
    }
    public long insertcontact(String mId,String mName,String mContact,String mEmail){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(id,mId);
        values.put(name,mName);
        values.put(contact,mContact);
        values.put(email,mEmail);
        long insertcon=db.insert(table_name,null,values);
        db.close();
        return insertcon;
    }
    public Cursor showcontact(String mId){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+table_name+" WHERE id='"+mId+"'",null);
        return cursor;
    }
}
