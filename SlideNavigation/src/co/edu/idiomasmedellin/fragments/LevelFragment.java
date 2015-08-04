package co.edu.idiomasmedellin.fragments;

import com.cipolat.slidenavigation.R;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import co.edu.idiomasmedellin.LessonsList_List;
import co.edu.idiomasmedellin.MainActivity;

/*  Fragment para seccion niveles */ 
public class LevelFragment extends Fragment implements OnClickListener {
     
    public LevelFragment(){
    	
    }
    Button btnA1;
    Button btnA2;
    Button btnB1;
    Fragment fragment = null;
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

       View rootView = inflater.inflate(R.layout.fragment_levels, container, false);
       btnA1 = (Button) rootView.findViewById(R.id.btnA1);
       btnA2 = (Button) rootView.findViewById(R.id.btnA2);
       btnB1 = (Button) rootView.findViewById(R.id.btnB1);
       
       btnA1.setOnClickListener(this); 
       btnA2.setOnClickListener(this); 
       btnB1.setOnClickListener(this); 
       
       return rootView;
    }
    
    
     
   
    @Override
    public void onClick(View v) {
        // implements your things
    	
    	switch (v.getId()) {
        case R.id.btnA1:
        	Log.d("BOTON", "1");    
        	
        	Intent intent = new Intent();
            intent.setClass(getActivity(), CalendarFragment.class);            
            startActivity(intent);
        	
        	/*fragment = new LessonFragment();
            if (fragment != null) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();    
            }else{
                Log.e("Error ", "MostrarFragment");
             }           */
            break;
            
        case R.id.btnA2:
        	Log.d("BOTON", "2");
        	fragment = new HomeFragment();
            if (fragment != null) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();    
	        }else{
	        	Log.e("Error  ", "MostrarFragment");
	        }
        break;
            
        case R.id.btnB1:
        	Log.d("BOTON", "3");
        	fragment = new HomeFragment(); 
            if (fragment != null) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();    
            }else{
            	Log.e("Error  ", "MostrarFragment");
        	}
            break;
    }
    	

    }

}