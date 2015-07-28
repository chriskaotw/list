package com.kct.list;

import static android.provider.BaseColumns._ID;
import static com.kct.list.DBConstants.COMMENT;
import static com.kct.list.DBConstants.DATE;
import static com.kct.list.DBConstants.TABLE_NAME;
import static com.kct.list.DBConstants.TAG;
import static com.kct.list.DBConstants.TITLE;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TasksDAO {
	private SQLiteDatabase db;
	private MyDBHelper dbhelper;
	
	public TasksDAO(Context context) {
		// TODO Auto-generated constructor stub
		dbhelper = new MyDBHelper(context);
		db = dbhelper.getWritableDatabase();
	}
	
	public void close() {
		db.close();
	}
	
	public void createTasks(String title, String tag, String date, String comment){
		ContentValues contentValues = new ContentValues();
        contentValues.put(TITLE, title);
        contentValues.put(TAG, tag);
        contentValues.put(DATE, date );
//        contentValues.put(DATE, df.format(new Date(System.currentTimeMillis())) );
        contentValues.put(COMMENT, comment);

        db.insert(TABLE_NAME, null, contentValues);
//        db.insertOrThrow(TABLE_NAME, null, contentValues);
	}
	
	public void deleteTask(int id){
        db.delete(TABLE_NAME, _ID + " = " + id, null);
        
    }
	
	public void updateTask(int id, String title, String tag, String date, String comment){
		ContentValues contentValues = new ContentValues();
        contentValues.put(TITLE, title);
        contentValues.put(TAG, tag);
        contentValues.put(DATE, date);
//        contentValues.put(DATE, df.format(new Date(System.currentTimeMillis())) );
        contentValues.put(COMMENT, comment);
		db.update(TABLE_NAME, contentValues, _ID + " = " + id , null);
	}
	
	public List<Task> getTasks(){
		List<Task> taskList = new ArrayList<Task>();
		String[] columns = new String[]{_ID, TITLE, TAG, DATE, COMMENT};
		
		Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);
        cursor.moveToFirst();
        
        while(!cursor.isAfterLast()){
        	Task task = new Task();
        	task.setId(cursor.getInt(0));
        	task.setTitle(cursor.getString(1));
        	task.setDate(cursor.getString(3));

        	taskList.add(task);

            cursor.moveToNext();
        }
        return taskList;
	}
	
	public Task getTask(int position){
		Task task = new Task();
		String[] columns = new String[]{_ID, TITLE, TAG, DATE, COMMENT};
		
		Cursor cursor = db.query(TABLE_NAME, columns, _ID+" = "+position, null, null, null, null);
        cursor.moveToFirst();
        
    	task.setId(cursor.getInt(0));
    	task.setTitle(cursor.getString(1));
    	task.setTag(cursor.getString(2));
    	task.setDate(cursor.getString(3));
    	task.setComment(cursor.getString(4));
		return task;
	}
}
