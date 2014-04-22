package com.example.daytracker;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

		TextView textCategoryUsername = (TextView) getActivity().findViewById(R.id.UsernameN);      
	    textCategoryUsername.setTypeface(font);
	    //textCategoryUsername.setText("Edit Username");
	    
	    TextView textCategoryEmail = (TextView) getActivity().findViewById(R.id.emailN);      
	    textCategoryEmail.setTypeface(font);
	    //textCategoryUsername.setText("Edit Email Id");
	    
	    EditText etUsername = (EditText) getActivity().findViewById(R.id.setup_user_nameN);      
	    etUsername.setText(sharedPreferences.getString("USERNAME", "Jane"));
	    
	    EditText etEmail = (EditText) getActivity().findViewById(R.id.setup_user_emailN);      
	    etEmail.setText(sharedPreferences.getString("EMAIL", "madhumaithri@gmail.com"));
	    
	    
	}
	
	public void addListenerOnButton() {
		 
		Button btnChangeTime = (Button) getActivity().findViewById(R.id.apply_settings_button);
 
		btnChangeTime.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
 
				Intent intent = new Intent(getActivity(), getClass());
				PendingIntent  pendingIntent = PendingIntent.getActivity(getActivity().getApplicationContext(), 0, intent, 0);

				// build notification
				// the addAction re-use the same intent to keep the example short
				Notification n  = new Notification.Builder(getActivity())
				        .setContentTitle("New mail from " + "test@gmail.com")
				        .setContentText("Subject")
				        .setSmallIcon(R.drawable.ic_launcher)
				        .setContentIntent(pendingIntent)
				        .setAutoCancel(true)
				        .build();
				AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(getActivity().getApplicationContext().ALARM_SERVICE);
			    pendingIntent = PendingIntent.getService(getActivity(), 0, intent, 0);

			       Calendar calendar = Calendar.getInstance();
			       calendar.set(Calendar.HOUR_OF_DAY, hour);
			       calendar.set(Calendar.MINUTE, minute);
			       calendar.set(Calendar.SECOND, 00);
    
				NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(getActivity().getApplicationContext().NOTIFICATION_SERVICE); 
				
				
				
				
				SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
				Spinner rSpinner = (Spinner) getActivity().findViewById(R.id.ratingstars_spinner);
				String texts = rSpinner.getSelectedItem().toString();
				Integer myNum = Integer.parseInt(texts);
				Editor editor = sharedPreferences .edit();
				editor.putInt("NUMOFSTARS", myNum);	
				
				EditText etUsername = (EditText) getActivity().findViewById(R.id.setup_user_nameN);      
			    Editable name = etUsername.getText();
			    editor.putString("USERNAME",name.toString());
				
			    EditText etEmail = (EditText) getActivity().findViewById(R.id.setup_user_emailN);      
			    Editable mail = etEmail.getText();
			    editor.putString("EMAIL",mail.toString());
				
			    
			    editor.commit();
				
				
			      
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
