package com.example.daytracker;

import java.io.File;
import java.lang.reflect.Field;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ImageAdapterRMD1 extends PagerAdapter
{
RateMyDay1Fragment context;
int index = 0;

int[] CriteriaImages = new int[]
{
	R.drawable.two,
	R.drawable.two,
};

ImageAdapterRMD1(RateMyDay1Fragment rateMyDay1Fragment)
{
	this.context=rateMyDay1Fragment;
}

@Override
public int getCount() {
return CriteriaImages.length;
}
 
@Override
public boolean isViewFromObject(View view, Object object) {
return view == ((View) object);
}
 
@Override
public Object instantiateItem(ViewGroup container, int position) {

LayoutInflater inflater = (LayoutInflater)container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
View layout = inflater.inflate(R.layout.rmd1_custom_imageslider_layout, null);   

ImageView image=(ImageView) layout.findViewById(R.id.myimage);             
image.setImageResource(CriteriaImages[position]);

TextView text=(TextView) layout.findViewById(R.id.myImageViewText);             

RatingBar rating = (RatingBar) layout.findViewById(R.id.ratingCategory);

Button btn=(Button) layout.findViewById(R.id.done_button);
((ViewPager) container).addView(layout);
 return layout; 
/*
ImageView imageView = new ImageView(context.getActivity());
int padding = context.getResources().getDimensionPixelSize(R.dimen.padding_medium);
imageView.setPadding(padding, padding, padding, padding);
imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
imageView.setImageResource(CriteriaImages[position]);
((ViewPager) container).addView(imageView, 0);
return imageView;
*/
}
 
@Override
public void destroyItem(ViewGroup container, int position, Object object) {
((ViewPager) container).removeView((View) object);
}
}

