package com.example.daytracker;

import java.util.Calendar;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class HomeFragment extends Fragment {
	
	
	
	SharedPreferences sharedPreferences;
	boolean firstLoginBool;
	
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		SharedPreferences sharedPreferences1 = PreferenceManager.getDefaultSharedPreferences(getActivity());
		Editor editor1 = sharedPreferences1.edit();
		editor1.clear();
		editor1.commit();
		
		
		//get shared preferences to determine whether it is the first entry
		sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
		firstLoginBool = sharedPreferences.getBoolean("FIRSTLOGIN", true);
		View rootView;
		
		if(!firstLoginBool)
		{
			rootView = inflater.inflate(R.layout.home_welcome, container, false);
		}
		else
		{
			rootView = inflater.inflate(R.layout.home_first_setup, container, false);
			Editor editor = sharedPreferences.edit();
			editor.putBoolean("FIRSTLOGIN", false);
			editor.commit();	
		}	
		
        return rootView;
        
    }
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    
	    if(!firstLoginBool)
		{
		    addListenerOnButton();
			   
		    TextView textCategory = (TextView) getActivity().findViewById(R.id.greeting);      
		    Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-BoldItalic.ttf");
	        textCategory.setTypeface(font);
		}
	    else
	    {
	    	addListenerOnButton();
			
	    }

	}

	public void addListenerOnButton() {
		 
		if(!firstLoginBool)
		{
		
			Button btnAddEntry = (Button) getActivity().findViewById(R.id.add_entry_button);
	 
			btnAddEntry.setOnClickListener(new OnClickListener() {
	 
				@Override
				public void onClick(View v) {
	 
					//Intent mainIntent = new Intent(getActivity(), RateMyDay1Fragment.class);
		            //startActivity(mainIntent);
					MainActivity.mDrawerLayout.openDrawer(Gravity.LEFT);
				}
	 
			});
		}
		else
		{
			Button btnLetsBegin = (Button) getActivity().findViewById(R.id.begin_button);

			btnLetsBegin.setOnClickListener(new OnClickListener() {
	 
				@Override
				public void onClick(View v) {
					
				}
	 
			});
	
			
		}
	}

}
