package com.example.daytracker;

import java.util.Calendar;

import android.app.AlertDialog;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.widget.TimePicker;

public class NotificationsFragment extends Fragment implements OnItemSelectedListener  {

	private int hour;
	private int minute;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		return inflater.inflate(R.layout.notifications, container, false);
	}
	
	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		        Log.d("mmp",(String) parent.getItemAtPosition(pos));
    }

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    addListenerOnButton();
	   
	    TextView textCategory = (TextView) getActivity().findViewById(R.id.notifications_text);      
	    Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-BoldItalic.ttf");
        textCategory.setTypeface(font);
        
        TimePicker timePicker1 = (TimePicker) getActivity().findViewById(R.id.timePicker1);
        
		final Calendar c = Calendar.getInstance();
		hour = c.get(Calendar.HOUR_OF_DAY);
		minute = c.get(Calendar.MINUTE);
 
		
		// set current time into timepicker
		timePicker1.setCurrentHour(hour);
		timePicker1.setCurrentMinute(minute);
	    
	    /*
	    Spinner nSpinner = (Spinner) getActivity().findViewById(R.id.notifications_spinner);
	    nSpinner.setOnItemSelectedListener(this);
		ArrayAdapter<CharSequence> nAdapter = ArrayAdapter.createFromResource(this.getActivity(),
		        R.array.notifications_numbers, android.R.layout.simple_spinner_item);
		nAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		nSpinner.setAdapter(nAdapter);
		*/

        TextView textCategoryStar = (TextView) getActivity().findViewById(R.id.ratingstars_number);      
	    textCategoryStar.setTypeface(font);
        
		Spinner rSpinner = (Spinner) getActivity().findViewById(R.id.ratingstars_spinner);
		ArrayAdapter<CharSequence> rAdapter = ArrayAdapter.createFromResource(this.getActivity(),
			    R.array.rmd_numOfStars, android.R.layout.simple_spinner_item);
		rAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		rSpinner.setAdapter(rAdapter);

	}
	
	public void addListenerOnButton() {
		 
		Button btnChangeTime = (Button) getActivity().findViewById(R.id.apply_settings_button);
 
		btnChangeTime.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
 
				AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
	            builder1.setMessage("Settings Changed Successfully!");
	            builder1.setCancelable(true);
	            builder1.setPositiveButton("Ok",
	                    new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int id) {
	                    dialog.cancel();
	                }
	            });
	            
	            AlertDialog alert11 = builder1.create();
	            alert11.show();
			}
 
		});
 
	}

}
