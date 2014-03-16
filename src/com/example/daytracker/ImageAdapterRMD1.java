package com.example.daytracker;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapterRMD1 extends PagerAdapter
{
RateMyDay1Fragment context;
private int[] CriteriaImages = new int[] {
R.drawable.one,
R.drawable.two,
R.drawable.three
};
ImageAdapterRMD1(RateMyDay1Fragment rateMyDay1Fragment){
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

ImageView im=(ImageView) layout.findViewById(R.id.myimage);             
im.setImageResource(CriteriaImages[position]);

TextView txt=(TextView) layout.findViewById(R.id.image_text);
((ViewPager) container).addView(layout, 0);
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

