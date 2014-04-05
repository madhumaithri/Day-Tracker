package com.example.daytracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import com


import android.app.AlertDialog;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class ImageAdapterRMD1 extends PagerAdapter 
{
RateMyDay1Fragment context;
Context c;
int index = 0,i=0;

List<Integer> CriteriaImages = new ArrayList<Integer>();
List<String> CriteriaNames = new ArrayList<String>();
Random rand = new Random();
int random = rand.nextInt(2)+1;
private static Button btn;
private static RatingBar rating;

ImageAdapterRMD1(RateMyDay1Fragment rateMyDay1Fragment, List<String> imageNames)
{
	this.context=rateMyDay1Fragment;
	c = rateMyDay1Fragment.getActivity();
	for(String imageName : imageNames)
	{
	int identifier = context.getResources().getIdentifier(imageNames.get(i)+(random), "drawable",context.getActivity().getPackageName());
	
	if(identifier == 0)
	{
		Random randGeneral = new Random();
		int randomGeneral = randGeneral.nextInt(8)+1;
		identifier = context.getResources().getIdentifier("random"+(randomGeneral), "drawable",context.getActivity().getPackageName());
	}
	
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
public Object instantiateItem(ViewGroup container, final int position) {

LayoutInflater inflater = (LayoutInflater)container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
View layout = inflater.inflate(R.layout.rmd1_custom_imageslider_layout, null);   

final ImageView image=(ImageView) layout.findViewById(R.id.myimage);             
image.setImageResource(CriteriaImages.get(position));
image.getDrawable().setAlpha(90);

TextView text=(TextView) layout.findViewById(R.id.myImageViewText);             
text.setText("Rate my "+CriteriaNames.get(position)+" today");

rating = (RatingBar) layout.findViewById(R.id.ratingCategory);
rating.setId(position);
rating.setOnRatingBarChangeListener(new OnRatingBarChangeListener() 
{
	
	@Override
	public void onRatingChanged(RatingBar ratingBar, float rating,
			boolean fromUser) {
		// TODO Auto-generated method stub
		if(rating == 0)
		image.getDrawable().setAlpha(90);
		else if(rating == 1)
		image.getDrawable().setAlpha(120);
		else if(rating == 2)
		image.getDrawable().setAlpha(150);
		else if(rating == 3)
		image.getDrawable().setAlpha(180);
		else if(rating == 4)
		image.getDrawable().setAlpha(180);
		else if(rating == 5)
		image.getDrawable().setAlpha(255);
		
		RateMyDay1Fragment.addRatingValue(CriteriaNames.get(position),(int) rating);
	}
});
btn=(Button) layout.findViewById(R.id.done_button);
btn.setText("Swipe To Rate Next Activity");
btn.setEnabled(false);
btn.setOnClickListener(RateMyDay1Fragment.doneButtonHandler(c));

((ViewPager) container).addView(layout);
 return layout; 
}

public static void setEnabledToTrue()
{
	btn.setEnabled(true);
	btn.setText("Done");	
}

public static int getRating()
{
	 int r = (int) rating.getRating(); 
	 return r;
}
 
@Override
public void destroyItem(ViewGroup container, int position, Object object) {
((ViewPager) container).removeView((View) object);
}

}

