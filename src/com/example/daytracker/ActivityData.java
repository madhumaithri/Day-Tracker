package com.example.daytracker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ActivityData {

	String _date;
	String _activity;
	Integer _rating;
	String _notes;
	
	 public ActivityData(){
         
	 }
	 
	 // constructor
	 public ActivityData(String date, String activity, Integer rating, String notes){
	     this._date = date;
	     this._activity = activity;
	     this._rating = rating;
	     this._notes = notes;
	 }
	
	 public String getDate(){
		 String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
	     return timeStamp;
	 }
	     
	 // setting date
	 public void setDate(String date){
	     this._date = date;
	 }
	 
	 public String getActivity(){
	     return this._activity;
	 }
	     
	 // setting activity
	 public void setActivity(String activity){
	     this._activity = activity;
	 }
	 
	 public int getRating(){
	     return this._rating;
	 }
	     
	 // setting rating
	 public void setRating(int rating){
	     this._rating = rating;
	 }
	 
	 public String getNotes(){
	     return this._notes;
	 }
	     
	 // setting notes
	 public void setNotes(String notes){
	     this._notes = notes;
	 }
	 
	 
	 
	 
}
