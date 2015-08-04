package co.edu.idiomasmedellin.calendar;


import com.cipolat.slidenavigation.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class cal_top_layout extends Fragment {
	
	public cal_top_layout (){		
	}
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
         ViewGroup root = (ViewGroup) inflater.inflate(R.layout.calendar_top_layout, null);
        return root;
    }
 
}