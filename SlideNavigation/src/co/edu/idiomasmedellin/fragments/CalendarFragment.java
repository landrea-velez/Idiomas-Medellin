package co.edu.idiomasmedellin.fragments;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.cipolat.slidenavigation.R;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;
import android.widget.CalendarView.OnDateChangeListener;

 
public class CalendarFragment extends FragmentActivity {
	
	CalendarView calendar;
	Calendar cal = new GregorianCalendar();
    Date date = cal.getTime();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    String formatteDate = df.format(date);
    int anoActual = Integer.parseInt(formatteDate.substring(0, 4));
    int mesActual = Integer.parseInt(formatteDate.substring(5, 7));
    int diaActual = Integer.parseInt(formatteDate.substring(8, 10));
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_activity_main);
        
      //inicializa la vista del calendario
		initializeCalendar();
    }
    
    public void initializeCalendar() {
		calendar = (CalendarView) findViewById(R.id.calendar);

		// no mostrar el numero de la semana.
		calendar.setShowWeekNumber(false);

		// Establece el lunes como el primer día del calendario
		calendar.setFirstDayOfWeek(2);

		/*The background color for the selected week.
		calendar.setSelectedWeekBackgroundColor(getResources().getColor(R.color.green));
		
		//sets the color for the dates of an unfocused month. 
		calendar.setUnfocusedMonthDateColor(getResources().getColor(R.color.transparent));
	
		//sets the color for the separator line between weeks.
		calendar.setWeekSeparatorLineColor(getResources().getColor(R.color.transparent));
		
		//sets the color for the vertical bar shown at the beginning and at the end of the selected date.
		calendar.setSelectedDateVerticalBar(R.color.darkgreen);*/
		
		
		//sets the listener to be notified upon selected date change.
		calendar.setOnDateChangeListener(new OnDateChangeListener() {
                       //show the selected date as a toast
			@Override
			public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
				
			    Log.d("FECHA ACTUAL", " "+formatteDate);				    
			    
			    Log.d("AÑO ACTUAL", " "+formatteDate.substring(0, 4));
			    Log.d("MES ACTUAL", " "+formatteDate.substring(5, 7));
			    Log.d("DIA ACTUAL", " "+formatteDate.substring(8, 10));
				
			    
			    Log.d("AÑO SELECCIONADO", " "+year);
			    Log.d("MES SELECCIONADO", " "+month);
			    Log.d("DIA SELECCIONADO", " "+day);
			    
			   if(year < anoActual ){				    	 
			    	 Toast.makeText(getApplicationContext(), "Por favor seleccione un año válido", Toast.LENGTH_LONG).show();
					 //initializeCalendar();
			    }else
			    	if (month+1 < mesActual){
			    		Toast.makeText(getApplicationContext(), "Por favor seleccione un mes válido", Toast.LENGTH_LONG).show();
			    	}else
			    		if(day < diaActual){
			    			Toast.makeText(getApplicationContext(), "Por favor seleccione un día válido", Toast.LENGTH_LONG).show();
			    		}else
			    		{
			    			int mes = month+1;
			    			Toast.makeText(getApplicationContext(), "Ha seleccionado "+ day + "/" + mes + "/" + year , Toast.LENGTH_LONG).show();
			    		}
			    					 
			    
				
				
			}
		});
	}
    
    
}
