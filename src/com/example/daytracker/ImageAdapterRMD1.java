package com.example.daytracker;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
int index = 0,i=0;

List<Integer> CriteriaImages = new ArrayList<Integer>();
List<String> CriteriaNames = new ArrayList<String>();

ImageAdapterRMD1(RateMyDay1Fragment rateMyDay1Fragment, List<String> imageNames)
{
	this.context=rateMyDay1Fragment;
	for(String imageName : imageNames)
	{
	int identifier = context.getResources().getIdentifier(imageNames.get(i), "drawable",context.getActivity().getPackageName());
	CriteriaNames.add(imageNames.get(i));
	CriteriaImages.add(identifier);
	i++;
	}

}

@Override
public int getCount() {
return CriteriaImages.size();
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
image.setImageResource(CriteriaImages.get(position));

TextView text=(TextView) layout.findViewById(R.id.myImageViewText);             
text.setText("Rate my "+CriteriaNames.get(position)+" today");

RatingBar rating = (RatingBar) layout.findViewById(R.id.ratingCategory);

Button btn=(Button) layout.findViewById(R.id.done_button);
((ViewPager) container).addView(layout);
 return layout; 
}
 
@Override
public void destroyItem(ViewGroup container, int position, Object object) {
((ViewPager) container).removeView((View) object);
}
}

