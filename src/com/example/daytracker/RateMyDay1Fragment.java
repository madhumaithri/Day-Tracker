package com.example.daytracker;

import java.lang.reflect.Field;
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
	private List<String> imageNamesList;
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
		
		for( int i=0 ; i<mydayCategoriesList.size() ; i++)
		{
			boolean categoryPreference = sharedPreferences.getBoolean(mydayCategoriesList.get(i), true);
			if(categoryPreference)
			{
				
			}
		}
		
	    ViewPager viewPager = (ViewPager) getView().findViewById(R.id.view_pager);
		ImageAdapterRMD1 adapter = new ImageAdapterRMD1(this);
		viewPager.setAdapter(adapter);

		
	 }

}

