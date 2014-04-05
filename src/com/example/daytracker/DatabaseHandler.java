package com.example.daytracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "activityData";
 
    // Contacts table name
    private static final String TABLE_CONTACTS = "activities";
 
    // Contacts Table Columns names
    private static final String KEY_DATE = "date";
    private static final String KEY_ACTIVITY = "activity";
    private static final String KEY_RATING = "rating";
    private static final String KEY_NOTES = "notes";
    
	public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_DATE + " DATETIME DEFAULT CURRENT_DATE," 
				+ KEY_ACTIVITY + " TEXT,"
                + KEY_RATING + " INTEGER,"
                + KEY_NOTES + " TEXT"
				+ ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
 
        // Create tables again
        onCreate(db);
	}
	
    // Adding new contact
	public void addContact(ActivityData newdata) {
		Log.d("mmp",newdata.getDate());
    SQLiteDatabase db = this.getWritableDatabase();
 
    ContentValues values = new ContentValues();
    values.put(KEY_DATE, newdata.getDate());
    values.put(KEY_ACTIVITY, newdata.getActivity());
    values.put(KEY_RATING, newdata.getRating());
    values.put(KEY_NOTES, newdata.getNotes());
    
    // Inserting Row
    db.insert(TABLE_CONTACTS, null, values);
    db.close(); // Closing database connection
}
	
	public ActivityData getContact(int id) {
	    SQLiteDatabase db = this.getReadableDatabase();
	 
	    Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_DATE,
	            KEY_ACTIVITY, KEY_RATING, KEY_NOTES }, KEY_DATE + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
	    if (cursor != null)
	        cursor.moveToFirst();
	 
	    ActivityData contact = new ActivityData(cursor.getString(0),
	            cursor.getString(1), Integer.parseInt(cursor.getString(2)),cursor.getString(3));
	    // return contact
	    return contact;
	}
	
	public List<ActivityData> getAllContacts() {
	    List<ActivityData> contactList = new ArrayList<ActivityData>();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
	 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	        	ActivityData contact = new ActivityData();
	            contact.setDate(cursor.getString(0));
	            contact.setActivity(cursor.getString(1));
	            contact.setRating(Integer.parseInt(cursor.getString(2)));
	            contact.setNotes(cursor.getString(3));
	            
	            // Adding contact to list
	            contactList.add(contact);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return contactList;
	}
	
	public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }
	
	 // Updating single contact
	public int updateContact(ActivityData contact) {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(KEY_DATE, contact.getDate());
	    values.put(KEY_ACTIVITY, contact.getActivity());
	    values.put(KEY_RATING, contact.getRating());
	    values.put(KEY_NOTES, contact.getNotes());
	 
	    // updating row
	    return db.update(TABLE_CONTACTS, values, KEY_DATE + " = ?",
	            new String[] { String.valueOf(contact.getDate()) });
	}
		
}
