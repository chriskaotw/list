package com.kct.list;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import static com.kct.list.DBConstants.*;

public class MyDBHelper extends SQLiteOpenHelper{
	private final static String DATABASE_NAME  = "todo.db";
    private final static int DATABASE_VERSION = 1;
    
//    private static final String TABLE_NAME = "tasks";
//    private static final String TITLE = "title";
//    private static final String TAG = "tag";
//    private static final String DATE = "date";
//    private static final String COMMENT = "comment";
	

	public MyDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		final String INIT_TABLE = "CREATE TABLE IF NOT EXISTS" + TABLE_NAME + " ( " +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TITLE + " TEXT[30] NOT NULL, " +
                TAG + " TEXT[20] NOT NULL, " +
                DATE + " DATETIME NOT NULL,  " +
                COMMENT + " TEXT[100]); ";
        db.execSQL(INIT_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP_TABLE);
        onCreate(db);
	}

}
