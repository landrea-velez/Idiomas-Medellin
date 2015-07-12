package co.edu.idiomasmedellin.dto;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import co.edu.idiomasmedellin.accesoadatos.LessonsDbHelper;

/**
 * @author landrea.velez
 * Definimos la clase LeccionesDbAdapter para gestionar las operaciones de la entidad LECCION en la base de datos SQLite.
 **/
 
public class LessonsDbAdapter {
 
   /**
    * Definimos constante con el nombre de la tabla
    */
   public static final String C_TABLA = "LECCION" ;
 
   /**
    * Definimos constantes con el nombre de las columnas de la tabla
    */
   public static final String C_COLUMNA_ID   = "_id";
   public static final String C_COLUMNA_NIVEL = "nivel";
   public static final String C_COLUMNA_LECCION = "leccion";
   public static final String C_COLUMNA_NOMBRE = "nombre";

 
   private Context contexto;
   private LessonsDbHelper dbHelper;
   private SQLiteDatabase db;
 
   /**
    * Definimos lista de columnas de la tabla para utilizarla en las consultas a la base de datos
    */
   private String[] columnas = new String[]{ C_COLUMNA_ID, C_COLUMNA_NIVEL, C_COLUMNA_LECCION, C_COLUMNA_NOMBRE} ;
 
   public LessonsDbAdapter(Context context)
   {
      this.contexto = context;
   }
 
   public LessonsDbAdapter abrir() throws SQLException
   {
      dbHelper = new LessonsDbHelper(contexto);
      db = dbHelper.getWritableDatabase();
      return this;
   }
 
   public void cerrar()
   {
      dbHelper.close();
   }
 
   /**
    * Devuelve cursor con todos las columnas de la tabla
    */
   public Cursor getCursor() throws SQLException
   {
      Cursor c = db.query( true, C_TABLA, columnas, null, null, null, null, null, null);
 
      return c;
   }
}



