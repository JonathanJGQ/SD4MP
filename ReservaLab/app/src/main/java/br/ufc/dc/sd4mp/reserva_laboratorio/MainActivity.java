package br.ufc.dc.sd4mp.reserva_laboratorio;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

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

}


