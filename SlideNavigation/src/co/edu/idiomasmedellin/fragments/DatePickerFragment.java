package co.edu.idiomasmedellin.fragments;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.cipolat.slidenavigation.R;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
 
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

	Calendar cal = new GregorianCalendar();
    Date date = cal.getTime();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    String formatteDate = df.format(date);
    int anoActual = Integer.parseInt(formatteDate.substring(0, 4));
    int mesActual = Integer.parseInt(formatteDate.substring(5, 7));
    int diaActual = Integer.parseInt(formatteDate.substring(8, 10));
    

 
    
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
		
		// Create a new instance of DatePickerDialog and return it
		return new DatePickerDialog(getActivity(), this, year, month, day);
		}
		
		public void onDateSet(DatePicker view, int year, int month, int day) {
		// Do something with the date chosen by the user
		    int mes = month + 1 ;
			System.out.println(" "+mes+"/"+day+"/"+year);
			
		    if(year < anoActual ){				    	 
		    	 Toast.makeText(getActivity(), "Por favor seleccione un año válido", Toast.LENGTH_LONG).show();		
		    	 ((TextView) getActivity().findViewById(R.id.textView_fecha)).setText("");
		    }else
		    	if (month+1 < mesActual){
		    		Toast.makeText(getActivity(), "Por favor seleccione un mes válido", Toast.LENGTH_LONG).show();
		    		((TextView) getActivity().findViewById(R.id.textView_fecha)).setText("");
		    	}else
		    		if(day < diaActual){
		    			Toast.makeText(getActivity(), "Por favor seleccione un día válido", Toast.LENGTH_LONG).show();
		    			((TextView) getActivity().findViewById(R.id.textView_fecha)).setText("");
		    		}else
		    		{		    			
		    			Toast.makeText(getActivity(), "Ha seleccionado "+ day + "/" + mes + "/" + year , Toast.LENGTH_LONG).show();
		    			((TextView) getActivity().findViewById(R.id.textView_fecha)).setText("  " + day + "/" + mes + "/" + year );
		    		}
		    
		    
		    		
			
		}
		
		
}