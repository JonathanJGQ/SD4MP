package todo.sd4mp.dc.ufc.br.mytodolist;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    TarefaDAO tarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void novaTarefaClick(View view){
        Intent t = new Intent(this,InserirTarefaActivity.class);
        startActivity(t);
    }

    public void listarTarefasPendentesClick(View view){
        List<Tarefa> lista;
        ArrayList<Integer> ids = new ArrayList<Integer>();
        tarefa = new TarefaDAO(this);
        lista = tarefa.listarTarefas(0);
        for(int i=0;i<lista.size();i++){
            ids.add(lista.get(i).getId());
        }
        Intent t = new Intent(this,ListarTarefasActivity.class);
        t.putExtra("status","0");
        t.putIntegerArrayListExtra("Ids",ids);
        startActivity(t);
    }
    public void listarTarefasConcluidasClick(View view){
        List<Tarefa> lista;
        ArrayList<Integer> ids = new ArrayList<Integer>();
        tarefa = new TarefaDAO(this);
        lista = tarefa.listarTarefas(1);
        for(int i=0;i<lista.size();i++){
            ids.add(lista.get(i).getId());
        }
        Intent t = new Intent(this,ListarTarefasActivity.class);
        t.putExtra("status","0");
        t.putIntegerArrayListExtra("Ids",ids);
        startActivity(t);
    }
}
