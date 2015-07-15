package co.edu.idiomasmedellin.dto;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
 
public class LessonsCursorAdapter extends CursorAdapter
{
 
   private LessonsDbAdapter dbAdapter = null ;
 
   public LessonsCursorAdapter(Context context, Cursor c)
   {
      super(context, c);
      dbAdapter = new LessonsDbAdapter(context);
      dbAdapter.abrir();
   }
 
   @Override
   public void bindView(View view, Context context, Cursor cursor)
   {
      TextView tv = (TextView) view ; 
      tv.setText(cursor.getString(cursor.getColumnIndex(LessonsDbAdapter.C_COLUMNA_NIVEL)) + "  " + 
    		  						cursor.getString(cursor.getColumnIndex(LessonsDbAdapter.C_COLUMNA_LECCION)) +"  " +
    		  						cursor.getString(cursor.getColumnIndex(LessonsDbAdapter.C_COLUMNA_NOMBRE)));
    
      /*
       * Es posible mostrar cada campo de latabla en un textview independiente para ello se debe consultar mas
       * sonbre el método bindView*/
      

   }
 
   @Override
   public View newView(Context context, Cursor cursor, ViewGroup parent)
   {
      final LayoutInflater inflater = LayoutInflater.from(context);
      final View view = inflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false);
 
      return view;
   }
}


