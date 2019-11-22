package com.example.mycody.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.mycody.data.TopDB.*;

public class TopDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "clothList";
    private static final int DATABASE_VERSION = 1;

    public TopDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        final String SQL_CREATE_CLOTHLIST_TABLE = "CREATE TABLE " +
                CodyEntry.TABLE_NAME + " (" +
                CodyEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CodyEntry.COLUMN_TOP_NAME + "TEXT NOT NULL" + ");";

        sqLiteDatabase.execSQL(SQL_CREATE_CLOTHLIST_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CodyEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}