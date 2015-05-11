package todo.sd4mp.dc.ufc.br.mytodolist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;


public class InserirTarefaActivity extends ActionBarActivity {

    TarefaDAO tarefaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_tarefa);
        tarefaDAO = new TarefaDAO(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inserir_tarefa, menu);
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

    public void voltarClick(View view){
        finish();
    }

    public void addTarefa(View view) {
        EditText tituloText = (EditText) findViewById(R.id.editText);
        EditText descricaoText = (EditText) findViewById(R.id.editText2);
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(tituloText.getText().toString());
        tarefa.setDescricao(descricaoText.getText().toString());
        tarefa.setStatus(0);
        tarefaDAO.inserirTarefa(tarefa);

        Toast.makeText(this,"Tarefa Cadastrada",Toast.LENGTH_SHORT).show();
        tituloText.setText("");
        descricaoText.setText("");
    }
}
