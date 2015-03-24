package br.ufc.dc.sd4mp.reserva_laboratorio;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;


public class MainActivity2 extends ActionBarActivity {

    String nome;
    String siape;
    String email;
    String data;
    String horario;
    String datashow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        Intent intent = getIntent();
        Bundle dados = intent.getExtras();
        this.nome = dados.getString("nome");
        this.siape = dados.getString("siape");
        this.email = dados.getString("email");
        this.data = dados.getString("data");
        this.horario = dados.getString("horario");

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        String[] laboratorios = getResources().getStringArray(R.array.laboratorios);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,laboratorios);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()){
            case R.id.radioButton:
                if (checked){
                    datashow = "sim";
                }
                break;
            case  R.id.radioButton2:
                if(checked){
                    datashow = "nao";
                }
                break;
        }
    }

}
