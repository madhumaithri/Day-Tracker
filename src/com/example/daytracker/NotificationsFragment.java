package com.example.daytracker;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NotificationsFragment extends Fragment implements OnItemSelectedListener  {

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
	    Spinner nSpinner = (Spinner) getActivity().findViewById(R.id.notifications_spinner);
	    nSpinner.setOnItemSelectedListener(this);
		ArrayAdapter<CharSequence> nAdapter = ArrayAdapter.createFromResource(this.getActivity(),
		        R.array.notifications_numbers, android.R.layout.simple_spinner_item);
		nAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		nSpinner.setAdapter(nAdapter);

		Spinner rSpinner = (Spinner) getActivity().findViewById(R.id.ratingstars_spinner);
		ArrayAdapter<CharSequence> rAdapter = ArrayAdapter.createFromResource(this.getActivity(),
			    R.array.rmd_numOfStars, android.R.layout.simple_spinner_item);
		rAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		rSpinner.setAdapter(rAdapter);

	}
	
		

}
