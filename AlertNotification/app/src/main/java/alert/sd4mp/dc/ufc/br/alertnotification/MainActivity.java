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

    static int[] v = {0,0,0,0};

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

    public void checkPress(View view){

        CheckBox box1 = (CheckBox) findViewById(R.id.checkBox);
        CheckBox box2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox box3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox box4 = (CheckBox) findViewById(R.id.checkBox4);

        if(box1.isChecked() == true){
            v[0] = 1;
        }
        else{
            v[0] = 0;
        }
        if(box2.isChecked() == true){
            v[1] = 1;
        }
        else{
            v[1] = 0;
        }
        if(box3.isChecked() == true){
            v[2] = 1;
        }
        else{
            v[2] = 0;
        }
        if(box4.isChecked() == true){
            v[3] = 1;
        }
        else{
            v[3] = 0;
        }

    }


}
