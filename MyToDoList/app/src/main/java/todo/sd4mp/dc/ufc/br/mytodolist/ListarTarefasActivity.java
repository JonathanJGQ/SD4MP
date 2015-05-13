package todo.sd4mp.dc.ufc.br.mytodolist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ListarTarefasActivity extends ActionBarActivity {

    TarefaDAO tarefaDAO;
    String status;
    ArrayList<Integer> ids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_tarefas);
        tarefaDAO = new TarefaDAO(this);
        pegarTarefas();
        status = getIntent().getStringExtra("status");
        ids = getIntent().getIntegerArrayListExtra("ids");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listar_tarefas, menu);
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

    private void pegarTarefas(){
        ListView lv = (ListView) findViewById(R.id.listView);
        List<Tarefa> lista;
        List<String> titulos = new ArrayList<String>();
        if(status.equals("0")) {
            lista = tarefaDAO.listarTarefas(0);
        }
        else{
            lista = tarefaDAO.listarTarefas(1);
        }
        for(int i=0;i<lista.size();i++){
            titulos.add(lista.get(i).getTitulo());
        }
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2,android.R.id.text1,titulos);
        lv.setAdapter(ad);
    }

    public void alterarTarefa(View view){
        int id;
        ListView lv = (ListView) findViewById(R.id.listView);
        id = lv.getSelectedItemPosition();
        Intent t = new Intent(this,AlterarTarefaActivity.class);
        t.putExtra("id",id);
        startActivity(t);
    }
}
