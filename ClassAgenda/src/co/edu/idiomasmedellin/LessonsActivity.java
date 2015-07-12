package co.edu.idiomasmedellin;

import com.example.myapp.R;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import co.edu.idiomasmedellin.dto.LessonsCursorAdapter;
import co.edu.idiomasmedellin.dto.LessonsDbAdapter;
 
public class LessonsActivity extends ListActivity {
 
   private LessonsDbAdapter dbAdapter;
    private Cursor cursor;
    private LessonsCursorAdapter lessonsAdapter ;
    private ListView lista;
 
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_lessons);
 
      lista = (ListView) findViewById(android.R.id.list);
 
      dbAdapter = new LessonsDbAdapter(this);
      dbAdapter.abrir();
 
      consultar();
   }
 
   private void consultar()
   {
      cursor = dbAdapter.getCursor();
      startManagingCursor(cursor);
      lessonsAdapter = new LessonsCursorAdapter(this, cursor);
      lista.setAdapter(lessonsAdapter);
   }
 
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }
}

