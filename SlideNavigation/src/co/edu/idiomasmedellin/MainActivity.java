package co.edu.idiomasmedellin;

import java.util.ArrayList;

import com.cipolat.slidenavigation.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import co.edu.idiomasmedellin.accesoadatos.LessonsDbHelper;
import co.edu.idiomasmedellin.fragments.LessonListFragment;
import co.edu.idiomasmedellin.fragments.HomeFragment;
import co.edu.idiomasmedellin.fragments.ProfileFragment;

public class MainActivity extends FragmentActivity implements LessonListFragment.Callbacks{
	    private String[] titulos;
	    private DrawerLayout NavDrawerLayout;
	    private ListView NavList;
        private ArrayList<DrawerItemObjct> NavItms;
        private TypedArray NavIcons;
	    private ActionBarDrawerToggle mDrawerToggle;
	    private CharSequence mDrawerTitle;
	    private CharSequence mTitle;
	    DrawerNavigationAdapter NavAdapter;  
	    Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.drawer_main);		
			
			/** Se declara el controlador de la BBDD @LessonsDbHelper 
			 *  Se accede en modo escritura */
			LessonsDbHelper dbHelper = new LessonsDbHelper(getBaseContext());		 
			SQLiteDatabase db = dbHelper.getWritableDatabase();		 
			Toast.makeText(getBaseContext(), "Base de datos preparada", Toast.LENGTH_LONG).show();

			//Drawer Layout
			NavDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
			
			//Lista
	        NavList = (ListView) findViewById(R.id.lista);
	        
	        //Header: el cual sera el layout de header.xml
	        View header = getLayoutInflater().inflate(R.layout.drawer_header, null);
	        
	        //Establece header
	        NavList.addHeaderView(header);
	        
			//Toma listado  de imgs desde drawable
	        NavIcons = getResources().obtainTypedArray(R.array.navigation_iconos);	
	        
			//Toma listado  de titulos desde el string-array de los recursos @string/nav_options
	        titulos = getResources().getStringArray(R.array.nav_options);
	        
	        //Listado de titulos de barra de navegacion
	        NavItms = new ArrayList<DrawerItemObjct>();
	        
	        //Agrega objetos Item_objct al array	   
	        //Inicio
	        NavItms.add(new DrawerItemObjct(titulos[0], NavIcons.getResourceId(0, -1)));
	        //Perfil
	        NavItms.add(new DrawerItemObjct(titulos[1], NavIcons.getResourceId(1, -1)));
	        //Apuntes
	        NavItms.add(new DrawerItemObjct(titulos[2], NavIcons.getResourceId(2, -1)));
	        //Reserva
	        NavItms.add(new DrawerItemObjct(titulos[3], NavIcons.getResourceId(3, -1)));
	        //Misión - Visión
	        NavItms.add(new DrawerItemObjct(titulos[4], NavIcons.getResourceId(4, -1)));
	        //Contacto
	        NavItms.add(new DrawerItemObjct(titulos[5], NavIcons.getResourceId(5, -1)));
	        //Configuración
	        NavItms.add(new DrawerItemObjct(titulos[6], NavIcons.getResourceId(6, -1)));
	      
	        /**Declara y setea adaptador @Drawer_NavigationAdapteral cual le pasa el array con los títulos	  */     
	        NavAdapter= new DrawerNavigationAdapter(this,NavItms);
	        NavList.setAdapter(NavAdapter);	
	       
	        //Siempre mostrar el mismo titulo
	        mTitle = mDrawerTitle = getTitle();
	        
	        //Declara el mDrawerToggle y las imgenes a utilizar
	        mDrawerToggle = new ActionBarDrawerToggle(
	                this,                  /* host Activity */
	                NavDrawerLayout,         /* DrawerLayout object */
	                R.drawable.ic_drawer,  /* Icono de navegacion*/
	                R.string.app_name,  /* "open drawer" description */
	                R.string.hello_world  /* "close drawer" description */
	                ) {

	            /** Called when a drawer has settled in a completely closed state. */
	            public void onDrawerClosed(View view) {
	            	Log.e("Cerrado completo", "!!");
	            }

	            /** Called when a drawer has settled in a completely open state. */
	            public void onDrawerOpened(View drawerView) {
	                Log.e("Apertura completa", "!!");
	            }
	        };	        
	        
	        // Establece que mDrawerToggle declarado anteriormente sea el DrawerListener
	        NavDrawerLayout.setDrawerListener(mDrawerToggle);
	        //Establece que el ActionBar muestre el Boton Home
	        getActionBar().setDisplayHomeAsUpEnabled(true);

	        //Establece la accion al clickear sobre cualquier item del menu.
	        //De la misma forma que un listview.
	        NavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
	            	MostrarFragment(position);
	            }
	        });
	        
	        //Cuando la aplicacion cargue por defecto mostrar la opcion Home
	        MostrarFragment(1);
	        
	        
	}
	
	/**Pasando la posición de la opción en el menu nos mostrara el Fragment correspondiente*/
    private void MostrarFragment(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
        case 1:
            fragment = new HomeFragment();
            break;
        case 2:
            fragment = new ProfileFragment();
            break;
        case 4:
        	fragment = new LessonListFragment();
        	
            break;
        default:
        	//si no esta la opción mostrara un toast y nos mandara a Home
        	Toast.makeText(getApplicationContext(),"Opcion "+titulos[position-1]+"no disponible!", Toast.LENGTH_SHORT).show();
            fragment = new HomeFragment();
            position=1;
            break;
        }
        //Valida si el fragment no es nulo
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
 
            // Actualiza el contenido segun la opcion elegida
            NavList.setItemChecked(position, true);
            NavList.setSelection(position);
            //Cambia el titulo
            setTitle(titulos[position-1]);
            //Cerrarel menu deslizable
            NavDrawerLayout.closeDrawer(NavList);
        } else {
            //Si el fragment es nulo muestra un mensaje de error.
            Log.e("Error  ", "MostrarFragment"+position);
        }
    }
	  
	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            Log.e("mDrawerToggle pushed", "x");
          return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onEntradaSelecionada(String id) {
		// TODO Auto-generated method stub
		
	}
}
