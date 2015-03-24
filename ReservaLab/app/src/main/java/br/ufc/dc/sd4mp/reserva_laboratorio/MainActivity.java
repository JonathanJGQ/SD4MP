package br.ufc.dc.sd4mp.reserva_laboratorio;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

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
    public void showDatePickerDialog(View view){
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setData((EditText) findViewById(R.id.editText4));
        newFragment.show(getFragmentManager(), "datePicker");
    }
    public void showTimePickerDialog(View view){
        TimePickerFragment newFragment = new TimePickerFragment();
        newFragment.setHour((EditText) findViewById(R.id.editText5));
        newFragment.show(getFragmentManager(),"timePicker");
    }

    public void continuarClick(View view){

        EditText nomeProf = (EditText)findViewById(R.id.editText);
        EditText siape = (EditText)findViewById(R.id.editText2);
        EditText email = (EditText)findViewById(R.id.editText3);
        EditText data = (EditText)findViewById(R.id.editText4);
        EditText horario = (EditText)findViewById(R.id.editText5);

        if(nomeProf.getText().toString().equals("")){
            alerta();
            return;
        }
        else if(siape.getText().toString().equals("")){
            alerta();
            return;
        }
        else if(email.getText().toString().equals("")){
            alerta();
            return;
        }
        else if(data.getText().toString().equals("")){
            alerta();
            return;
        }
        else if(horario.getText().toString().equals("")){
            alerta();
            return;
        }


        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        Bundle dados = new Bundle();
        dados.putString("nome",nomeProf.getText().toString());
        dados.putString("siape",siape.getText().toString());
        dados.putString("email",email.getText().toString());
        dados.putString("data",data.getText().toString());
        dados.putString("horario",horario.getText().toString());
        intent.putExtras(dados);
        startActivity(intent);
    }

    private void alerta(){

        AlertDialog alerta;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Aviso");
        builder.setMessage("Preencha todos os campos para continuar!");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                //Toast.makeText(MainActivity.this, "OK=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        alerta = builder.create();
        alerta.show();



    }

}


