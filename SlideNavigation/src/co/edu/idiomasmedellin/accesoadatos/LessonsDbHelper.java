package co.edu.idiomasmedellin.accesoadatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 *  @author landrea.velez
 *  Since 11/07/2015
 *  Esta clase gestiona la creación de la base de datos la primera vez que se accede a la misma con el método {@link #onCreate} onCreate y
 *  la actualización de la base de datos cuando se detecte un cambio de versión de la misma con el método {@link #onUpdate}onUpdate. 
 *  Hemos llamado a la clase leccionesDbHelper.*  
 * 
 */
 
public class LessonsDbHelper extends SQLiteOpenHelper { 
   
   private static String name = "LeccionDb" ;
   private static CursorFactory factory = null;
   private static int version = 1;
 
   public LessonsDbHelper(Context context)
   {
      super(context, name, factory, version);
   }
 
   @Override
   public void onCreate(SQLiteDatabase db)
   {
      Log.i(this.getClass().toString(), "Creando base de datos");
    
      db.execSQL( "CREATE TABLE LECCION(" +
             " _id INTEGER PRIMARY KEY," +
             " nivel TEXT, " +
             " leccion TEXT, " +
             " nombre TEXT)" );    
         
      Log.i(this.getClass().toString(), "Tabla LECCION creada");
    
      /*
       * Insertamos datos iniciales
       */
      db.execSQL("INSERT INTO LECCION(_id, nivel, leccion, nombre) VALUES(1,'A1', '1.0','Los sustantivos')");
      db.execSQL("INSERT INTO LECCION(_id, nivel, leccion, nombre) VALUES(2,'A1', '1.1','Artículos A, An, The')");
      db.execSQL("INSERT INTO LECCION(_id, nivel, leccion, nombre) VALUES(3,'A1', '1.2','Adjetivos Calificativos Introducción')");
      db.execSQL("INSERT INTO LECCION(_id, nivel, leccion, nombre) VALUES(4,'A1', '1.3','Verbo TO BE y pronombres personales')");
      db.execSQL("INSERT INTO LECCION(_id, nivel, leccion, nombre) VALUES(5,'A1', '1.4','Verbo TO BE uso')");
      db.execSQL("INSERT INTO LECCION(_id, nivel, leccion, nombre) VALUES(6,'A1', '2.0','Preposiciones In, At, On')");
      db.execSQL("INSERT INTO LECCION(_id, nivel, leccion, nombre) VALUES(7,'A1', '2.1','This-That / These-Those')");
      db.execSQL("INSERT INTO LECCION(_id, nivel, leccion, nombre) VALUES(8,'A1', '2.2','Verbo TO BE en forma negativa')");
      db.execSQL("INSERT INTO LECCION(_id, nivel, leccion, nombre) VALUES(9,'A1', '2.3','Verbo TO BE presente interrogativo')");
      db.execSQL("INSERT INTO LECCION(_id, nivel, leccion, nombre) VALUES(10,'A1','2.4','Número 0 al 100')");
      
     
    
      Log.i(this.getClass().toString(), "Datos iniciales HIPOTECA insertados");
    
      Log.i(this.getClass().toString(), "Base de datos creada");
   }
   
 
   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
   {
 
   }
}