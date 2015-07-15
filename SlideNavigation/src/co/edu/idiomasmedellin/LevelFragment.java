package co.edu.idiomasmedellin;

import com.cipolat.slidenavigation.R;

import android.app.Fragment;
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

/*  Fragment para seccion niveles */ 
public class LevelFragment extends Fragment implements OnClickListener {
     
    public LevelFragment(){
    	
    }
    Button btn;
    
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.levels, container, false);          
        btn = (Button) rootView.findViewById(R.id.btnA1);
        btn.setOnClickListener(this);        
        return rootView;      
     }
    
    @Override
    public void onClick(View v) {
        // implements your things
    	 Log.d("BOTON", "View is not null");
    	/* MainActivity as = new MainActivity();
    	 Intent lessonsActivity = new Intent(as, LessonsActivity.class);
	        startActivity(lessonsActivity);*/
    }

}