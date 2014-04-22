package com.example.daytracker;

import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<String>{

	Context c;
	public ListAdapter(Context context, int textViewResourceId) {
	    super(context, textViewResourceId);
	    c = context;
	}

	public ListAdapter(Context context, int resource, List<String> items) {
	    super(context, resource, items);
	    c = context;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

	    View v = convertView;

	    if (v == null) {

	        LayoutInflater vi;
	        vi = LayoutInflater.from(getContext());
	        v = vi.inflate(R.layout.rmd2_dynamic_view, null);
	    }

	    String p = getItem(position);

	   if (p != null) {

	        TextView tv = (TextView) v.findViewById(R.id.textCategory);
	        RatingBar rb = (RatingBar) v.findViewById(R.id.ratingCategory);
	        tv.setText("Rate my "+ p +" today");
	        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
			rb.setNumStars(sharedPreferences.getInt("NUMOFSTARS", 5));
	   }
	   
	   //LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	   //View layout = inflater.inflate(R.layout.rmd2_dynamic_view, null);   
	   Button btn = (Button) v.findViewById(R.id.done_button2);
	   //btn.setOnClickListener(RateMyDay2Fragment.doneButtonHandler(c));
	   
	   return v;

	}
}
