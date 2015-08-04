package co.edu.idiomasmedellin;


	import java.util.ArrayList;

import com.cipolat.slidenavigation.R;

import android.app.Activity;
	import android.os.Bundle;
	import android.view.View;
	import android.widget.AdapterView;
	import android.widget.AdapterView.OnItemClickListener;
	import android.widget.ImageView;
	import android.widget.ListView;
	import android.widget.TextView;
	import android.widget.Toast;
import co.edu.idiomasmedellin.dto.LessonsList_Adapter;
import co.edu.idiomasmedellin.dto.LessonsList_Input;

	public class LessonsList_List extends Activity {

		private ListView lista; 

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.lessons_list_list);

	        ArrayList<LessonsList_Input> datos = new ArrayList<LessonsList_Input>();  

	        datos.add(new LessonsList_Input(R.drawable.icono, "A1", "Los sustantivos"));
	        datos.add(new LessonsList_Input(R.drawable.icono, "A1", "Artículos A, An, The"));
	        datos.add(new LessonsList_Input(R.drawable.icono, "A1", "Adjetivos Calificativos Introducción"));
	        datos.add(new LessonsList_Input(R.drawable.icono, "A2", "Verbo TO BE y pronombres personales"));
	        datos.add(new LessonsList_Input(R.drawable.icono, "A2", "Verbo TO BE uso"));
	        datos.add(new LessonsList_Input(R.drawable.icono, "A2", "Preposiciones In, At, On"));
	        datos.add(new LessonsList_Input(R.drawable.icono, "B1", "This-That / These-Those"));
	        datos.add(new LessonsList_Input(R.drawable.icono, "B1", "Verbo TO BE en forma negativa"));
	        
	        lista = (ListView) findViewById(R.id.ListView_listado);
	        lista.setAdapter(new LessonsList_Adapter(this, R.layout.lessons_list_input, datos){
				@Override
				public void onEntrada(Object entrada, View view) {
			        if (entrada != null) {
			            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
			            if (texto_superior_entrada != null) 
			            	texto_superior_entrada.setText(((LessonsList_Input) entrada).get_textoEncima()); 

			            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
			            if (texto_inferior_entrada != null)
			            	texto_inferior_entrada.setText(((LessonsList_Input) entrada).get_textoDebajo()); 

			            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
			            if (imagen_entrada != null)
			            	imagen_entrada.setImageResource(((LessonsList_Input) entrada).get_idImagen());
			        }
				}
			});

	        lista.setOnItemClickListener(new OnItemClickListener() { 
				@Override
				public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
					LessonsList_Input elegido = (LessonsList_Input) pariente.getItemAtPosition(posicion); 

	                CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
	                Toast toast = Toast.makeText(LessonsList_List.this, texto, Toast.LENGTH_LONG);
	                toast.show();
				}
	        });

	    }

	}