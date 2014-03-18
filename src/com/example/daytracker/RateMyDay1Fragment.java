package com.example.daytracker;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

public class RateMyDay1Fragment extends Fragment {
	
	private String mydayCategoriesString;
	private List<String> mydayCategoriesList = new ArrayList<String>();
	private List<String> imageNamesList = new ArrayList<String>();
	Class resources = R.drawable.class;
	Field[] fields  = resources.getFields();
	String imageName = "";

	public String getImageNamesList(Field[] fields)
	{	
		imageName ="";
		for( Field field : fields )
		{
		    imageName += field.getName()+",";
		}
		return imageName;
	}

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
		//contains names of all images in drawable separated by commas
		imageName = getImageNamesList(fields);
		imageNamesList = Arrays.asList(imageName.split(","));

		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
		mydayCategoriesString = sharedPreferences.getString("mydayCategories","hardwork,socializing,sleep,sports,hobbies");
		mydayCategoriesList = Arrays.asList(mydayCategoriesString.split(","));
		
		ViewPager viewPager = (ViewPager) getView().findViewById(R.id.view_pager);
		List<String> enabledCategories = new ArrayList<String>();
		 
		for( int i=0 ; i<mydayCategoriesList.size() ; i++)
		{	
			boolean categoryPreference = sharedPreferences.getBoolean(mydayCategoriesList.get(i), true);
			if(categoryPreference)
			{
				enabledCategories.add(mydayCategoriesList.get(i));
			}		
		}
		ImageAdapterRMD1 adapter = new ImageAdapterRMD1(this,enabledCategories);
		viewPager.setAdapter(adapter);
				
	 }
	
	public boolean onCreateOptionsMenu() {
		// Inflate the menu; this adds items to the action bar if it is present.
		getActivity().getMenuInflater().inflate(R.menu.rmd1_actionbar, null);
		return true;
	}
	

}

