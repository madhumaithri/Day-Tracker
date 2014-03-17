package com.example.daytracker;

import java.util.Arrays;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

public class RateMyDay1Fragment extends Fragment {
	
	private String mydayCategoriesString;
	private List<String> mydayCategoriesList;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		return inflater.inflate(R.layout.rmd1_layout, container, false);
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
		loadSavedPreferences();
	}
	
	private void loadSavedPreferences()
	{
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
		mydayCategoriesString = sharedPreferences.getString("mydayCategories","hardwork,socializing,sleep,sports,hobbies");
		mydayCategoriesList = Arrays.asList(mydayCategoriesString.split(","));
		
	    ViewPager viewPager = (ViewPager) getView().findViewById(R.id.view_pager);
		ImageAdapterRMD1 adapter = new ImageAdapterRMD1(this);
		viewPager.setAdapter(adapter);

		
	 	}

}

