package todo.sd4mp.dc.ufc.br.mytodolist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class AlterarTarefaActivity extends ActionBarActivity {

    Tarefa t;
    TarefaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_tarefa);
        EditText txtTitulo = (EditText) findViewById(R.id.editText3);
        EditText txtDescricao = (EditText) findViewById(R.id.editText4);
        EditText txtData = (EditText) findViewById(R.id.editText5);
        CheckBox cbxStatus = (CheckBox) findViewById(R.id.checkBox);
        int id = Integer.parseInt(getIntent().getStringExtra("id"));
        dao = new TarefaDAO(this);
        t = dao.consultarTarefa(id+1);

        txtTitulo.setText(t.getTitulo());
        txtDescricao.setText(t.getDescricao());
        txtData.setText(t.getDataCriacao());
        if(t.getId() == 1) {
            cbxStatus.setChecked(true);
        }
        else{
            cbxStatus.setChecked(false);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alterar_tarefa, menu);
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

    public void voltarOnClick(View view){
        finish();
    }

    public void deletarOnClick(View view){
        dao.deletarTarefa(t.getId() + 1);
        Toast.makeText(this,"Tarefa excluida",Toast.LENGTH_SHORT);
        finish();
    }
}
