package co.edu.idiomasmedellin.fragments;

import com.cipolat.slidenavigation.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*  Fragment para seccion perfil */ 
public class HomeFragment extends Fragment {
     
    public HomeFragment(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
          
        return rootView;
    }
}