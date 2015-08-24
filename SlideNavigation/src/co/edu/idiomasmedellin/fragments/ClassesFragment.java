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
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;
import android.widget.CalendarView.OnDateChangeListener;

 
public class ClassesFragment extends Fragment {	
  	ClassesFragment (){		
	}
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);	       
	        
	    }
    
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {	  
	       
		 View rootView = inflater.inflate(R.layout.calendar_top_layout, container, false);	  	    
	     View btnB1 = rootView.findViewById(R.id.piker);
	     	     
	     View btnclase1 = rootView.findViewById(R.id.btnclase1);
	     View btnclase2 = rootView.findViewById(R.id.btnclase2);
	     View btnclase3 = rootView.findViewById(R.id.btnclase3);  
	     View btnclase4 = rootView.findViewById(R.id.btnclase4);
	     View btnclase5 = rootView.findViewById(R.id.btnclase5);
	     View btnclase6 = rootView.findViewById(R.id.btnclase6);  
	     View btnclase7 = rootView.findViewById(R.id.btnclase7);
	     View btnclase8 = rootView.findViewById(R.id.btnclase8);
	     View btnclase9 = rootView.findViewById(R.id.btnclase9);  
	     View btnclase10 = rootView.findViewById(R.id.btnclase10);  
	     
	     btnclase1.setEnabled(false);
	     btnclase2.setEnabled(false);
	     btnclase3.setEnabled(false);
	     btnclase4.setEnabled(false);
	     btnclase5.setEnabled(false);
	     btnclase6.setEnabled(false);
	     btnclase7.setEnabled(false);
	     btnclase8.setEnabled(false);
	     btnclase9.setEnabled(false);
	     btnclase10.setEnabled(false);
	     
	     
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
