package alert.sd4mp.dc.ufc.br.alertnotification;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import java.util.zip.CheckedInputStream;


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

    public void mudancaBateria(View view){
        CheckBox check = (CheckBox) findViewById(R.id.checkBox);

        if (check.isChecked() == true) {
            Intent i = new Intent(Intent.ACTION_BATTERY_CHANGED);
            i.setAction("br.ufc.dc.ck122.action.BATTERY_CHANGED");
            sendBroadcast(i);
        }
    }

    public void modoAviao(View view){
        CheckBox check = (CheckBox) findViewById(R.id.checkBox2);

        if (check.isChecked() == true) {
            Intent i = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
            i.setAction("br.ufc.dc.ck122.action.AIRPLANE");
            sendBroadcast(i);
        }
    }

    public void carregadorConectado(View view){
        CheckBox check = (CheckBox) findViewById(R.id.checkBox3);

        if (check.isChecked() == true) {
            Intent i = new Intent(Intent.ACTION_POWER_CONNECTED);
            i.setAction("br.ufc.dc.ck122.action.POWER_CONNECTED");
            sendBroadcast(i);
        }
    }

    public void carregadorDesconectado(View view){
        CheckBox check = (CheckBox) findViewById(R.id.checkBox4);

        if (check.isChecked() == true) {
            Intent i = new Intent(Intent.ACTION_POWER_DISCONNECTED);
            i.setAction("br.ufc.dc.ck122.action.POWER_DISCONNECTED");
            sendBroadcast(i);
        }

    }


}
