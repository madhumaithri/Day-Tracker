package com.example.daytracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class RateMyDay2Fragment extends Fragment {
	Button buttonHelp;
	AlertDialog.Builder dialogBuilder;
	List<String> mydayCategoriesList = new ArrayList<String>(); 
	private List<String> mydayCategoriesTrueList = new ArrayList<String>();
	private static List<String> enabledCategories = new ArrayList<String>();
	String mydayCategoriesString = "hardwork,socializing,sleep,sports,hobbies";
	RatingBar hardworkInput, socializingInput, sleepInput, sportsInput, hobbiesInput;
	Integer hardwork,socializing,sleep,sports,hobbies,i=0;
	String mydayNotes="",newTrackmoreCategory="";
	LinearLayout ll;
	LinearLayout.LayoutParams params;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
		return inflater.inflate(R.layout.rmd2_layout, container, false);
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater mi) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.getActivity().getMenuInflater().inflate(R.menu.rmd1_actionbar, menu);
		return;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		
		case R.id.trackmore:
			
			LayoutInflater inflater_trackmore = LayoutInflater.from(super.getActivity());
			final View layout_trackmore = inflater_trackmore.inflate(R.layout.rmd1_trackmore, null);
			
			final LinearLayout ll_trackmore = (LinearLayout) layout_trackmore.findViewById(R.id.trackmore_suggestions_ll);
			final ListView lv_trackmore = (ListView) layout_trackmore.findViewById(R.id.suggestionCategories);
			mydayCategoriesTrueList.clear();
			for(String s : mydayCategoriesList) 
			{
				if(!getPreferencesBool(s.trim())) {mydayCategoriesTrueList.add(s);}
			}
			final ArrayAdapter<String> adapter_trackmore = new ArrayAdapter<String>(super.getActivity(),android.R.layout.simple_list_item_1,mydayCategoriesTrueList);
			lv_trackmore.setAdapter(adapter_trackmore);
			lv_trackmore.setChoiceMode(lv_trackmore.CHOICE_MODE_MULTIPLE);
			lv_trackmore.setItemsCanFocus(true);
			
			
			dialogBuilder = new AlertDialog.Builder(super.getActivity());
			dialogBuilder.setView(layout_trackmore)
			.setTitle(R.string.trackmore_title)
			.setCancelable(false)
			.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which)
					{			
					EditText newTrackmoreCategoryInput;
					newTrackmoreCategoryInput = (EditText) layout_trackmore.findViewById(R.id.trackmoreInput);
					String newTrackmoreCategory = newTrackmoreCategoryInput.getText().toString();
					if (!newTrackmoreCategory.isEmpty()) {
						savePreferences(newTrackmoreCategory);
					}		
				}
			})
			.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			})
			.setIcon(R.drawable.ic_action_new);
			AlertDialog dialog_trackmore = dialogBuilder.create();
			dialog_trackmore.show();
			return true; 
			

		case R.id.trackless:
			LayoutInflater inflater_trackless = LayoutInflater.from(super.getActivity());
			final View layout_trackless = inflater_trackless.inflate(R.layout.rmd1_trackless, null);
			final LinearLayout ll = (LinearLayout) layout_trackless.findViewById(R.id.trackless_ll);
			final ListView lv = (ListView) layout_trackless.findViewById(R.id.deleteCategories);
			mydayCategoriesTrueList.clear();
			for(String s : mydayCategoriesList) 
			{
				if(getPreferencesBool(s.trim())) {mydayCategoriesTrueList.add(s);}
			}
			final ArrayAdapter<String> adapter = new ArrayAdapter<String>(super.getActivity(),android.R.layout.simple_list_item_multiple_choice,mydayCategoriesTrueList);
			lv.setAdapter(adapter);
			lv.setChoiceMode(lv.CHOICE_MODE_MULTIPLE);
			lv.setItemsCanFocus(true);
			
			
			dialogBuilder = new AlertDialog.Builder(super.getActivity());
			dialogBuilder.setView(layout_trackless)
			.setTitle(R.string.trackless_title)
			.setCancelable(false)
			.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which)
				{	
					SparseBooleanArray sparseBooleanArray = lv.getCheckedItemPositions();
					for(int i = 0; i < lv.getCount(); i++)
					{
					     if(sparseBooleanArray.get(i) == true) 
					     {
					    	 savePreferencesBoolReset(lv.getItemAtPosition(i).toString());
					     }
					}
				}
			})
			.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			})
			.setIcon(R.drawable.ic_action_new);
			AlertDialog dialog_trackless = dialogBuilder.create();
			dialog_trackless.show();
			return true; 

		case R.id.create_note:
			LayoutInflater inflater = LayoutInflater.from(super.getActivity());
			final View layout = inflater.inflate(R.layout.notes,null);
			EditText notesInput;
			if(!this.mydayNotes.isEmpty())
			{
				notesInput = (EditText)layout.findViewById(R.id.mydayNoteInput);
				notesInput.setText(mydayNotes);	
			}			
			
			notesInput = (EditText) layout.findViewById(R.id.mydayNoteInput);
			this.mydayNotes = notesInput.getText().toString();
			dialogBuilder = new AlertDialog.Builder(super.getActivity());
			dialogBuilder.setView(layout)
			.setTitle(R.string.notes_title)
			.setCancelable(false)
			.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					//saveMyMoodNotes(layout);
				}
			})
			.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			});
			AlertDialog dialog = dialogBuilder.create();
			dialog.show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    loadSavedPreferences();
	}
	
	private void loadSavedPreferences()
	{
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
		mydayCategoriesString = sharedPreferences.getString("mydayCategories"," hardwork , socializing , sleep , sports , hobbies , reading , studying , productivity , eating");
		mydayCategoriesList = Arrays.asList(mydayCategoriesString.split(","));
		
		 
		for( int i=0 ; i<mydayCategoriesList.size() ; i++)
		{	
			String s = mydayCategoriesList.get(i).trim().toLowerCase();
			boolean categoryPreference;
			
			if((!s.equals("reading"))&&(!s.equals("studying"))&&(!s.equals("productivity"))&&(!s.equals("eating")))
				categoryPreference = sharedPreferences.getBoolean(mydayCategoriesList.get(i).trim(), true);
			else
				categoryPreference = sharedPreferences.getBoolean(mydayCategoriesList.get(i).trim(), false);
			
			if(categoryPreference)
			{
				enabledCategories.add(mydayCategoriesList.get(i).trim());
			}		
		}
	 }
	

	
	private void savePreferences(String newCategoryToAdd)
	{
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
		Editor editor = sharedPreferences.edit();
		mydayCategoriesString = sharedPreferences.getString("mydayCategories"," hardwork , socializing , sleep , sports , hobbies , reading , studying , productivity , eating");
		newCategoryToAdd = newCategoryToAdd.toLowerCase();
		if(!mydayCategoriesString.contains(newCategoryToAdd))
		{
			editor.putString("mydayCategories", mydayCategoriesString+" , "+newCategoryToAdd);
			editor.putBoolean(newCategoryToAdd, true);
		}
		else if(mydayCategoriesString.contains(newCategoryToAdd) )
		{
			if(!getPreferencesBool(newCategoryToAdd.trim()))
			{
			savePreferencesBoolResetToTrue(newCategoryToAdd);
			}
		}
		loadSavedPreferences();
		editor.commit();
	}
	
	
	private void savePreferencesBoolReset(String category)
	{	
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
		Editor editor = sharedPreferences.edit();
		editor.putBoolean(category.trim(), false);
		editor.commit();
		loadSavedPreferences();
	}
	
	private void savePreferencesBoolResetToTrue(String category)
	{
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
		Editor editor = sharedPreferences.edit();
		editor.putBoolean(category.trim(), true);
		editor.commit();
		loadSavedPreferences();
	}
	
	private boolean getPreferencesBool(String s)
	{
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
		boolean categoryPreference;// = sharedPreferences.getBoolean(category.trim(), false);
		
		if((!s.equals("reading"))&&(!s.equals("studying"))&&(!s.equals("productivity"))&&(!s.equals("eating")))
			categoryPreference = sharedPreferences.getBoolean(s.trim(), true);
		else
			categoryPreference = sharedPreferences.getBoolean(s.trim(), false);
		
		return categoryPreference;
	}

	
	public boolean onCreateOptionsMenu() {
		// Inflate the menu; this adds items to the action bar if it is present.
		getActivity().getMenuInflater().inflate(R.menu.rmd1_actionbar, null);
		return true;
	}


}
