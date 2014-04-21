package com.example.daytracker;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class HomeFragment extends Fragment {
	
	
	
	SharedPreferences sharedPreferences;
	boolean firstLoginBool,entryDone;
	View rootView;
	
	public HomeFragment(){}
	
	@SuppressWarnings("deprecation")
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		/*
		SharedPreferences sharedPreferences1 = PreferenceManager.getDefaultSharedPreferences(getActivity());
		Editor editor1 = sharedPreferences1.edit();
		editor1.clear();
		editor1.commit();
		*/
		
		//get shared preferences to determine whether it is the first entry
		sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
		firstLoginBool = sharedPreferences.getBoolean("FIRSTLOGIN", true);
		entryDone = sharedPreferences.getBoolean("ENTRYDONE", false);
		
		Date today = new Date();
		if(entryDone==true && sharedPreferences.getInt("PREVIOUSENTRYDATE", 0)!=today.getDate())
		{
			SharedPreferences sharedPreferences11 = PreferenceManager.getDefaultSharedPreferences(getActivity());
			Editor editor11 = sharedPreferences11 .edit();
			editor11.putBoolean("ENTRYDONE", false);
		}	
		
		if(!firstLoginBool)
		{
			rootView = inflater.inflate(R.layout.home_welcome, container, false);
		}
		else
		{
			rootView = inflater.inflate(R.layout.home_first_setup, container, false);
			
		}	
		
        return rootView;
        
    }
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    
	    if(!firstLoginBool)
		{
		    addListenerOnButton();
		    
		    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
		    String name = sharedPreferences.getString("USERNAME","Madhu");

		    TextView textCategory = (TextView) getActivity().findViewById(R.id.greeting);      
		    textCategory.setText("Hi "+name+",");
		    Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-BoldItalic.ttf");
	        textCategory.setTypeface(font);
	        
	        if(entryDone)
	        {
		        ImageView image = (ImageView) getActivity().findViewById(R.id.imageView1);
		        Resources res = getResources();
		        int resourceId = res.getIdentifier("no_entry_left", "drawable", getActivity().getPackageName() );
		        image.setImageResource( resourceId );
		        
		        Button add_entry_btn = (Button) getActivity().findViewById(R.id.add_entry_button);
		        add_entry_btn.setEnabled(false);
		        
		        int ht = sharedPreferences.getInt("HAPPINESSTODAY", 0);
		        add_entry_btn.setText("Your happiness today : "+ht+"/5");
		        //add_entry_btn.setBackgroundResource(R.layout.blue_button_background);
	        }
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
				
					
					EditText usernameEditText = (EditText) getActivity().findViewById(R.id.setup_user_name);
					EditText emailEditText = (EditText) getActivity().findViewById(R.id.setup_user_email);
					String sUsername = usernameEditText.getText().toString();
					String sEmail = emailEditText.getText().toString();
					
					final Pattern validEmailChecker = Pattern.compile(
					        "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$"
					);

					if (sUsername.matches("")) {
					    Toast.makeText(getActivity(), "You did not enter a username", Toast.LENGTH_SHORT).show();		 
					}
					else if (sEmail.matches("")) {
					    Toast.makeText(getActivity(), "You did not enter your email id ", Toast.LENGTH_SHORT).show();
					}
					else if(!validEmailChecker.matcher(sEmail).matches()){
						Toast.makeText(getActivity(), "Please enter a valid email id ", Toast.LENGTH_SHORT).show();
					}
					else{
						Editor editor = sharedPreferences.edit();
						editor.putBoolean("FIRSTLOGIN", false);
						editor.commit();
					 	
					 	editor.putString("USERNAME",sUsername);
					 	editor.commit();
					 	
					 	editor.putString("EMAIL", sEmail);
					 	editor.commit();
					 	
					 	Fragment fragment = new HomeFragment();
					 	FragmentManager fragmentManager = getFragmentManager();
						fragmentManager.beginTransaction()
								.replace(R.id.frame_container, fragment).commit();
						
					}
				}
			});
	
			
		}
	}

}
