package br.ufc.dc.sd4mp.mynotes;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;


public class listar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Note note = new Note();
        NoteDAO noteDAO = new NoteDAO(this);
        ListView lv = (ListView) findViewById(R.id.listView);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        List<Note> notes = noteDAO.list();
        Iterator<Note> it = notes.iterator();
        StringBuffer buffer = new StringBuffer();
        while (it.hasNext()) {
            note = it.next();
            buffer.append(note.toString());
            buffer.append("\n");

        }
        TextView list = (TextView) findViewById(R.id.textViewNotes);
        list.setText(buffer.toString());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
