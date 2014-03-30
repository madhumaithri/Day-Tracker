package com.example.daytracker;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NotificationsFragment extends Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		//getActivity().setContentView(inflater.inflate(R.layout.notifications, container, false));
		
		return inflater.inflate(R.layout.notifications, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    Spinner spinner = (Spinner) getActivity().findViewById(R.id.notifications_spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
		        R.array.notifications_numbers, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
	}
	
	

}
