package co.edu.idiomasmedellin;

import java.util.ArrayList;

import com.cipolat.slidenavigation.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerNavigationAdapter extends BaseAdapter {
    private Activity activity;  
	ArrayList<DrawerItemObjct> arrayitms; 

   public DrawerNavigationAdapter(Activity activity,ArrayList<DrawerItemObjct>  listarry) {  
       super();  
       this.activity = activity;  
       this.arrayitms=listarry;
       }     
   //Retorna objeto Item_objct del array list
   @Override
   public Object getItem(int position) {       
       return arrayitms.get(position);
   }   
    public int getCount() {  
      // TODO Auto-generated method stub  
        return arrayitms.size();  
    }    
    @Override
    public long getItemId(int position) {
        return position;
    }   
    //Declara clase estatica la cual representa a la fila
    public static class Fila  
    {  
    		TextView titulo_itm;
    		ImageView icono;
    }  
   public View getView(int position, View convertView, ViewGroup parent) {  
      // TODO Auto-generated method stub  
	   Fila view;  
       LayoutInflater inflator = activity.getLayoutInflater();  
      if(convertView==null)  
       {  
           view = new Fila();
           //Creo objeto item y lo obtengo del array
           DrawerItemObjct itm=arrayitms.get(position);
           convertView = inflator.inflate(R.layout.drawer_item, null);
           //Titulo
           view.titulo_itm = (TextView) convertView.findViewById(R.id.title_item);
           //Seteo en el campo titulo el nombre correspondiente obtenido del objeto
           view.titulo_itm.setText(itm.getTitulo());           
           //Icono
           view.icono = (ImageView) convertView.findViewById(R.id.icon);
           //Seteo el icono
           view.icono.setImageResource(itm.getIcono());           
           convertView.setTag(view);  
        }  
        else  
        {  
           view = (Fila) convertView.getTag();  
        }  
        return convertView;  
    }
}
