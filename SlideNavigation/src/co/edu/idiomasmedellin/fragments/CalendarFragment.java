package co.edu.idiomasmedellin.fragments;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.cipolat.slidenavigation.R;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;
import android.widget.CalendarView.OnDateChangeListener;

 
public class CalendarFragment extends Fragment {	
	CalendarFragment (){
		
	}
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);	       
	    }
    
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {	  
	       
		 View rootView = inflater.inflate(R.layout.calendar_top_layout, container, false);	  	    
	     View btnB1 = rootView.findViewById(R.id.piker);
	     btnB1.setOnClickListener(new View.OnClickListener() {

	            @Override
	            public void onClick(View arg0) {
	                DialogFragment newFragment = new DatePickerFragment();
	                newFragment.show(getFragmentManager(), "DatePicker");
	            }
	        });       
	   
	        return rootView;
	    }
    
}
