package com.example.daytracker;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class RateMyDay2Fragment extends Fragment {
	Button buttonHelp;
	AlertDialog.Builder dialogBuilder;
	List<String> mydayCategoriesList = new ArrayList<String>(); 
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


}
