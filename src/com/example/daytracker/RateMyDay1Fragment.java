package com.example.daytracker;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RateMyDay1Fragment extends Fragment {
	
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

	    ViewPager viewPager = (ViewPager) getView().findViewById(R.id.view_pager);
		ImageAdapterRMD1 adapter = new ImageAdapterRMD1(this);
		viewPager.setAdapter(adapter);
	}

}

