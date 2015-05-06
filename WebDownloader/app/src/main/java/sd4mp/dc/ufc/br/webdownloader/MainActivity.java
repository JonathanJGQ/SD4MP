package sd4mp.dc.ufc.br.webdownloader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private ConnectivityManager connManager;

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

    public void checkConnection(View view){
        connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        TextView text = (TextView) findViewById(R.id.textView2);
        EditText edit = (EditText) findViewById(R.id.editText);
        //text.setText(edit.getText());

        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            Toast.makeText(this,"Conectado!", Toast.LENGTH_SHORT).show();
            // Baixar negoço!
            DownloaderTask dt = new DownloaderTask((TextView) findViewById(R.id.textView2));
            dt.onPostExecute(dt.doInBackground(edit.getText().toString()));
        }
        else{
            Toast.makeText(this,"Se conecte a alguma rede.", Toast.LENGTH_SHORT).show();
        }
    }
}
