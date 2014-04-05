package com.example.daytracker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RMD2DynamicView extends RelativeLayout{
	
	private TextView textCategory;
	private RatingBar ratingCategory;
	Context c;
	
	public RMD2DynamicView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		((Activity) getContext()).getLayoutInflater().inflate(R.layout.rmd2_dynamic_view, this);
        
		c=context;
		setupViewItems();
	}
	
	private void setupViewItems() {
        textCategory = (TextView) findViewById(R.id.textCategory);
        ratingCategory = (RatingBar) findViewById(R.id.ratingCategory);
        
        Typeface font = Typeface.createFromAsset(c.getAssets(), "fonts/Roboto-Italic.ttf");
        textCategory.setTypeface(font);
        
	
    }
	
	public void setTextContent(String text) {
        this.textCategory.setText(text);
        	
	}
	
	public void setRating(int rating) {
		this.ratingCategory.setRating(0);
	}
	

}
