package com.example.user.austgroove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DiaryDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ToDoList.db";
    private static final String TABLE_NAME = "ToDolist";
    private static final String ID = "id";
    private static final String Subject = "Subject";
    private static final String Description = "Description";
    private static final int VERSION = 1;
    private Context context;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Subject+" VARCHAR(30), "+Description+" VARCHAR(512) );";
    private static final String SELECT_ALL = "SELECT * FROM" + TABLE_NAME;
    public DiaryDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{

            db.execSQL(CREATE_TABLE);
        }catch (Exception e){

        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{

            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(db);

        }catch (Exception e){
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_LONG).show();
        }

    }

    public long saveData(String sub,String des){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Subject,sub);
        contentValues.put(Description,des);

        long rowNumber = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowNumber;
    }

    public Cursor showAllData(){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return cursor;
    }

    public boolean updateData(String sub,String des){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Subject,sub);
        contentValues.put(Description,des);
        sqLiteDatabase.update(TABLE_NAME,contentValues,Subject+" = ? ",new String[] {Subject} );

        return true;
    }

    public int delete(String sub){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int value = sqLiteDatabase.delete(TABLE_NAME,Subject+" = ? ",new String[] {sub});

        return value;

    }
}
