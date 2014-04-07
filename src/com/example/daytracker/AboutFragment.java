package com.example.daytracker;

import java.util.Calendar;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
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

public class AboutFragment extends Fragment {
	
	public AboutFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.home_welcome, container, false);
         
        return rootView;
        
    }
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    addListenerOnButton();
		   
	    TextView textCategory = (TextView) getActivity().findViewById(R.id.greeting);      
	    Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-BoldItalic.ttf");
        textCategory.setTypeface(font);

	}

	public void addListenerOnButton() {
		 
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

}
