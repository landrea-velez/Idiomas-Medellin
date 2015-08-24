package co.edu.idiomasmedellin.fragments;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.cipolat.slidenavigation.R;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    ArrayList<Integer> listadoClases = new ArrayList<Integer>();
    
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
			if(esFechaValida(view, year, mes, day)){				
				((TextView) getActivity().findViewById(R.id.textView_fecha)).setText("  " + day + "/" + mes + "/" + year );
				
				
				ParseQuery<ParseObject> query = ParseQuery.getQuery("Clases");
				query.getInBackground("HwyLZHznIy", new GetCallback<ParseObject>() {					 
					public void done(ParseObject clases, ParseException e) {
				    if (e == null) {
				    	leerCuposClasesDia(clases);
				    } else {
				      // something went wrong
				    }
				  }
				});

			}	    			
		}
		
		public void ocultarHorario() {
			((Button) getActivity().findViewById(R.id.btnclase1)).setEnabled(false);
			((Button) getActivity().findViewById(R.id.btnclase2)).setEnabled(false);
			((Button) getActivity().findViewById(R.id.btnclase3)).setEnabled(false);
			((Button) getActivity().findViewById(R.id.btnclase4)).setEnabled(false);
			((Button) getActivity().findViewById(R.id.btnclase5)).setEnabled(false);
			((Button) getActivity().findViewById(R.id.btnclase6)).setEnabled(false);
			((Button) getActivity().findViewById(R.id.btnclase7)).setEnabled(false);
			((Button) getActivity().findViewById(R.id.btnclase8)).setEnabled(false);
			((Button) getActivity().findViewById(R.id.btnclase9)).setEnabled(false);
			((Button) getActivity().findViewById(R.id.btnclase10)).setEnabled(false);
		}
		
		
		public void ocultarTextoFecha(){
			((TextView) getActivity().findViewById(R.id.textView_fecha)).setText("");
		}
		
		
		public Boolean esFechaValida(DatePicker view, int year, int month, int day){
			  if(year < anoActual ){				    	 
			    	 Toast.makeText(getActivity(), "Por favor seleccione un año válido", Toast.LENGTH_LONG).show();		
			    	 ocultarTextoFecha();
			    	 ocultarHorario();
			    	 return false;
			    }else
			    	if (month < mesActual){
			    		Toast.makeText(getActivity(), "Por favor seleccione un mes válido", Toast.LENGTH_LONG).show();
			    		ocultarTextoFecha();
			    		ocultarHorario();
			    		return false;
			    	}else
			    		if(day < diaActual){
			    			Toast.makeText(getActivity(), "Por favor seleccione un día válido", Toast.LENGTH_LONG).show();
			    			ocultarTextoFecha();
			    			ocultarHorario();
			    			return false;
			    		}else
			    		{		    			
			    			Toast.makeText(getActivity(), "Ha seleccionado "+ day + "/" + month + "/" + year , Toast.LENGTH_LONG).show();
			    			return true;		    			

			    		}	 
		}

		
		public void leerCuposClasesDia(ParseObject clases){
			//((Button) getActivity().findViewById(R.id.btnclase1)).setText( ((Button) getActivity().findViewById(R.id.btnclase1)).getText() + "   "+(clases.getInt("clase1")));
			
			System.out.println(" "+(clases.getInt("clase1")));
			System.out.println(" "+(clases.getInt("clase2")));
			System.out.println(" "+(clases.getInt("clase3")));
			
		}
		
		
}