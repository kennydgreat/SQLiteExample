package com.example.paulbonenfant.sqliteexample.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLData;

/**
 * Created by kenny on 2017-12-04.
 */

public class StudentDb {

    private SQLiteDatabase database;
    private SQLiteOpenHelper openHelper;

    public static final String DB_NAME = "students.db" ;
    public static final int DB_VERSION = 1;

    public static final String STUDENT_TABLE = "Students";

    public static final String ID = "_id";
    public static final int ID_COLUMN = 0;

    public static  final String NAME = "name" ;
    public static  final int NAME_COLUMN = 1 ;

    public static  final String EMAIL = "email" ;
    public static  final int EMAIL_COLUMN = 1 ;

    public static  final String FULL_TIME = "fulltime" ;
    public static  final int FULL_TIME_COLUMN = 3 ;

    public static final String CREATE_STUDENTS_TABLE =
            "CREATE TABLE " + STUDENT_TABLE + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NAME + " TEXT, " +
                    EMAIL + " TEXT, " +
                    FULL_TIME + " INTEGER)";
    public StudentDb(Context context){
        openHelper = new DBHelper(context, DB_NAME, DB_VERSION);
    }
    private static class DBHelper extends SQLiteOpenHelper{
        public DBHelper(Context context, String name, int version){
            super(context, name, null, version);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_STUDENTS_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ STUDENT_TABLE);
            onCreate(db);
        }
    }
}
