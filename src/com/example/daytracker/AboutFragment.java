package com.example.daytracker;

import java.util.Calendar;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class AboutFragment extends Fragment {
	
	public AboutFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.about_layout, container, false);
         
        return rootView;
        
    }
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    TextView textCategoryqn1 = (TextView) getActivity().findViewById(R.id.about_qn1);      
	    Typeface fontBold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-BoldItalic.ttf");
        textCategoryqn1.setTypeface(fontBold);
        TextView textCategoryqn2 = (TextView) getActivity().findViewById(R.id.about_qn2);      
        textCategoryqn2.setTypeface(fontBold);
        TextView textCategoryqn3 = (TextView) getActivity().findViewById(R.id.about_qn3);   
        textCategoryqn3.setTypeface(fontBold);
        TextView textCategoryqn4 = (TextView) getActivity().findViewById(R.id.about_qn4);   
        textCategoryqn4.setTypeface(fontBold);
        
        
        TextView textCategoryans1 = (TextView) getActivity().findViewById(R.id.about_ans1);      
	    Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Italic.ttf");
        textCategoryans1.setTypeface(font);
        TextView textCategoryans2 = (TextView) getActivity().findViewById(R.id.about_ans2);      
        textCategoryans2.setTypeface(font);
        TextView textCategoryans3 = (TextView) getActivity().findViewById(R.id.about_ans3);   
        textCategoryans3.setTypeface(font);
        TextView textCategoryans4 = (TextView) getActivity().findViewById(R.id.about_ans4);   
        textCategoryans4.setTypeface(font);
        
        
        ImageView img = (ImageView) getActivity().findViewById(R.id.imageView1);
        img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.youtube.com/watch?v=J5VVOU4CDPk&rel=0"));
                getActivity().startActivity(intent);
                //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(" http://www.youtube.com/watch?v=J5VVOU4CDPk&rel=0")));
                
            }
        });

	}


}
