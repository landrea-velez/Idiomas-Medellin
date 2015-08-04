package co.edu.idiomasmedellin.calendar;


import com.cipolat.slidenavigation.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class cal_lower_layout extends Fragment {
	
	public cal_lower_layout (){		
	}
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        return inflater.inflate(R.layout.calendar_lower_layout , container, false);
    }
}
