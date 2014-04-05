package com.example.daytracker;

import android.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.androidplot.xy.*;

import java.util.Arrays;


public class GraphsFragment extends Fragment {

	private XYPlot plot;
	 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        
        return inflater.inflate(R.layout.graphs1_layout, container, false);
    }
    
    @Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	
	 // initialize our XYPlot reference:
        plot = (XYPlot) getActivity().findViewById(R.id.mySimpleXYPlot);
    	
        // Create a couple arrays of y-values to plot:
        Number[] series1Numbers = {1, 5, 1, 0, 3, 4, 2};
        Number[] series2Numbers = {4, 6, 3, 8, 2, 10};
 
        // Turn the above arrays into XYSeries':
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(series1Numbers),          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Happiness");                             // Set the display title of the series
 
        // same as above
        XYSeries series2 = new SimpleXYSeries(Arrays.asList(series2Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series2");
 
        // Create a formatter to use for drawing a series using LineAndPointRenderer
        // and configure it from xml:
        LineAndPointFormatter series1Format = new LineAndPointFormatter();
        series1Format.setPointLabelFormatter(new PointLabelFormatter());
        series1Format.configure(getActivity().getApplicationContext(),
                R.xml.line_point_formatter_with_plf1);
 
        // add a new series' to the xyplot:
        plot.addSeries(series1, series1Format);
 
        // same as above:
        LineAndPointFormatter series2Format = new LineAndPointFormatter();
        series2Format.setPointLabelFormatter(new PointLabelFormatter());
        series2Format.configure(getActivity().getApplicationContext(),
                R.xml.line_point_formatter_with_plf2);
        //plot.addSeries(series2, series2Format);
 
        // reduce the number of range labels
        plot.setTicksPerRangeLabel(3);
        plot.getGraphWidget().setDomainLabelOrientation(-45);
	

     }
}
