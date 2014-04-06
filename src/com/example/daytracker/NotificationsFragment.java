package com.example.daytracker;

import java.util.Calendar;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.TimePickerDialog;
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
	
		

}
